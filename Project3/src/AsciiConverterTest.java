/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.math.BigInteger;

/**
 * to test AsciiConverter.
 * @author yunwang & Brad Vogeler
 */
public class AsciiConverterTest {

    public static int step = 0;

    public AsciiConverterTest() {
    }

    /**
     * Test of toBigInteger method, of class AsciiConverter.
     */
    public void testToBigInteger() {

        step++;
        System.out.print("Step #" + step + " -- ");

        System.out.println("AsciiConverterTest: toBigInteger");
        String inStr = "Hello";
        BigInteger expResult = new BigInteger("172201208208211");

        AsciiConverter asciiConverter = new AsciiConverter();

        BigInteger result = asciiConverter.StringtoBigInt(inStr);

        System.out.println("---------- Tesing Result------------------");
        System.out.println("\texpResult = " + expResult);
        System.out.println("\tresult = " + result);
        System.out.println("\t-- success!\n");
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of toString method, of class AsciiConverter.
     */
    public void testToString() {

        step++;
        System.out.print("Step #" + step + " -- ");

        System.out.println("AsciiConverterTest: toString");
        BigInteger inBigInt = new BigInteger("172201208208211");
        String expResult = "Hello";
        AsciiConverter asciiConverter = new AsciiConverter();
        String result = asciiConverter.BigIntToString(inBigInt);
        System.out.println("---------- Tesing Result------------------");
        System.out.println("\texpResult = " + expResult);
        System.out.println("\tresult = " + result);
        System.out.println("\t-- success!\n");
        // TODO review the generated test code and remove the default call to fail.

    }

}
