
import java.math.BigInteger;


/**
 * This class encrypts a given BigInteger message using the ShiftCipher. 
*
* @author Brad Vogeler
* @date 9/30/2018
*/
public class ShiftCipher implements ShiftCipherADT {

    /**
     * Encrypt a BigInteger "msg" with a given key "shift".
     * For example, 
     * Suppose "msg = 10" and "shift = 5";
     * Encrypt(10, 5) return "15"
     *
     * @param msg  the message
     * @param shift the shift encryption key
     * @return encrypted message
     * 
     */

    public  BigInteger Encrypt(BigInteger msg, BigInteger shift) {
    	
    	return msg.add(shift);
    	/*
    	String encryptedMessage = "";
    	String message=msg.toString();
    	
    	for(int i=0; i+2<message.length();i+=3) {
    		//take 3 numbers of the big integer
        	String encryptedLetter =""+message.charAt(i);
    		encryptedLetter+=message.charAt(i+1);
    		encryptedLetter+=message.charAt(i+2);
    		
    		//shift those 3 numbers by adding the shift
    		int addEncrypt = Integer.parseInt(encryptedLetter)+shift.intValue();
    		
    		//add encrypted letter to the string to be returned
    		encryptedMessage+=addEncrypt;
    	}
    	return new BigInteger(encryptedMessage);*/
    }

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
    
    public  BigInteger Decrypt(BigInteger cipher, BigInteger shift) {
    	return cipher.subtract(shift);
    	
    	/*
    	String decrytpedMessage="";
    	String cipherText=cipher.toString();
    	

    	for(int i=0; i+2<cipherText.length();i+=3) {
    		//take 3 numbers of the big integer
        	String decryptedLetter =""+cipherText.charAt(i);
        	decryptedLetter+=cipherText.charAt(i+1);
        	decryptedLetter+=cipherText.charAt(i+2);
    		
    		//shift those 3 numbers by adding the shift
    		int addDecrypt = Integer.parseInt(decryptedLetter)-shift.intValue();
    		
    		//add encrypted letter to the string to be returned
    		decrytpedMessage+=addDecrypt;
    	}
    	return new BigInteger(decrytpedMessage);*/
    }

}
