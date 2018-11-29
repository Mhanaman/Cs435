import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

/**
 * to test SubstitutionCipher.
 * @author  Brad Vogeler
* @date 9/30/2018
*/
public class MessageAuthenticationCodeTest {

    public static int step = 0;

    public MessageAuthenticationCodeTest() {
    }

    /**
     * Test of Encrypt method, of class MessageAuthenticationCode.
     */
    public void testEncrypt() {
        step++;
        System.out.println("Step #" + step + " -- MessageAuthenticationCodeTest: testEncrypt()");
        BigInteger secret=new BigInteger("165");
        BigInteger hash=new BigInteger("55");
        BigInteger message=new BigInteger("172201208208211132187211214208200133");
        MessageAuthenticationCode MessageAuthenticationCode  = new MessageAuthenticationCode();


        BigInteger result = MessageAuthenticationCode.Encrypt(message, hash, secret);
        
        String expectedResult = "11172201208208211132187211214208200133";

        System.out.println("---------- Testing Result------------------");
        System.out.println("\texpResult = " + expectedResult);
        System.out.println("\tresult = " + result);

    }

    /**
     * Test of Decrypt method, of class MessageAuthenticationCode.
     */
    public void testDecrypt() {
        step++;
        System.out.println("Step #" + step + " -- MessageAuthenticationCodeTest: testDecrypt()");
        BigInteger receivedData =new BigInteger("11172201208208211132187211214208200133");
        BigInteger secret=new BigInteger("165");
        BigInteger hash=new BigInteger("55");
        MessageAuthenticationCode MessageAuthenticationCode  = new MessageAuthenticationCode();


        boolean result= MessageAuthenticationCode.Authenticate(receivedData, hash, secret);
        
        String expectedResult = "true";

        System.out.println("---------- Testing Result------------------");
        System.out.println("\texpResult = " + expectedResult);
        System.out.println("\tresult = " + result);

    }
}