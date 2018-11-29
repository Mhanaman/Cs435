
import java.math.BigInteger;


/**
 * This class encrypts a given BigInteger message using the MessageAuthenticationCode.
 * uses a hash and secret to encrypt 
*
* @author Brad Vogeler
* @date 9/30/2018
*/
public class MessageAuthenticationCode implements MessageAuthenticationCodeADT {

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


    public BigInteger Encrypt(BigInteger secret, BigInteger msg, BigInteger hash) {
    	String combinedWords = secret.toString()+msg.toString();
    	
    	BigInteger hashedWord = new BigInteger(combinedWords).mod(hash);
    	
    	//add 10^hashedWord size for transmission
    	hashedWord= hashedWord.add(new BigInteger("10").pow(hash.toString().length()));
    	
    	combinedWords = hashedWord.toString()+msg.toString();
    	
    	return new BigInteger(combinedWords);
    }
    
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

    public boolean Authenticate(BigInteger secret, BigInteger msg, BigInteger hash) {
    	//store the beginning of the message
    	BigInteger hashedMessage =  new BigInteger(""+msg.toString().substring(1,hash.toString().length()+1));

    	//remove starting 1 from transmission
    	msg=new BigInteger(""+msg.toString().substring(hash.toString().length()+1, msg.toString().length()));

    	//hash the secret + message 
    	BigInteger hashedSecret = new BigInteger(""+secret+msg.toString()).mod(hash);
    	
    	if(hashedMessage.equals(hashedSecret))
    		return true;
    	
    	return false;
    }

}
