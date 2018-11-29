
/**
 * This defines the interface for substitutionCipher that
 * encrypts and decrypts a given String using a shared key
 * @author Brad Vogeler & yunwang
 */
public interface SubstitutionCipherADT {
    
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


    public String Encrypt(String msg, String key);
    
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

    public String Decrypt(String cipher, String key);
    
}