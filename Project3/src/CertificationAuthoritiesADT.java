
import java.math.BigInteger;


/**
 * This defines the interface for CertificationAuthorities that
 * encrypts and decrypts a given BigInteger using a shared secret and
 * hash and checks authentication
 * @author Brad Vogeler
 */
public interface CertificationAuthoritiesADT {
	
	 /**
     * Encrypt the user's public key with a certificate Private Key and send 
     * back the encrypted public key with the certificate's hash
     * For example, 
     * Suppose "userPublicKey = (27,77), and certificatePrivateKey = (3,55)
     * Encrypt(127177, 103155) return "4855"
     *
     * @param userPublicKey the Public Key of the user
     * @param certificatePrivateKey  the private key of the certificate
     * @return encrypted public key with the certificate's hash
     * 
     */
    public BigInteger Encrypt(BigInteger userPublicKey, BigInteger certificatePrivateKey);


    /**
     * Decrypt the certificate and return the user's public key 
     * For example, 
     * Suppose "userCertificate = (148), and certificatePublicKey = (29,55)
     * Encrypt(148155, 103155) return "127177"
     *
     * @param userCertificate the Encrypted Public Key of the user
     * @param certificatePublicKey  the public key of the certificate
     * @return the Public Key of the user
     * 
     */
    public BigInteger Decrypt(BigInteger userCertificate, BigInteger certificatePublicKey);
}