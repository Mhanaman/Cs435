import java.math.BigInteger;
/**
 * This class encrypts a given BigInteger message using the Polyalphabetic Cipher. 
*
* @author Brad Vogeler
* @date 9/30/2018
*/
public class PolyalphabeticCipher implements PolyalphabeticCipherADT {
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


    public BigInteger Encrypt(BigInteger msg, BigInteger shift) {
    	String encryptedMessage = "";
    	
    	for(int i=0; i<msg.toString().length();i++) {
    		 int e = Integer.parseInt(msg.toString().substring(i, i+1))+Integer.parseInt(shift.toString().substring(i, i+1))%10;
    		if(e >= 10)
    			e-=10;
    		 encryptedMessage += e;
    	}
    	return new BigInteger(encryptedMessage);
    	
    	/*String encryptedMessage = "";
    	String message=msg.toString();
    	
    	System.out.println(message);
    	for(int i=0; i+2<message.length();i+=3) {
    		//take 3 numbers of the big integer
        	String encryptedLetter =""+message.charAt(i);
    		encryptedLetter+=message.charAt(i+1);
    		encryptedLetter+=message.charAt(i+2);

        	System.out.println(encryptedLetter);
    		//get and store the shift location
    		int shiftLocation =(i/3)%shift.toString().length();
    		//get and store shift amount using getNumericValue from character class
    		int shiftAmount = Character.getNumericValue(shift.toString().charAt(shiftLocation));
        	System.out.println(shiftAmount);
    		
    		//shift those 3 numbers by adding the shift
    		int addEncrypt = (Integer.parseInt(encryptedLetter))+shiftAmount;
    		
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

    public BigInteger Decrypt(BigInteger cipher, BigInteger shift) {
    	String decryptedMessage = "";
    	
    	for(int i=0; i<cipher.toString().length();i++) {
    		int d = Integer.parseInt(cipher.toString().substring(i, i+1))-Integer.parseInt(shift.toString().substring(i, i+1));
    		
    		if(d < 0) {
    			d += 10;
    		}
    		decryptedMessage += d;
    	}
    	return new BigInteger(decryptedMessage);
    	
    	
    	
    	
    	/*String decryptedMessage = "";
    	String message=cipher.toString();
    	
    	for(int i=0; i+2<message.length();i+=3) {
    		//take 3 numbers of the big integer
        	String decryptedLetter =""+message.charAt(i);
        	decryptedLetter+=message.charAt(i+1);
        	decryptedLetter+=message.charAt(i+2);
    		
    		//get and store the shift location
    		int shiftLocation =(i/3)%shift.toString().length();
    		//get and store shift amount using getNumericValue from character class
    		int shiftAmount = Character.getNumericValue(shift.toString().charAt(shiftLocation));
    		
    		//shift those 3 numbers by adding the shift
    		int addEncrypt = (Integer.parseInt(decryptedLetter))-shiftAmount;
    		
    		//add encrypted letter to the string to be returned
    		decryptedMessage+=addEncrypt;
    	}
    	return new BigInteger(decryptedMessage);*/
    }
}
