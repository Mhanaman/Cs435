/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

/**
 * to test BlockCipher.
 * @author  Brad Vogeler
* @date 9/30/2018
*/
public class BlockCipherTest {

    public static int step = 0;

    public BlockCipherTest() {
    }

    /**
     * Test of Encrypt method, of class BlockCipher.
     */
    public void testEncrypt(BigInteger[] map) {
        step++;
        System.out.println("Step #" + step + " -- BlockCipherTest: testEncrypt()");
        String m = "Hello World";

        AsciiConverter asciiConverter = new AsciiConverter();
        BlockCipher BlockCipher  = new BlockCipher();
        
        BigInteger message = asciiConverter.StringtoBigInt(m);
        
        BigInteger result = BlockCipher.Encrypt(message, map);

        System.out.println("---------- Testing Result------------------");
        System.out.println("\tresult = " + result);

    }

    /**
     * Test of Decrypt method, of class BlockCipher.
     */
    public void testDecrypt(BigInteger[] map) {
        step++;
        System.out.println("Step #" + step + " -- BlockCipherTest: testDecrypt()");

        BigInteger m =new BigInteger("110010111100000110100011110000111001010011110001100111101010111110010110100011101001010011110100100010101100100110000001110000011001011111111010");
        String expectedResult = "Hello World";
        
        AsciiConverter asciiConverter = new AsciiConverter();
        BlockCipher BlockCipher  = new BlockCipher();
        
        
        BigInteger result = BlockCipher.Encrypt(m, map);

        System.out.println("---------- Testing Result------------------");
        System.out.println("\texpResult = " + expectedResult);
        System.out.println("\tresult = " + result);
        System.out.println("\t-- success!\n");

        // fail("The test case is a prototype.");
    }

}
