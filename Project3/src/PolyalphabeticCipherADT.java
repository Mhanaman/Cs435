
import java.math.BigInteger;


/**
 * This defines the interface for PolyalphabeticalCipher that
 * encrypts and decrypts a given BigInteger using a shared key
 * @author Brad Vogeler & yunwang
 */
public interface PolyalphabeticCipherADT {
    
    /**
     * Encrypt a BigInteger "msg" with a given key "shift".
     * For example, 
     * Suppose "msg = 1,0,5,2,1" and "shift = 1,3,4,3,2";
     * Encrypt(10521, 13432) return "23953"
     *
     * @param msg  the message
     * @param shift the shift encryption pattern
     * @return encrypted message
     * 
     */


    public BigInteger Encrypt(BigInteger msg, BigInteger shift);
    
     /**
     * Decrypt a BigInteger "cipher" with a given key "shift".
     * For example, 
     * Suppose "cipher = 15" and "shift = 5";
     * Decrypt(15, 5) return "10"
     *
     * @param cipher  the encrypted msg
     * @param shift the shift encryption key
     * @return encrypted message
     * 
     */

    public BigInteger Decrypt(BigInteger cipher, BigInteger shift);
    
}
