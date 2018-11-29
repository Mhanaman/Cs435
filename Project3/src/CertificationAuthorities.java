import java.math.BigInteger;


/**
 * This class encrypts a given BigInteger message using the CertificationAuthorities. 
*
* @author Brad Vogeler
* @date 9/30/2018
*/
public class CertificationAuthorities implements CertificationAuthoritiesADT {

    /**
     * Encrypt the user's public key with a certificate Private Key and send 
     * back the encrypted public key
     * For example, 
     * Suppose "userPublicKey = (127,177), and certificatePrivateKey = (103,155)
     * Encrypt(127177, 103155) return "1048077"
     *
     * @param userPublicKey the Public Key of the user
     * @param certificatePrivateKey  the private key of the certificate
     * @return encrypted user public key
     * 
     */
    public BigInteger Encrypt(BigInteger userPublicKey, BigInteger certificatePrivateKey) {
    	//split up the keys
    	BigInteger certificateKey = new BigInteger(certificatePrivateKey.toString().substring(0,3));
    	BigInteger certificateHash = new BigInteger(certificatePrivateKey.toString().substring(3,6));

    	BigInteger userKey = new BigInteger(userPublicKey.toString().substring(0,userPublicKey.toString().length()/2));
    	BigInteger userHash = new BigInteger(userPublicKey.toString().substring(userPublicKey.toString().length()/2,userPublicKey.toString().length()));

/*
    	//subtract the 100's from transmission
    	certificateKey = certificateKey.subtract(new BigInteger("100"));
    	certificateHash = certificateHash.subtract(new BigInteger("100"));
    	userKey = userKey.subtract(new BigInteger("100"));
    	userHash = userHash.subtract(new BigInteger("100"));
    	*/
    	//encrypt User Public Key and Hash using the Certification Private Key and Hash
    	BigInteger encryptedCertificationHash = userHash.modPow(certificateKey, certificateHash);
    	BigInteger encryptedCertificationKey = userKey.modPow(certificateKey, certificateHash);
    	
    	encryptedCertificationKey = encryptedCertificationKey.add(new BigInteger("100"));
    	encryptedCertificationHash = encryptedCertificationHash.add(new BigInteger("100"));
    	
    	encryptedCertificationKey = new BigInteger(""+encryptedCertificationKey.toString()+encryptedCertificationHash.toString());
    	//add for transmission
    	return new BigInteger("1"+encryptedCertificationKey);
    }
    
    
    
    /**
     * Decrypt the certificate and return the user's public key 
     * For example, 
     * Suppose "userCertificate = (048,055), and certificatePublicKey = (029,055)
     * Encrypt(1048055, 1029055) return "127177"
     *
     * @param userCertificate the Encrypted Public Key of the user
     * @param certificatePublicKey  the public key of the certificate
     * @return the Public Key of the user
     * 
     */
    public BigInteger Decrypt(BigInteger userCertificate, BigInteger certificatePublicKey) {
    	//split up the keys
    	BigInteger certificateKey = new BigInteger(certificatePublicKey.toString().substring(0,3));
    	BigInteger certificateHash = new BigInteger(certificatePublicKey.toString().substring(3,6));
    	

    	BigInteger userKey = new BigInteger(userCertificate.toString().substring(0,userCertificate.toString().length()/2));
    	BigInteger userHash = new BigInteger(userCertificate.toString().substring(userCertificate.toString().length()/2,userCertificate.toString().length()));

    	//subtract the 100's from transmission
    	//certificateKey = certificateKey.subtract(new BigInteger("100"));
    	//certificateHash = certificateHash.subtract(new BigInteger("100"));
    	userKey = userKey.subtract(new BigInteger("100"));
    	userHash = userHash.subtract(new BigInteger("100"));
    	
    	userKey = userKey.modPow(certificateKey, certificateHash);
    	userHash = userHash.modPow(certificateKey, certificateHash);
    	
    	/*
    	//add for transmission
    	userKey = userKey.add(new BigInteger("100"));
    	userHash = userHash.add(new BigInteger("100"));*/
    	
    	//return the User Public Key
    	return new BigInteger(""+userKey.toString()+userHash.toString());
    	
    }

}
