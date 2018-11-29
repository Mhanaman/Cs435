
import java.math.BigInteger;
import java.util.Random;


/**
 * This class encrypts a given BigInteger message using RSA. 
*
* @author Brad Vogeler
* @date 9/30/2018
*/
public class RSA implements RSA_ADT{
    
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

    public  BigInteger Encrypt(BigInteger msg, BigInteger e, BigInteger n) {
    	
    	BigInteger addEncrypt = new BigInteger(""+Integer.parseInt(msg.toString())).modPow(e,n);
    	
		return addEncrypt;
    	
    	
    	/*
    	
    	String encryptedMessage = "";
    	String message=msg.toString();
    	
    	for(int i=0; i+2<message.length();i+=3) {
    		//take 3 numbers of the big integer
        	String encryptedLetter =""+message.charAt(i);
    		encryptedLetter+=message.charAt(i+1);
    		encryptedLetter+=message.charAt(i+2);

    		//subtract the 100 for proper calculations
    		encryptedLetter=""+(Integer.parseInt(encryptedLetter)-100);
    		
        	//encrypt using: c=m^e % n
    		BigInteger addEncrypt = new BigInteger(""+Integer.parseInt(encryptedLetter)).modPow(e,n);
    		
    		//add the 10^n to allow correct splitting after transmission
    		//addEncrypt=addEncrypt.add(new BigInteger("10").pow(n.toString().length()));
    		
    		//add encrypted letter to the string to be returned
    		encryptedMessage+=addEncrypt;
    	}

    	return new BigInteger(encryptedMessage);*/
    }
    
    
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

    public BigInteger Decrypt(BigInteger cipher, BigInteger d, BigInteger n) {
    	
    	BigInteger addDecrypt = new BigInteger(""+Integer.parseInt(cipher.toString())).modPow(d,n);
    	
		return addDecrypt;
    	
    	
    	/*String decrytpedMessage="";
    	String cipherText=cipher.toString();
    	int blockSize = cipher.toString().length();
    	
    	//for every block of numbers of size n.length
    	for(int block=0; block<cipher.toString().length()-1; block+=blockSize+1) {
    		//for every number in the block
			String decryptedLetter ="";
    		for(int i=0; i<blockSize; i++) {
    			//set the block to the first spot + the block start location
    			decryptedLetter+=cipherText.charAt(i+block);
    		}

    		//subtract the 10^n after splitting
    		BigInteger addDecrypt=new BigInteger(decryptedLetter).subtract(new BigInteger("10").pow(n.toString().length()));

    		//decrypt using: m=c^d % n
    		addDecrypt = addDecrypt.modPow(d,n);
    		
    		//add the 100 back after calculations for correct 
    		addDecrypt=addDecrypt.add(new BigInteger("100"));
        	
    		//add encrypted letter to the string to be returned
    		decrytpedMessage+=addDecrypt;
    	}
    	//decrypt using: m=c^d % n
    	return new BigInteger(decrytpedMessage);*/
    }
    
    
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
    public BigInteger CreateN(BigInteger p, BigInteger q) {
    	return p.multiply(q);
    }
    
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
    public BigInteger CreateZ(BigInteger p, BigInteger q){
    	BigInteger modifiedP=p.subtract(new BigInteger("1"));
    	BigInteger modifiedQ=q.subtract(new BigInteger("1"));
    	return modifiedP.multiply(modifiedQ);
    }

    
    /**
     * Create a BigInteger "e".
     * For example, 
     * Suppose "n=55"
     * CreateE(55) return 3
     *
     * @param n p * q
     * @return new BigInteger e
     * 
     */

	public BigInteger CreateE(BigInteger n) {
		Random gen= new Random();
    	BigInteger e=new BigInteger(""+(gen.nextInt(n.intValueExact()-1)+2));

    	//keep generating e until greatest common denominator is not 1
    	while(e.gcd(n).intValue()!=1 || !isPrime(e)) {
    		e=new BigInteger(""+(gen.nextInt(n.intValueExact()-1)+2));
    	}
    	return e;
	}
	
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
	public boolean isPrime(BigInteger num) {
		for(int i=2; i<num.intValueExact();i++) {
			if(num.intValueExact()%i==0)
				return false;
		}
		return true;
	}
	
    /**
     * Create a BigInteger "d".
     * For example, 
     * Suppose "n=55"
     * CreateE(55) return 3
     *
     * @param n p * q
     * @return new BigInteger d
     * 
     */

	public BigInteger CreateD(BigInteger e, BigInteger z) {
    	BigInteger d=new BigInteger("1");
    	
    	//using formula e * d % z = 1
    	for(int i=1;e.multiply(d).mod(z).intValue() != 1;i++) {
    		d= new BigInteger(""+i);
    	}
    	
    	return d;
	}
    


}
