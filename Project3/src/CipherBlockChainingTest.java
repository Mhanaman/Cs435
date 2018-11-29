/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

/**
 * to test CipherBlockChaining.
 * @author Brad Vogeler
* @date 9/30/2018
*/
public class CipherBlockChainingTest {

    public static int step = 0;

    public CipherBlockChainingTest() {
    }

    /**
     * Test of Encrypt method, of class CipherBlockChaining.
     */
    public void testEncrypt() {
        step++;
        System.out.println("Step #" + step + " -- CipherBlockChainingTest: testEncrypt()");
        String m = "Hello World";

        Random gen = new Random();
        AsciiConverter asciiConverter = new AsciiConverter();
        CipherBlockChaining CipherBlockChaining  = new CipherBlockChaining();
        
        //use the numbers 128 to randomly generate a map
          ArrayList<Integer> list128 = new ArrayList<Integer>();
          for(int i=0; i<128;i++)
        	  list128.add(i);

          int currentSlot=0;
          int[] mapList= new int[128];
          //for all 128 numbers, randomly swap them
          while(list128.size()>1) {
        	  int rnd=gen.nextInt(list128.size());
        	  if(list128.get(rnd)!=currentSlot) {
        		  mapList[currentSlot]=list128.get(rnd);
        		  mapList[list128.remove(rnd)]=currentSlot;
        		  list128.remove(list128.indexOf(currentSlot));
                  if(list128.size()>0)
                	  currentSlot=list128.get(0);
        	  }
          }
          
          BigInteger[] map=new BigInteger[128];
          for(int i=0; i<mapList.length; i++){
        	  map[i]=new BigInteger(CipherBlockChaining.ConvertStringToBinary(""+mapList[i]));
          }
        
        BigInteger message = asciiConverter.StringtoBigInt(m);
        
        BigInteger result = CipherBlockChaining.Encrypt(message, map);

        System.out.println("---------- Testing Result------------------");
        System.out.println("\tresult = " + result);

    }

    /**
     * Test of Decrypt method, of class CipherBlockChaining.
     */
    public void testDecrypt() {
        step++;
        System.out.println("Step #" + step + " -- CipherBlockChainingTest: testDecrypt()");

        BigInteger m =new BigInteger("110010111100000110100011110000111001010011110001100111101010111110010110100011101001010011110100100010101100100110000001110000011001011111111010");
        String expectedResult = "Hello World";
        Random gen = new Random();
        AsciiConverter asciiConverter = new AsciiConverter();
        CipherBlockChaining CipherBlockChaining  = new CipherBlockChaining();
        
        //use the numbers 128 to randomly generate a map
        ArrayList<Integer> list128 = new ArrayList<Integer>();
        for(int i=0; i<128;i++)
      	  list128.add(i);

        int currentSlot=0;
        int[] mapList= new int[128];
        //for all 128 numbers, randomly swap them
        while(list128.size()>1) {
      	  int rnd=gen.nextInt(list128.size());
      	  if(list128.get(rnd)!=currentSlot) {
      		  mapList[currentSlot]=list128.get(rnd);
      		  mapList[list128.remove(rnd)]=currentSlot;
      		  list128.remove(list128.indexOf(currentSlot));
                if(list128.size()>0)
              	  currentSlot=list128.get(0);
      	  }
        }
        
        BigInteger[] map=new BigInteger[128];
        for(int i=0; i<mapList.length; i++){
      	  map[i]=new BigInteger(CipherBlockChaining.ConvertStringToBinary(""+mapList[i]));
        }
        
        BigInteger result = CipherBlockChaining.Encrypt(m, map);

        System.out.println("---------- Testing Result------------------");
        System.out.println("\texpResult = " + expectedResult);
        System.out.println("\tresult = " + result);
        System.out.println("\t-- success!\n");

        // fail("The test case is a prototype.");
    }

}
