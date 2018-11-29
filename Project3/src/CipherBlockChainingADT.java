
import java.math.BigInteger;


/**
 * This defines the interface for shiftCiper that
 * encrypts and decrypts a given BigInteger using a shared key
*
* @author Brad Vogeler
* @date 9/30/2018
*/
public interface CipherBlockChainingADT {
    
    /**
     * Encrypt a BigInteger "msg" with a given key "map".
     * For example, 
     * Suppose "msg = 10110" and 
     * "map =	00001,00010,00011,00100,00101,00110,00111,01000,
     * 			01001,01010,01011,01100,01101,01110,01111,10000,
     * 			10001,10010,10011,10100,10101,10110,10111,11000,
     * 			11001,11010,11011,11100,11101,11110,11111,00000";
     * Encrypt(10110) return "10111"
     *
     * @param msg  the message
     * @param map  the mapping to substitute letters with
     * @return encrypted message
     * 
     */


    public BigInteger Encrypt(BigInteger msg, BigInteger[] map);
    
    /**
     * Encrypt a BigInteger "cipher" with a given key "map".
     * For example, 
     * Suppose "cipher = 00001" and 
     * "map =	00001,00010,00011,00100,00101,00110,00111,01000,
     * 			01001,01010,01011,01100,01101,01110,01111,10000,
     * 			10001,10010,10011,10100,10101,10110,10111,11000,
     * 			11001,11010,11011,11100,11101,11110,11111,00000";
     * Encrypt(00001) return "00000"
     *
     * @param cipher  the message
     * @param map  the mapping to substitute letters with
     * @return decrypted message
     * 
     */

    public BigInteger Decrypt(BigInteger cipher,BigInteger[] map);
    
    
    /**
     * convert a String into Binary
     * For example, 
     * Suppose "A"
     * ConvertStringToBinary(A) return BigInteger("11000001")
     *
     * @param str  String to be converted to binary
     * @return Converted String
     * 
     */
    public String ConvertStringToBinary(String str);
    
    /**
     * convert a String into Binary
     * For example, 
     * Suppose "A"
     * ConvertStringToBinary(A) return BigInteger("11000001")
     *
     * @param str  String to be converted to binary
     * @return Converted String
     * 
     */
    
}
