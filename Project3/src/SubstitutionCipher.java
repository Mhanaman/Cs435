/**
 * encrypts and decrypts a given BigInteger using a shared substitution key
*
* @author Brad Vogeler
* @date 9/30/2018
*/
public class SubstitutionCipher implements SubstitutionCipherADT {
	
	final char[] alphabet= {'a','b','c','d','e','f','g','h','i'
			,'j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	/**
     * Encrypt a String "msg" with a given cipherText Alphabet "key".
     * For example, 
     * Suppose "msg = Hello" and "key = b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,a";
     * Encrypt("hello","b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,a")
     * 			 return "IFMMP"
     *
     * @param msg  the message
     * @param key the cipherText alphabet key
     * @return encrypted message
     * 
     */
	
	public String Encrypt(String msg, String key) {
		String encryptedMessage = ""; 
		for(int i=0; i<msg.length();i++) {
			encryptedMessage += key.charAt(Integer.parseInt(msg.substring(i, i+1)));
		}
		
		return encryptedMessage;
		
		
		
		
		/*
		String encryptedMessage = ""; 
		//for every letter in the word
		for(int i=0; i<msg.length();i++) {
			
			int locationOfLetterInAlphabet=-1;
			char letterToConvert=Character.toLowerCase(msg.charAt(i));
			//skip any spaces in the word
			if(key.contains(""+letterToConvert)) {
				//find the index of the letter in the alphabet
				for(int j=0;j<alphabet.length;j++) {
					if(alphabet[j]==letterToConvert)
						locationOfLetterInAlphabet=j;
				}
				//substitute letter
				encryptedMessage+=key.charAt(locationOfLetterInAlphabet);
			}
			else {
				encryptedMessage+=letterToConvert;
			}
		}
		return encryptedMessage;*/
	}
	

    /**
     * Decrypt a String "msg" with a given cipherText Alphabet "key".
     * For example, 
     * Suppose "msg = IFMMP" and "key = b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,a";
     * Encrypt("hello","b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,a")
     * 			 return "Hello"
     *
     * @param msg  the message
     * @param key the cipherText alphabet key
     * @return decrypted message
     * 
     */
	
	public String Decrypt(String cipher, String key) {

		String decryptedMessage = ""; 
		for(int i=0; i<cipher.length();i++) {
			for(int j=0; j<key.length();j++) {
				if(Integer.parseInt(key.substring(j, j+1))==Integer.parseInt(cipher.substring(i, i+1))) {
					decryptedMessage += j;
				}
			}
		}
		
		return decryptedMessage;
		
		
		
		/*String decryptedMessage="";
		//for every letter in the word
		for(int i=0; i<cipher.length();i++) {
			
			int locationOfLetterInKey=-1;
			char letterToConvert=Character.toLowerCase(cipher.charAt(i));
			
			//skip any non letters in the word
			if(key.contains(""+letterToConvert)) {
				
				//find the index of the letter in the key
				for(int j=0;j<key.length();j++) {
					if(key.charAt(j)==letterToConvert)
					locationOfLetterInKey=j;
				}
				//substitute letter
				decryptedMessage+=alphabet[locationOfLetterInKey];
				}
			else {
				decryptedMessage+=letterToConvert;
			}
		}
		return decryptedMessage;*/
	}
}
