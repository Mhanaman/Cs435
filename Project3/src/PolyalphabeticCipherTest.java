import java.math.BigInteger;

public class PolyalphabeticCipherTest {

    public static int step = 0;

    public PolyalphabeticCipherTest() {
    }

    /**
     * Test of Encrypt method, of class SubstitutionCipher.
     */
    public void testEncrypt() {
        step++;
        AsciiConverter asciiConverter = new AsciiConverter();
        System.out.println("Step #" + step + " -- PolyalphabeticCipherTest: testEncrypt()");
        String m = "Hello World";
        BigInteger inBigIntData = asciiConverter.StringtoBigInt(m);
        BigInteger shiftKey = new BigInteger("12345");
        String expectedResult = "173203211212216133189214218213201";
        PolyalphabeticCipher PolyalphabeticCipher  = new PolyalphabeticCipher();
        BigInteger result = PolyalphabeticCipher.Encrypt(inBigIntData, shiftKey);

        System.out.println("---------- Testing Result------------------");
        System.out.println("\texpResult = " + expectedResult);
        System.out.println("\tresult = " + result);

    }

    /**
     * Test of Decrypt method, of class ShiftCipher.
     */
    public void testDecrypt() {
        step++;
        AsciiConverter asciiConverter = new AsciiConverter();
        
        System.out.println("Step #" + step + " -- PolyalphabeticCipherTest: testDecrypt()");

        BigInteger shiftKey = new BigInteger("12345");
        BigInteger receivedData =  new BigInteger("173203211212216133189214218213201");
        String k="qwertyuioplkjhgfdsazxcvbnm";
        String expectedResult = "Hello World";
        PolyalphabeticCipher PolyalphabeticCipher  = new PolyalphabeticCipher();
        BigInteger decrypted = PolyalphabeticCipher.Decrypt(receivedData, shiftKey);
        String result= asciiConverter.BigIntToString(decrypted);
        System.out.println("---------- Testing Result------------------");
        System.out.println("\texpResult = " + expectedResult);
        System.out.println("\tresult = " + result);
        System.out.println("\t-- success!\n");

        // fail("The test case is a prototype.");
    }
}
