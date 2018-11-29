import java.math.BigInteger;
/**
*Encrypt and Decrypt a msg by using the method of block cipher
*
* @author Brad Vogeler
* @date 9/30/2018
*/
public class BlockCipher implements BlockCipherADT {
	
	//128 in binary uses 8 digits
	private final int BLOCK_SIZE = 8;

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
	public BigInteger Encrypt(BigInteger msg, BigInteger[] map) {

    	String encryptedMessage = "";
    	String message=msg.toString();
    	
    	for(int i=0; i+2<message.length();i+=3) {
    		//take 3 numbers of the big integer
        	String encryptedLetter =""+message.charAt(i);
    		encryptedLetter+=message.charAt(i+1);
    		encryptedLetter+=message.charAt(i+2);
    		
    		//subtract the 100 from transmission
    		int encryptionLocation= Integer.parseInt(encryptedLetter)-100;
    		//encrypt letter 
    		String addEncrypt=""+map[encryptionLocation];
    		
    		//add encrypted letter to the string to be returned
    		encryptedMessage+=addEncrypt;
    	}
		return new BigInteger(""+encryptedMessage);
	}
	
	/**
     * Decrypt a BigInteger "cipher" with a given key "map".
     * For example, 
     * Suppose "cipher = 00001" and 
     * "map =	00001,00010,00011,00100,00101,00110,00111,01000,
     * 			01001,01010,01011,01100,01101,01110,01111,10000,
     * 			10001,10010,10011,10100,10101,10110,10111,11000,
     * 			11001,11010,11011,11100,11101,11110,11111,00000";
     * Decrypt(00001) return "00000"
     *
     * @param cipher  the message
     * @param map  the mapping to substitute letters with
     * @return decrypted message
     * 
     */
	public BigInteger Decrypt(BigInteger cipher, BigInteger[] map) {
		String decryptedMessage="";
		//for every letter in the cipher
		for(int i=0; i<cipher.toString().length()-1;i+=8) {
			//letter to convert
			String letterToConvert=""+cipher.toString().charAt(i);
			letterToConvert+=cipher.toString().charAt(i+1);
			letterToConvert+=cipher.toString().charAt(i+2);
			letterToConvert+=cipher.toString().charAt(i+3);
			letterToConvert+=cipher.toString().charAt(i+4);
			letterToConvert+=cipher.toString().charAt(i+5);
			letterToConvert+=cipher.toString().charAt(i+6);
			letterToConvert+=cipher.toString().charAt(i+7);
			
			//Decrypt letter
			//subtract from the transmission of message and decrypt
			letterToConvert=""+map[Integer.parseInt(letterToConvert, 2)-128];
			
			//subtract for the transmission of the map
			letterToConvert= ""+(Integer.parseInt(letterToConvert,2)-128);
			
			//add for the transmission of the decimal to ascii converter
			letterToConvert=""+(Integer.parseInt(letterToConvert)+100);
			
			decryptedMessage+=letterToConvert;
			
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
