import java.math.BigInteger;

/**
 * This defines the interface for RSAADT that
 * encrypts and decrypts a given BigInteger using 2 prime numbers p & q.
 * @author Brad Vogeler
 */
public interface RSA_ADT {
    
    
	/**
     * Encrypt a BigInteger "msg" with a given publicKey
     * For example, 
     * Suppose "msg = 184" and "e = 3" and "n = 55";
     * Encrypt(184,3,55) return "32"
     *
     * @param msg  the message
     * @param e a prime number from the publicKey
     * @param n a number from the publicKey
     * @return encrypted message
     * 
     */


    public BigInteger Encrypt(BigInteger msg, BigInteger e, BigInteger n);
    
    
    /**
     * Decrypt a BigInteger "cipher" with a given privateKey
     * For example, 
     * Suppose "cipher = 32" and "d = 27" and "n = 55";
     * Decrypt(32,27,55) return "184"
     *
     * @param cipher  the encrypted msg
     * @param d a prime number from the privateKey
     * @param n a number from the publicKey
     * @return decrypted message
     * 
     */

    public BigInteger Decrypt(BigInteger cipher, BigInteger d, BigInteger n);

    /**
     * Create a random relatively prime BigInteger "e".
     * For example, 
     * Suppose "p=55"
     * CreateE(55) return 3
     *
     * @param p  prime number 1
     * @param q  prime number 2
     * @return new BigInteger n
     * 
     */
    
    public BigInteger CreateE(BigInteger n);
    
    /**
     * Create a BigInteger "n".
     * For example, 
     * Suppose "p=5 & q=11"
     * CreateN(5,11) return 55
     *
     * @param p  prime number 1
     * @param q  prime number 2
     * @return new BigInteger n
     * 
     */
    
    public BigInteger CreateN(BigInteger p, BigInteger q);
   
    
    /**
     * Create a BigInteger "z".
     * For example, 
     * Suppose "p=5 & q=11"
     * CreateN(5,11) return 40
     *
     * @param p  prime number 1
     * @param q  prime number 2
     * @return new BigInteger z
     * 
     */
    
    public BigInteger CreateZ(BigInteger p, BigInteger q);
    

    /**
     * Return a boolean of whether this number is prime or not
     * For example, 
     * Suppose "num=5"
     * CreateN(5) return true
     *
     * @param num  number to check
     * @return new boolean isPrime
     * 
     */
	public boolean isPrime(BigInteger num);
}
