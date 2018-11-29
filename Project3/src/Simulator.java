
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

import javax.naming.BinaryRefAddr;

/**
 *
 * Simulator is to test all classes in an interleaved fashion.
 *
 * @author Yun Wang & Brad Vogeler
 * @version 1.01 09-07-2018
 */
public class Simulator {

    public static void main(String[] args) {

        System.out.println("CIS 435+535 Project #1 --- Cryptography");
        System.out.println("Author: Brad Vogeler, Student-ID: 23\n");
        
        Random gen = new Random();
        AsciiConverter asciiConverter = new AsciiConverter();
        ShiftCipher shiftCipher  = new ShiftCipher();


        System.out.println("\n~~~~~~~~~~~~~~~~~Begin Shift Cipher~~~~~~~~~~~~~~~~~~~~ ");
        System.out.println("On Sender's Side");
        int step = 0;
        step++;
        System.out.println("\nStep #" + step + ": Get Input String from Sender ~~~~~~~~~~~~~~~~");

        String inString = "Hello World!";

        System.out.println("\tInput String = " + inString);

        step++;
        System.out.println("\nStep #" + step + ": Convert Input String to BigInteger ~~~~~~~~~~~~~~~~");

        BigInteger inBigIntData = asciiConverter.StringtoBigInt(inString);

        System.out.println("\tConverted Result = " + inBigIntData);

        step++;
        System.out.println("\nStep #" + step + ": Encrypt Converted Result using ShiftCipher ~~~~~~~~~~~~~~~~");
        
        BigInteger shiftKey = new BigInteger(""+(gen.nextInt(50)+1));
        
        System.out.println("\tshiftKey = " + shiftKey);
        
        BigInteger encryptedData = shiftCipher.Encrypt(inBigIntData, shiftKey);

        System.out.println("\tencryptedData = " + encryptedData);

        System.out.println("\n---------Simulating sending \"encryptedData\" to receiver------------\n");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||Internet|||||||||||||||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
      
        System.out.println("\n---------Simulating receiving the \"encryptedData\" from sender------------\n");

        System.out.println("On Receiver's Side");
        step++;
        System.out.println("\nStep #" + step + ": Receiving Data ~~~~~~~~~~~~~~~~");
        
        BigInteger receivedData = encryptedData;
        
        System.out.println("\treceivedData = " + receivedData);

        step++;
        System.out.println("\nStep #" + step + ": Decrypt receivedData using ShiftCipher ~~~~~~~~~~~~~~~~");

        BigInteger decryptedData = shiftCipher.Decrypt(receivedData, shiftKey);
        
        System.out.println("\tdecryptedData Result = " + decryptedData);

        step++;
        System.out.println("\nStep #" + step + ": Converting decryptedData to String using AsciiConverter ~~~~~~~~~~~~~~~~");

        String recvMsg = asciiConverter.BigIntToString(decryptedData);
        
         step++;
        System.out.println("\nStep #" + step + ": Receiver Receives the message from the Sender ~~~~~~~~~~~~~~~~");
        System.out.println("\tReceived Message = " + recvMsg);
        
        
        
        //Substitution Cipher

        System.out.println("\n~~~~~~~~~~~~~~~~~Begin Substitution Cipher~~~~~~~~~~~~~~~~~~~~ ");
        SubstitutionCipher SubstitutionCipher  = new SubstitutionCipher();

        System.out.println("On Sender's Side");
        step = 0;
        step++;
        System.out.println("\nStep #" + step + ": Get Input String from Sender ~~~~~~~~~~~~~~~~");

        inString = "Hello World!";

        System.out.println("\tInput String = " + inString);

        step++;
        System.out.println("\nStep #" + step + ": Encrypt String using SubstitutionCipher ~~~~~~~~~~~~~~~~");
        String subsitutionKey="qwertyuioplkjhgfdsazxcvbnm";
        System.out.println("\tkey = " + subsitutionKey);
        String encryptedString = SubstitutionCipher.Encrypt(inString, subsitutionKey);

        System.out.println("\tencryptedData = " + encryptedString);

        System.out.println("\n---------Simulating sending \"encryptedData\" to receiver------------\n");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||Internet|||||||||||||||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
      
        System.out.println("\n---------Simulating receiving the \"encryptedData\" from sender------------\n");

        System.out.println("On Receiver's Side");
        step++;
        System.out.println("\nStep #" + step + ": Receiving Data ~~~~~~~~~~~~~~~~");
        String receivedString = encryptedString;
        System.out.println("\treceivedData = " + receivedString);

        step++;
        System.out.println("\nStep #" + step + ": Decrypt receivedData using SubstitutionCipher ~~~~~~~~~~~~~~~~");

        String decryptedString = SubstitutionCipher.Decrypt(receivedString, subsitutionKey);
        System.out.println("\tdecryptedData Result = " + decryptedString);

        
        //begin Polyalphabetic cipher
        
        System.out.println("\n~~~~~~~~~~~~~~~~~Begin Polyalphabetic Cipher~~~~~~~~~~~~~~~~~~~~ ");
        PolyalphabeticCipher PolyalphabeticCipher = new PolyalphabeticCipher();
        
        System.out.println("On Sender's Side");
        step = 0;
        step++;
        System.out.println("\nStep #" + step + ": Get Input String from Sender ~~~~~~~~~~~~~~~~");

        inString = "Hello World!";

        System.out.println("\tInput String = " + inString);

        step++;
        System.out.println("\nStep #" + step + ": Convert Input String to BigInteger ~~~~~~~~~~~~~~~~");

        inBigIntData = asciiConverter.StringtoBigInt(inString);

        System.out.println("\tConverted Result = " + inBigIntData);

        step++;
        System.out.println("\nStep #" + step + ": Encrypt Converted Result using Polyalphabetic Cipher ~~~~~~~~~~~~~~~~");
        
        shiftKey = new BigInteger(""+gen.nextInt(6));
        
        System.out.println("\tshiftKey = " + shiftKey);
        encryptedData = PolyalphabeticCipher.Encrypt(inBigIntData, shiftKey);

        System.out.println("\tencryptedData = " + encryptedData);

        System.out.println("\n---------Simulating sending \"encryptedData\" to receiver------------\n");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||Internet|||||||||||||||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
      
        System.out.println("\n---------Simulating receiving the \"encryptedData\" from sender------------\n");

        System.out.println("On Receiver's Side");
        step++;
        System.out.println("\nStep #" + step + ": Receiving Data ~~~~~~~~~~~~~~~~");
        receivedData = encryptedData;
        System.out.println("\treceivedData = " + receivedData);

        step++;
        System.out.println("\nStep #" + step + ": Decrypt receivedData  using Polyalphabetic Cipher ~~~~~~~~~~~~~~~~");

        decryptedData = PolyalphabeticCipher.Decrypt(receivedData, shiftKey);
        System.out.println("\tdecryptedData Result = " + decryptedData);

        step++;
        System.out.println("\nStep #" + step + ": Converting decryptedData to String using AsciiConverter ~~~~~~~~~~~~~~~~");

        recvMsg = asciiConverter.BigIntToString(decryptedData);
        
         step++;
        System.out.println("\nStep #" + step + ": Receiver Receives the message from the Sender ~~~~~~~~~~~~~~~~");
        System.out.println("\tReceived Message = " + recvMsg);
        
        
        
        
        
      //RSA Cipher
        System.out.println("\n~~~~~~~~~~~~~~~~~Begin RSA~~~~~~~~~~~~~~~~~~~~ ");
        
        RSA RSA  = new RSA();

        System.out.println("On Sender's Side");
        step = 0;
        step++;
        System.out.println("\nStep #" + step + ": Get Input String from Sender ~~~~~~~~~~~~~~~~");

        inString = "Testing RSA";

        System.out.println("\tInput String = " + inString);

        step++;
        System.out.println("\nStep #" + step + ": Convert Input String to BigInteger ~~~~~~~~~~~~~~~~");

        inBigIntData = asciiConverter.StringtoBigInt(inString);

        System.out.println("\tConverted Result = " + inBigIntData);

        step++;
        System.out.println("\nStep #" + step +" Generating a random P and Q...");
        
        BigInteger p=new BigInteger(""+gen.nextInt(10)+1);
        
		for(int i=2; i<p.intValueExact();i++) {
			if(p.intValueExact()%i==0) {
				p=new BigInteger(""+gen.nextInt(10)+1);
				i=2;
			}
		}
        
        BigInteger q=new BigInteger(""+gen.nextInt(10)+1);
        
		for(int i=2; i<q.intValueExact();i++) {
			if(q.intValueExact()%i==0) {
				q=new BigInteger(""+gen.nextInt(10)+1);
				i=2;
			}
		}
        
        
        System.out.println("\nStep #" + step + ": Use P:"+p+" and Q:"+q+" to generate the Public Key ~~~~~~~~~~~~~~~~");

        BigInteger n=RSA.CreateN(p, q);
        BigInteger e=RSA.CreateE(n);

        System.out.println("\tPublic Key (e,n) is: ("+e+","+n+")");
        step++;
        System.out.println("\nStep #" + step + ": Encrypt String using RSA ~~~~~~~~~~~~~~~~");
        
        encryptedData = RSA.Encrypt(inBigIntData, e, n);

        System.out.println("\tencryptedData = " + encryptedData);

        System.out.println("\n---------Simulating sending \"encryptedData\" to receiver------------\n");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||Internet|||||||||||||||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
      
        System.out.println("\n---------Simulating receiving the \"encryptedData\" from sender------------\n");

        System.out.println("On Receiver's Side");
        step++;
        System.out.println("\nStep #" + step + ": Receiving Data ~~~~~~~~~~~~~~~~");
        receivedData = encryptedData;
        System.out.println("\treceivedData = " + receivedData);

        step++;
        System.out.println("\nStep #" + step + ": Create Z and D for Decryption ~~~~~~~~~~~~~~~~");

        System.out.println("\t Generating Z and D...");

        BigInteger z=RSA.CreateZ(p, q);
        BigInteger d=RSA.CreateD(e, z);
        
        System.out.println("\t Z:"+z+"  D:"+d);

        step++;
        System.out.println("\nStep #" + step + ": Decrypt receivedData  using RSA ~~~~~~~~~~~~~~~~");

        
        decryptedData = RSA.Decrypt(receivedData, d, n);
        System.out.println("\tdecryptedData Result = " + decryptedData);

        step++;
        System.out.println("\nStep #" + step + ": Converting decryptedData to String using AsciiConverter ~~~~~~~~~~~~~~~~");

        recvMsg = asciiConverter.BigIntToString(decryptedData);
        
        step++;
        System.out.println("\nStep #" + step + ": Receiver Receives the message from the Sender ~~~~~~~~~~~~~~~~");
        System.out.println("\tReceived Message = " + recvMsg);
        
        

        //Block Cipher
          System.out.println("\n~~~~~~~~~~~~~~~~~Begin Block Cipher~~~~~~~~~~~~~~~~~~~~ ");
          
          BlockCipher BlockCipher  = new BlockCipher();

          System.out.println("On Sender's Side");
          step = 0;
          step++;
          System.out.println("\nStep #" + step + ": Get Input String from Sender ~~~~~~~~~~~~~~~~");

          inString = "Test Block Cipher!";

          System.out.println("\tInput String = " + inString);

          step++;
          System.out.println("\nStep #" + step + ": Convert Input String to BigInteger ~~~~~~~~~~~~~~~~");
          
          BigInteger binaryString = asciiConverter.StringtoBigInt(inString);
          
          System.out.println("\tConverted Result = " + binaryString);
          

          step++;
          System.out.println("\nStep #" + step + ": Generate a random Block Cipher ~~~~~~~~~~~~~~~~");
          
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
        	  map[i]=new BigInteger(BlockCipher.ConvertStringToBinary(""+mapList[i]));
          }
          
          if(list128.isEmpty())
              System.out.println("\tSuccess!");

          step++;
          System.out.println("\nStep #" + step + ": Encrypt String using BlockCipher ~~~~~~~~~~~~~~~~");
          
          encryptedData = BlockCipher.Encrypt(binaryString, map);

          System.out.println("\tencryptedData = " + encryptedData);

          System.out.println("\n---------Simulating sending \"encryptedData\" to receiver------------\n");
          System.out.println("|||||||||||||||||||||||||||||||||||||||||");
          System.out.println("|||||||||||||||||||||||||||||||||||||||||");
          System.out.println("||||||||||||||||||Internet|||||||||||||||");
          System.out.println("|||||||||||||||||||||||||||||||||||||||||");
          System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        
          System.out.println("\n---------Simulating receiving the \"encryptedData\" from sender------------\n");

          System.out.println("On Receiver's Side");
          step++;
          System.out.println("\nStep #" + step + ": Receiving Data ~~~~~~~~~~~~~~~~");
          receivedData = encryptedData;
          System.out.println("\treceivedData = " + receivedData);

          step++;
          System.out.println("\nStep #" + step + ": Decrypt receivedData  using BlockCipher ~~~~~~~~~~~~~~~~");

          
          decryptedData = BlockCipher.Decrypt(receivedData, map);
          System.out.println("\tdecryptedData Result = " + decryptedData);

          step++;
          System.out.println("\nStep #" + step + ": Converting decryptedData to String using AsciiConverter ~~~~~~~~~~~~~~~~");

          recvMsg = asciiConverter.BigIntToString(decryptedData);
          
           step++;
          System.out.println("\nStep #" + step + ": Receiver Receives the message from the Sender ~~~~~~~~~~~~~~~~");
          System.out.println("\tReceived Message = " + recvMsg);
     
          
          
          
          //Block Cipher
            System.out.println("\n~~~~~~~~~~~~~~~~~Begin Cipher Block Chaining~~~~~~~~~~~~~~~~~~~~ ");
            
            CipherBlockChaining CipherBlockChaining  = new CipherBlockChaining();

            System.out.println("On Sender's Side");
            step = 0;
            step++;
            System.out.println("\nStep #" + step + ": Get Input String from Sender ~~~~~~~~~~~~~~~~");

            inString = "Hello World";
            String IV= "a";

            System.out.println("\tIV + Input String = " +IV+" + "+ inString);

            step++;
            System.out.println("\nStep #" + step + ": Convert Input String to BigInteger ~~~~~~~~~~~~~~~~");
            
            binaryString = asciiConverter.StringtoBigInt(IV+inString);
            
            System.out.println("\tConverted Result = " + binaryString);

            step++;
            System.out.println("\nStep #" + step + ": Encrypt String using CipherBlockChaining ~~~~~~~~~~~~~~~~");
            
            //use the randomly generated map from block cipher
            encryptedData = CipherBlockChaining.Encrypt(binaryString, map);

            System.out.println("\tencryptedData = " + encryptedData);

            System.out.println("\n---------Simulating sending \"encryptedData\" to receiver------------\n");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||");
            System.out.println("||||||||||||||||||Internet|||||||||||||||");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||");
          
            System.out.println("\n---------Simulating receiving the \"encryptedData\" from sender------------\n");

            System.out.println("On Receiver's Side");
            step++;
            System.out.println("\nStep #" + step + ": Receiving Data ~~~~~~~~~~~~~~~~");
            receivedData = encryptedData;
            System.out.println("\treceivedData = " + receivedData);

            step++;
            System.out.println("\nStep #" + step + ": Decrypt receivedData  using CipherBlockChaining ~~~~~~~~~~~~~~~~");

            
            decryptedData = CipherBlockChaining.Decrypt(receivedData, map);
            System.out.println("\tdecryptedData Result = " + decryptedData);

            step++;
            System.out.println("\nStep #" + step + ": Converting decryptedData to String using AsciiConverter ~~~~~~~~~~~~~~~~");

            recvMsg = asciiConverter.BigIntToString(decryptedData);
            
             step++;
            System.out.println("\nStep #" + step + ": Receiver Receives the message from the Sender ~~~~~~~~~~~~~~~~");
            System.out.println("\tIV = "+recvMsg.charAt(0)+"    Received Message = " + recvMsg.substring(1, recvMsg.length()));
          
            
            
            //Begin MAC 
            System.out.println("\n~~~~~~~~~~~~~~~~~Begin MAC~~~~~~~~~~~~~~~~~~~~ ");
            MessageAuthenticationCode MessageAuthenticationCode=new MessageAuthenticationCode();
            System.out.println("On Sender's Side");
            step = 0;
            step++;
            System.out.println("\nStep #" + step + ": Get Input String from Sender ~~~~~~~~~~~~~~~~");

            inString = "Hello World!";

            System.out.println("\tInput String = " + inString);

            step++;
            System.out.println("\nStep #" + step + ": Convert Input String to BigInteger ~~~~~~~~~~~~~~~~");

            inBigIntData = asciiConverter.StringtoBigInt(inString);

            System.out.println("\tConverted Result = " + inBigIntData);
            
            step++;
            System.out.println("\nStep #" + step + ": Get Input Secret from Sender ~~~~~~~~~~~~~~~~");

            String secret = "secret word";
            
            System.out.println("\tInput Secret = " + secret);
            
            step++;
            System.out.println("\nStep #" + step + ": Convert Input Secret to BigInteger ~~~~~~~~~~~~~~~~");

            BigInteger inBigIntSecret = asciiConverter.StringtoBigInt(secret);

            System.out.println("\tConverted Result = " + inBigIntSecret);
            
            step++;
            System.out.println("\nStep #" + step + ": Encrypt Converted Result using MessageAuthenticationCode ~~~~~~~~~~~~~~~~");
            
            BigInteger hash = new BigInteger(""+(gen.nextInt(50)+1));
            
            System.out.println("\tHash = " + hash);
            
            encryptedData = MessageAuthenticationCode.Encrypt(inBigIntSecret, inBigIntData, hash);

            System.out.println("\tencryptedData = " + encryptedData);

            System.out.println("\n---------Simulating sending \"encryptedData\" to receiver------------\n");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||");
            System.out.println("||||||||||||||||||Internet|||||||||||||||");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||");
          
            System.out.println("\n---------Simulating receiving the \"encryptedData\" from sender------------\n");

            System.out.println("On Receiver's Side");
            step++;
            System.out.println("\nStep #" + step + ": Receiving Data ~~~~~~~~~~~~~~~~");
            
            receivedData = encryptedData;
            
            System.out.println("\treceivedData = " + receivedData);

            step++;
            System.out.println("\nStep #" + step + ": Decrypt receivedData using MessageAuthenticationCode ~~~~~~~~~~~~~~~~");

            boolean MACresult= MessageAuthenticationCode.Authenticate(inBigIntSecret, receivedData, hash);
            
            System.out.println("\tdecryptedData Result = " + MACresult);
            
            step++;
            System.out.println("\nStep #" + step + ": Message was authenticated ~~~~~~~~~~~~~~~~");
            System.out.println("\tReceived Message = " + MACresult);
            
            
            
            

            //Digital Signatures
            System.out.println("\n~~~~~~~~~~~~~~~~~Begin DigitalSignatures~~~~~~~~~~~~~~~~~~~~ ");
            DigitalSignatures DigitalSignatures=new DigitalSignatures();
            System.out.println("On Sender's Side");
            step = 0;
            step++;
            System.out.println("\nStep #" + step + ": Create Private Key ~~~~~~~~~~~~~~~~");

            //use keys generated in RSA method to save time
            BigInteger privateKey = new BigInteger(d.toString());

            System.out.println("\tPrivateKey = " + privateKey);
            
            hash = new BigInteger(""+n);
            
            System.out.println("\tHash = " + hash);
            
            step++;
            System.out.println("\nStep #" + step + ": Encrypt Converted Result using DigitalSignatures ~~~~~~~~~~~~~~~~");
            
            encryptedData = DigitalSignatures.Encrypt(inBigIntData, hash, privateKey);

            System.out.println("\tencryptedData = " + encryptedData);

            System.out.println("\n---------Simulating sending \"encryptedData\" to receiver------------\n");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||");
            System.out.println("||||||||||||||||||Internet|||||||||||||||");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||");
          
            System.out.println("\n---------Simulating receiving the \"encryptedData\" from sender------------\n");

            System.out.println("On Receiver's Side");
            step++;
            System.out.println("\nStep #" + step + ": Receiving Data ~~~~~~~~~~~~~~~~");
            
            receivedData = encryptedData;
            
            System.out.println("\treceivedData = " + receivedData);
            
            step++;
            System.out.println("\nStep #" + step + ": Create Public Key ~~~~~~~~~~~~~~~~");

            //use keys generated in RSA method to save time
            BigInteger publicKey = new BigInteger(e.toString());
            
            System.out.println("\tPublicKey = " + publicKey);
            System.out.println("\tHash = " + hash);

            step++;
            System.out.println("\nStep #" + step + ": Decrypt receivedData using DigitalSignatures ~~~~~~~~~~~~~~~~");

            boolean DSresult= DigitalSignatures.Authenticate(receivedData, hash, publicKey);
            
            System.out.println("\tdecryptedData Result = " + DSresult);
            
            step++;
            System.out.println("\nStep #" + step + ": Message was authenticated ~~~~~~~~~~~~~~~~");
            System.out.println("\tReceived Message = " + DSresult);
            

            
            
            //Certification Authorites
            System.out.println("\n~~~~~~~~~~~~~~~~~Begin Certification Authorities~~~~~~~~~~~~~~~~~~~~ ");
            CertificationAuthorities CertificationAuthorities=new CertificationAuthorities();
            System.out.println("On Sender's Side");
            step = 0;
            step++;
            System.out.println("\nStep #" + step + ": Create Certificate Public Key ~~~~~~~~~~~~~~~~");

            //use keys generated in RSA method to save time
            BigInteger CertificatePublicKey = new BigInteger("103155");

            System.out.println("\tCertificatePublicKey = " + CertificatePublicKey+"  ->(3,55)");
            
            step++;
            System.out.println("\nStep #" + step + ": Create Certificate Private Key ~~~~~~~~~~~~~~~~");

            BigInteger CertificatePrivateKey = new BigInteger("127155");

            System.out.println("\tCertificatePrivateKey = " + CertificatePrivateKey+"  ->(27,55)");
            
            step++;
            System.out.println("\nStep #" + step + ": Create Public Key ~~~~~~~~~~~~~~~~");

            //use keys generated in RSA method to save time
            publicKey = new BigInteger("129135");

            System.out.println("\tPublicKey = " + publicKey+"  ->(29,35)");
            
            step++;
            System.out.println("\nStep #" + step + ": Create Private Key ~~~~~~~~~~~~~~~~");

            privateKey = new BigInteger("105135");

            System.out.println("\tPrivateKey = " + privateKey+"  ->(5,35)");
            
            
            step++;
            System.out.println("\nStep #" + step + ": Encrypt Converted Result using CertificationAuthorities ~~~~~~~~~~~~~~~~");
            
            encryptedData = CertificationAuthorities.Encrypt(publicKey, CertificatePrivateKey);

            System.out.println("\tencryptedData = " + encryptedData);

            System.out.println("\n---------Simulating sending \"encryptedData\" to receiver------------\n");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||");
            System.out.println("||||||||||||||||||Internet|||||||||||||||");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||");
          
            System.out.println("\n---------Simulating receiving the \"encryptedData\" from sender------------\n");

            System.out.println("On Receiver's Side");
            step++;
            System.out.println("\nStep #" + step + ": Receiving Data ~~~~~~~~~~~~~~~~");
            
            receivedData = encryptedData;
            
            System.out.println("\treceivedData = " + receivedData);

            step++;
            System.out.println("\nStep #" + step + ": Decrypt receivedData using CertificationAuthorities ~~~~~~~~~~~~~~~~");

            decryptedData= CertificationAuthorities.Decrypt(receivedData, CertificatePublicKey);
            
            System.out.println("\tdecryptedData Result = " + decryptedData);
            
            step++;
            System.out.println("\nStep #" + step + ": User Public Key ~~~~~~~~~~~~~~~~");
            System.out.println("\tReceived Message = " + decryptedData);
            System.out.println("\tKey = (" + decryptedData.toString().substring(1, 3)+","+decryptedData.toString().substring(4, 6)+")");
    }

}

