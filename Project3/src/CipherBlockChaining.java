import java.math.BigInteger;

/**
 * encrypts and decrypts a given BigInteger using a shared key and 
 * the previous letter of the text
*
* @author Brad Vogeler
* @date 9/30/2018
*/
public class CipherBlockChaining implements CipherBlockChainingADT {
	
	//128 in binary uses 8 digits
	private final int BLOCK_SIZE = 8;

	/**
     * Encrypt a BigInteger "msg" with a given key "map".
     * For example, 
     * Suppose "msg = 00 10 01 11" and 
     * "map =	11,10,01,00"
     * Encrypt(00100111) return "00111101"
     *
     * @param msg  IV + the message
     * @param map  the mapping to substitute letters with
     * @return encrypted message
     * 
     */
	public BigInteger Encrypt(BigInteger msg, BigInteger[] map) {

    	String message=msg.toString();
    	
    	if(msg.toString().length()<6)
    		//there are not 2 letters in the msg
    		return null;
    	//set to IV
    	BigInteger previousCipherText = new BigInteger(""+message.substring(0,3));
    	previousCipherText = previousCipherText.subtract(new BigInteger("100"));
    	
    	//add IV to the cipher text
    	String encryptedMessage = ConvertStringToBinary(previousCipherText.toString());
    	
    	for(int i=3; i+2<message.length();i+=3) {
    		//take 3 numbers of the big integer
        	String encryptedLetter =""+message.charAt(i);
    		encryptedLetter+=message.charAt(i+1);
    		encryptedLetter+=message.charAt(i+2);
    		
    		//subtract the 100 from transmission
    		BigInteger addEncrypt=new BigInteger(""+(Integer.parseInt(encryptedLetter)-100));

        	System.out.println(previousCipherText);
        	System.out.println(addEncrypt);
    		//xor the previous letter and current letter
    		addEncrypt= addEncrypt.xor(previousCipherText);
			
    		//encrypt letter
    		System.out.println(addEncrypt.intValueExact());
    		System.out.println(map.length);
    		addEncrypt=new BigInteger(""+map[addEncrypt.intValueExact()]);

    		//set previous letter to this current letter
    		previousCipherText=new BigInteger(""+(Integer.parseInt(addEncrypt.toString(),2)-128));
    		
    		//add encrypted letter to the string to be returned
    		encryptedMessage+=addEncrypt;
    	}
		return new BigInteger(""+encryptedMessage);
	}
	
	/**
     * Decrypt a BigInteger "IV + cipher" with a given key "map".
     * For example, 
     * Suppose "msg = 00 11 11 01" and 
     * "map =	11,10,01,00"
     * Decrypt(00111101) return "100111"
     *
     * @param cipher  IV + the message
     * @param map  the mapping to substitute letters with
     * @return decrypted message - IV
     * 
     */
	public BigInteger Decrypt(BigInteger cipher, BigInteger[] map) {

    	String message=cipher.toString();
    	
    	if(cipher.toString().length()<16)
    		//there are not 2 letters in the msg
    		return null;
    	//set to IV
    	BigInteger previousCipherText = new BigInteger(""+message.substring(0,8));
    	//convert to decimal
    	previousCipherText = new BigInteger(""+(Integer.parseInt(previousCipherText.toString(),2)-128));

		//add 100 for transmission of IV
    	String decryptedMessage = ""+(previousCipherText.intValue()+100);
    	

		//for every letter in the cipher
		for(int i=8; i<cipher.toString().length()-1;i+=8) {
			//letter to convert
			String letterToConvert=""+cipher.toString().charAt(i);
			letterToConvert+=cipher.toString().charAt(i+1);
			letterToConvert+=cipher.toString().charAt(i+2);
			letterToConvert+=cipher.toString().charAt(i+3);
			letterToConvert+=cipher.toString().charAt(i+4);
			letterToConvert+=cipher.toString().charAt(i+5);
			letterToConvert+=cipher.toString().charAt(i+6);
			letterToConvert+=cipher.toString().charAt(i+7);
    		
			
			//binary to decimal minus the transmission that was added 
			int decryptionLocation = Integer.parseInt(letterToConvert.toString(),2)-128;
			
			
    		//decrypt letter with map
			BigInteger addDecrypt=new BigInteger(""+map[decryptionLocation]);
    		
			//binary to decimal to xor it
			addDecrypt = new BigInteger(""+Integer.parseInt(addDecrypt.toString(),2));
			
    		//subtract 128 from map transmission
    		addDecrypt = addDecrypt.subtract(new BigInteger("128"));
			
    		//xor the previous letter and current letter
			addDecrypt = addDecrypt.xor(previousCipherText);
			
			
			previousCipherText= new BigInteger(""+decryptionLocation);
			
    		//add the 100 for transmission
    		addDecrypt=addDecrypt.add(new BigInteger("100"));
    		
    		//add encrypted letter to the string to be returned
    		decryptedMessage+=addDecrypt;
    	}
		return new BigInteger(""+decryptedMessage);
	}

	
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
	public String ConvertStringToBinary(String str) {

//        String binaryLetter="";
//        for(int i=0; i<str.length();i++) {
//        	//add 128 to the string for later splitting
//        	System.out.println(Integer.parseInt(""+str.charAt(i))+128);
//        	binaryLetter+=Integer.toBinaryString(Integer.parseInt(""+str.charAt(i))+128);
//        }
        return Integer.toBinaryString(Integer.parseInt(str)+128);
	}
}
