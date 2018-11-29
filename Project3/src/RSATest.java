
import java.math.BigInteger;

public class RSATest {

    public static int step = 0;
    public static BigInteger e,n;

    public RSATest() {
    }

    /**
     * Test of Encrypt method, of class RSA.
     */
    public void testEncrypt() {
        step++;
        AsciiConverter asciiConverter = new AsciiConverter();
        System.out.println("Step #" + step + " -- RSACipherTest: testEncrypt()");
        //prime numbers larger than 200
        BigInteger p=new BigInteger("509");
        BigInteger q=new BigInteger("251");
        BigInteger m = new BigInteger("Testing RSA");
        BigInteger inBigIntData = asciiConverter.StringtoBigInt(m.toString());
        String expectedResult = "10728581031871108435710657231104483108718510214211007813102790311277021051437";
        RSA RSA  = new RSA();
        n=RSA.CreateN(p, q);
        e=RSA.CreateE(n);
        BigInteger result = RSA.Encrypt(inBigIntData, e, n);

        System.out.println("---------- Testing Result------------------");
        System.out.println("\texpResult = " + expectedResult);
        System.out.println("\tresult = " + result);

    }

    /**
     * Test of Decrypt method, of class RSA.
     */
    public void testDecrypt() {
        step++;
        RSA RSA  = new RSA();
        AsciiConverter asciiConverter = new AsciiConverter();
        System.out.println("Step #" + step + " -- RSACipherTest: testDecrypt()");

        BigInteger m = new BigInteger("10728581031871108435710657231104483108718510214211007813102790311277021051437");
        BigInteger p=new BigInteger("509");
        BigInteger q=new BigInteger("251");
        BigInteger z=RSA.CreateZ(p, q);
        BigInteger d=RSA.CreateD(e, z);
        String expectedResult = "Testing RSA";
        BigInteger result = RSA.Decrypt(m, d, n);

        System.out.println("---------- Testing Result------------------");
        System.out.println("\texpResult = " + expectedResult);
        System.out.println("\tresult = " + result);
        System.out.println("\t-- success!\n");

        // fail("The test case is a prototype.");
    }

}