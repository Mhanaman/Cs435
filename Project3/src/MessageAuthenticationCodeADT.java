
import java.math.BigInteger;


/**
 * This defines the interface for MessageAuthenticationCode that
 * encrypts and decrypts a given BigInteger using a shared secret and
 * hash and checks authentication
 * @author Brad Vogeler & yunwang
 */
public interface MessageAuthenticationCodeADT {

    /**
     * Encrypt a BigInteger "msg" with a given hash and secret
     * For example, 
     * Suppose "secret = 5, msg = 1,0,3" and "hash = 3";
     * Encrypt(5, 10, 3) return "0103"
     *
     * @param secret the secret to be added to the front
     * @param msg  the message
     * @param hash  The hash number
     * @return encrypted message
     * 
     */



    public BigInteger Encrypt(BigInteger secret, BigInteger msg, BigInteger hash);

    /**
    * Authenticate a BigInteger "cipher" using a has and a secret
    * For example, 
    * Suppose "secret = 5, msg = 0,1,0,3" and "hash = 3";
    * Encrypt(5, 0103, 3) return "103"
    *
    * @param secret the secret to be added to the front
    * @param msg  the message
    * @param hash  The hash number
    * @return if message has been modified or not
    * 
    */
    public boolean Authenticate(BigInteger secret, BigInteger cipher, BigInteger hash);
}