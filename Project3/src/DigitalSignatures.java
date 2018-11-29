
import java.math.BigInteger;


/**
 * This class applies a digital signature to a message. 
*
* @author Brad Vogeler
* @date 9/30/2018
*/
public class DigitalSignatures implements DigitalSignaturesADT {


    /**
     * Encrypt a BigInteger "msg" with a given hash
     * For example, 
     * Suppose "privateKey= 2755, msg = 1,0,3" and "hash = 3";
     * Encrypt(2755, 0103, 3) return "0103"
     *
     * @param privateKey The private key
     * @param msg  the message
     * @param hash  The hash number
     * @return digitally signed message
     * 
     */


    public BigInteger Encrypt(BigInteger msg, BigInteger hash, BigInteger privateKey) {
    	//hash the message then encrypt the key
    	BigInteger encryptedKey = msg.mod(hash);
    	encryptedKey = encryptedKey.modPow(privateKey, hash);
    	
    	//combine msg and encrpyted key
    	encryptedKey = encryptedKey.add(new BigInteger("10").pow(hash.toString().length()));
    	
    	return new BigInteger(""+msg.toString()+encryptedKey.toString());
    }
    
    /**
     * Authenticate a BigInteger "cipher" using a hash and a publicKey
     * For example, 
     * Suppose "publicKey= 355, msg = 1,0,3" and "hash = 3";
     * Encrypt(355, 0103, 3) return "0103"
     *
      * @param publicKey The public key
     * @param msg  the message
     * @param hash  The hash number
     * @return if it is from that computer or not
     * 
     */

    public boolean Authenticate(BigInteger msg, BigInteger hash, BigInteger publicKey) {
    	//locate the key at the end of the message
    	int keyLocation = msg.toString().length()-hash.toString().length();
    	
    	//store the key from the end of the message
    	String key = msg.toString().substring(keyLocation, msg.toString().length());
    	
    	BigInteger messageNoKey = new BigInteger(msg.toString().substring(0,keyLocation-1));
    	
    	
    	//compare hashes
    	if(messageNoKey.mod(hash).equals(new BigInteger(key).modPow(publicKey, hash)))
    		return true;
    	return false;
    }

}
