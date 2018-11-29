import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

/**
 * to test SubstitutionCipher.
 * @author  Brad Vogeler
* @date 9/30/2018
*/
public class CertificationAuthoritiesTest {

    public static int step = 0;

    public CertificationAuthoritiesTest() {
    }

    /**
     * Test of Encrypt method, of class CertificationAuthorities.
     */
    public void testEncrypt() {
        step++;
        System.out.println("Step #" + step + " -- CertificationAuthoritiesTest: testEncrypt()");
        BigInteger publicKey=new BigInteger("103155");
        BigInteger privateKey=new BigInteger("127155");
        BigInteger certificatePublicKey=new BigInteger("129135");
        BigInteger certificatePrivateKey=new BigInteger("105135");
        CertificationAuthorities CertificationAuthorities  = new CertificationAuthorities();


        BigInteger result = CertificationAuthorities.Encrypt(publicKey, certificatePrivateKey);
        
        String expectedResult = "1133120";

        System.out.println("---------- Testing Result------------------");
        System.out.println("\texpResult = " + expectedResult);
        System.out.println("\tresult = " + result);

    }

    /**
     * Test of Decrypt method, of class CertificationAuthorities.
     */
    public void testDecrypt() {
        step++;
        System.out.println("Step #" + step + " -- CertificationAuthoritiesTest: testDecrypt()");
        BigInteger receivedData=new BigInteger("1139140");
        BigInteger certificatePublicKey=new BigInteger("129135");
        BigInteger certificatePrivateKey=new BigInteger("105135");
        CertificationAuthorities CertificationAuthorities  = new CertificationAuthorities();


        BigInteger result= CertificationAuthorities.Decrypt(receivedData, certificatePublicKey);
        
        String expectedResult = "109110";

        System.out.println("---------- Testing Result------------------");
        System.out.println("\texpResult = " + expectedResult);
        System.out.println("\tresult = " + result);

    }
}
