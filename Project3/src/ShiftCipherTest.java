
import java.math.BigInteger;

public class ShiftCipherTest {

    public static int step = 0;

    public ShiftCipherTest() {
    }

    /**
     * Test of Encrypt method, of class ShiftCipher.
     */
    public void testEncrypt() {
        step++;
        System.out.println("Step #" + step + " -- ShiftCipherTest: testEncrypt()");
        BigInteger m = new BigInteger("100");
        BigInteger shiftKey = new BigInteger("5");
        BigInteger expectedResult = new BigInteger("105");
         ShiftCipher shiftCipher  = new ShiftCipher();
        BigInteger result = shiftCipher.Encrypt(m, shiftKey);

        System.out.println("---------- Testing Result------------------");
        System.out.println("\texpResult = " + expectedResult);
        System.out.println("\tresult = " + result);

    }

    /**
     * Test of Decrypt method, of class ShiftCipher.
     */
    public void testDecrypt() {
        step++;
        System.out.println("Step #" + step + " -- ShiftCipherTest: testDecrypt()");

        BigInteger m = new BigInteger("200");
        BigInteger shiftKey = new BigInteger("10");
        BigInteger expectedResult = new BigInteger("190");
        ShiftCipher shiftCipher  = new ShiftCipher();
        BigInteger result = shiftCipher.Decrypt(m, shiftKey);

        System.out.println("---------- Testing Result------------------");
        System.out.println("\texpResult = " + expectedResult);
        System.out.println("\tresult = " + result);
        System.out.println("\t-- success!\n");

        // fail("The test case is a prototype.");
    }

}
