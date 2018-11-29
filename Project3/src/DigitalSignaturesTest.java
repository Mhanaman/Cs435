import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

/**
 * to test SubstitutionCipher.
 * @author  Brad Vogeler
* @date 9/30/2018
*/
public class DigitalSignaturesTest {

    public static int step = 0;

    public DigitalSignaturesTest() {
    }

    /**
     * Test of Encrypt method, of class DigitalSignatures.
     */
    public void testEncrypt() {
        step++;
        System.out.println("Step #" + step + " -- DigitalSignaturesTest: testEncrypt()");
        BigInteger privateKey=new BigInteger("127155");
        BigInteger hash=new BigInteger("55");
        BigInteger message=new BigInteger("54872156");
        DigitalSignatures DigitalSignatures  = new DigitalSignatures();


        BigInteger result = DigitalSignatures.Encrypt(message, hash, privateKey);
        
        String expectedResult = "54872156101";

        System.out.println("---------- Testing Result------------------");
        System.out.println("\texpResult = " + expectedResult);
        System.out.println("\tresult = " + result);

    }

    /**
     * Test of Decrypt method, of class DigitalSignatures.
     */
    public void testDecrypt() {
        step++;
        System.out.println("Step #" + step + " -- DigitalSignaturesTest: testDecrypt()");
        BigInteger receivedData =new BigInteger("17220120820821113218721121420820013310339284");
        BigInteger publicKey=new BigInteger("103155");
        BigInteger hash=new BigInteger("55");
        DigitalSignatures DigitalSignatures  = new DigitalSignatures();


        boolean result= DigitalSignatures.Authenticate(receivedData, hash, publicKey);
        
        String expectedResult = "true";

        System.out.println("---------- Testing Result------------------");
        System.out.println("\texpResult = " + expectedResult);
        System.out.println("\tresult = " + result);

    }
}
