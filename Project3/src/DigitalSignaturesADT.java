
import java.math.BigInteger;


/**
 * This defines the interface for DigitalSignatures that
 * applies a digital signature to a message using a private key
 * and a public key
 * @author Brad Vogeler & yunwang
 */
public interface DigitalSignaturesADT {

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



    public BigInteger Encrypt(BigInteger privateKey, BigInteger msg, BigInteger hash);

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
    public boolean Authenticate(BigInteger publicKey, BigInteger cipher, BigInteger hash);
}