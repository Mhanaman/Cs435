import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

/**
 * to test SubstitutionCipher.
 * @author  Brad Vogeler
* @date 9/30/2018
*/
public class SubstitutionCipherTest {

    public static int step = 0;

    public SubstitutionCipherTest() {
    }

    /**
     * Test of Encrypt method, of class SubstitutionCipher.
     */
    public void testEncrypt() {
        step++;
        System.out.println("Step #" + step + " -- SubstitutionCipherTest: testEncrypt()");
        String m = "Hello World";
        String subsitutionKey="qwertyuioplkjhgfdsazxcvbnm";
        String expectedResult = "itkkg vgskr";
        SubstitutionCipher SubstitutionCipher  = new SubstitutionCipher();
        String result = SubstitutionCipher.Encrypt(m, subsitutionKey);

        System.out.println("---------- Testing Result------------------");
        System.out.println("\texpResult = " + expectedResult);
        System.out.println("\tresult = " + result);

    }

    /**
     * Test of Decrypt method, of class SubstitutionCipher.
     */
    public void testDecrypt() {
        step++;
        System.out.println("Step #" + step + " -- SubstitutionCipherTest: testDecrypt()");

        String m = "itkkg vgskr";
        String k="qwertyuioplkjhgfdsazxcvbnm";
        String expectedResult = "Hello World";
        SubstitutionCipher SubstitutionCipher  = new SubstitutionCipher();
        String result = SubstitutionCipher.Decrypt(m, k);

        System.out.println("---------- Testing Result------------------");
        System.out.println("\texpResult = " + expectedResult);
        System.out.println("\tresult = " + result);
        System.out.println("\t-- success!\n");

        // fail("The test case is a prototype.");
    }
}
