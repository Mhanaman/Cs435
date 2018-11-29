import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author yunwang
 */
public class SecureMessageSystem {

	/**
	 *
	 * @param args
	 */

	public static void main(String[] args) {

		Sender amy = new Sender();
		Receiver bob = new Receiver();
		Network net = new Network();
		

		System.out.println("Test SHIFT >> RSA >> HASH >> CA");
		int step = 0;

		System.out.println("\nStep:" + ++step + " Sender generate Message");
		System.out.print(amy.generateMessage().toString());

		System.out.println("\nStep:" + ++step + " Encrypt Message Using Shift Cipher");
		System.out.println("Encrypted Message :" + amy.processMessage("ShiftCipher"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using RSA");
		System.out.println("Encrypted Message :" + amy.processMessage("RSA"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using Hash");
		System.out.println("Hashed Message :" + amy.processMessage("Hash"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using CertificationAuthorities");
		System.out.println("Encrypted Message & Signature:" + amy.processMessage("CertificationAuthorities"));

		System.out.println("\n ------Sender sends the test packet to Receiver through internet" + "\n");

		net.sendToReceiver(amy.getPacket());

		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");

		net.setInternetCondition(0);

		System.out.println("------Asumme perfect Internet with no error----- ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| " + "\n");

		System.out.println("------Receiver receives the test packet through network");

		bob.receive(net);
		System.out.println("\nStep:" + ++step + " Decrypt Message Using CertificationAuthorities");
		System.out.println("Decrypted Message :");
		if(bob.processPacket("CertificationAuthorities") != null) {

		System.out.println("\nStep:" + ++step + " Decrypt Message Using RSA");
		System.out.println("Decrypted Message :" + bob.processPacket("RSA"));

		System.out.println("\nStep:" + ++step + " Decrypt Message Using ShiftCipher");
		System.out.println("Decrypted Message :" + bob.processPacket("ShiftCipher"));
		}

		System.out.println("Test CBC >> RSA >> MAC >> CA");
		step = 0;

		System.out.println("\nStep:" + ++step + " Sender generate Message");
		System.out.print(amy.generateMessage().toString());

		System.out.println("\nStep #" + step + ": Generate a random Block Cipher ~~~~~~~~~~~~~~~~");
		Random gen = new Random();
		// use the numbers 128 to randomly generate a map
		ArrayList<Integer> list128 = new ArrayList<Integer>();
		for (int i = 0; i < 128; i++)
			list128.add(i);

		int currentSlot = 0;
		int[] mapList = new int[128];
		// for all 128 numbers, randomly swap them
		while (list128.size() > 1) {
			int rnd = gen.nextInt(list128.size());
			if (list128.get(rnd) != currentSlot) {
				mapList[currentSlot] = list128.get(rnd);
				mapList[list128.remove(rnd)] = currentSlot;
				list128.remove(list128.indexOf(currentSlot));
				if (list128.size() > 0)
					currentSlot = list128.get(0);
			}
		}

		BlockCipher BlockCipher = new BlockCipher();

		BigInteger[] map = new BigInteger[128];
		for (int i = 0; i < mapList.length; i++) {
			map[i] = new BigInteger(BlockCipher.ConvertStringToBinary("" + mapList[i]));
		}

		if (list128.isEmpty())
			System.out.println("\tSuccess!");

		amy.setMap(map);
		bob.setMap(map);
		System.out.println("\nStep:" + ++step + " Make IV");
		System.out.println("IV + Message :" + amy.setMessage(new BigInteger("23")));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using Cipher Block Chaining");
		System.out.println("Encrypted Message :" + amy.processMessage("CipherBlockChaining"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using RSA");
		System.out.println("Encrypted Message :" + amy.processMessage("RSA"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using MAC");
		System.out.println("Hashed Message :" + amy.processMessage("MAC"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using CertificationAuthorities");
		System.out.println("Encrypted Message & Signature:" + amy.processMessage("CertificationAuthorities"));

		System.out.println("\n ------Sender sends the test packet to Receiver through internet" + "\n");

		net.sendToReceiver(amy.getPacket());

		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");

		net.setInternetCondition(0);

		System.out.println("------Asumme perfect Internet with no error----- ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| " + "\n");

		System.out.println("------Receiver receives the test packet through network");

		bob.receive(net);
		System.out.println("\nStep:" + ++step + " Decrypt Message Using CertificationAuthorities");
		System.out.println("Decrypted Message :");
		if(bob.processPacket("CertificationAuthorities")!=null) {

		System.out.println("\nStep:" + ++step + " Decrypt Message Using MAC");
		System.out.println("Decrypted Message :");

		if(bob.processPacket("MAC")!=null) {

		System.out.println("\nStep:" + ++step + " Decrypt Message Using RSA");
		System.out.println("Decrypted Message :" + bob.processPacket("RSA"));

		System.out.println("\nStep:" + ++step + " Decrypt Message Using Cipher Block Chaining");
		System.out.println("Decrypted Message :" + bob.processPacket("CipherBlockChaining"));

		}
		}
		
		System.out.println("Test SubstitutionCipher>> RSA >> DigitalSignature >> CA");
		step = 0;

		System.out.println("\nStep:" + ++step + " Sender generate Message");
		System.out.print(amy.generateMessage().toString());

		System.out.println("\nStep:" + ++step + " Encrypt Message Using Substitution Cipher");
		System.out.println("Encrypted Message :" + amy.processMessage("SubstitutionCipher"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using RSA");
		System.out.println("Encrypted Message :" + amy.processMessage("RSA"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using DigitalSignature");
		System.out.println("Hashed Message :" + amy.processMessage("DigitalSignature"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using CertificationAuthorities");
		System.out.println("Encrypted Message & Signature:" + amy.processMessage("CertificationAuthorities"));

		System.out.println("\n ------Sender sends the test packet to Receiver through internet" + "\n");

		net.sendToReceiver(amy.getPacket());

		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");

		net.setInternetCondition(0);

		System.out.println("------Asumme perfect Internet with no error----- ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| " + "\n");

		System.out.println("------Receiver receives the test packet through network");

		bob.receive(net);
		System.out.println("\nStep:" + ++step + " Decrypt Message Using CertificationAuthorities");
		System.out.println("Decrypted Message :");
		if(bob.processPacket("CertificationAuthorities")!=null) {

		System.out.println("\nStep:" + ++step + " Decrypt Message Using DigitalSignature");
		System.out.println("Decrypted Message :");
		if(bob.processPacket("DigitalSignature")!=null) {

		System.out.println("\nStep:" + ++step + " Decrypt Message Using RSA");
		System.out.println("Decrypted Message :" + bob.processPacket("RSA"));

		System.out.println("\nStep:" + ++step + " Decrypt Message Using Substitution Cipher");
		System.out.println("Decrypted Message :" + bob.processPacket("SubstitutionCipher"));
		}
		}

		System.out.println("Test Polyalphabetic cipher >> RSA >> DigitalSignature >> CA");
		step = 0;

		System.out.println("\nStep:" + ++step + " Sender generate Message");
		System.out.print(amy.generateMessage().toString());

		System.out.println("\nStep:" + ++step + " Encrypt Message Using Polyalphabetic Cipher");
		System.out.println("Encrypted Message :" + amy.processMessage("PolyalphabeticCipher"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using RSA");
		System.out.println("Encrypted Message :" + amy.processMessage("RSA"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using DigitalSignature");
		System.out.println("Hashed Message :" + amy.processMessage("DigitalSignature"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using CertificationAuthorities");
		System.out.println("Encrypted Message & Signature:" + amy.processMessage("CertificationAuthorities"));

		System.out.println("\n ------Sender sends the test packet to Receiver through internet" + "\n");

		net.sendToReceiver(amy.getPacket());

		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");

		net.setInternetCondition(0);

		System.out.println("------Asumme perfect Internet with no error----- ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| " + "\n");

		System.out.println("------Receiver receives the test packet through network");

		bob.receive(net);
		System.out.println("\nStep:" + ++step + " Decrypt Message Using CertificationAuthorities");
		System.out.println("Decrypted Message :");
		if(bob.processPacket("CertificationAuthorities")!=null) {

		System.out.println("\nStep:" + ++step + " Decrypt Message Using DigitalSignature");
		System.out.println("Decrypted Message :");
		if(bob.processPacket("DigitalSignature")!=null) {

		System.out.println("\nStep:" + ++step + " Decrypt Message Using RSA");
		System.out.println("Decrypted Message :" + bob.processPacket("RSA"));

		System.out.println("\nStep:" + ++step + " Decrypt Message Using Polyalphabetic Cipher");
		System.out.println("Decrypted Message :" + bob.processPacket("PolyalphabeticCipher"));
		}
		}

		System.out.println("Test Polyalphabetic cipher >> Substitution Cipher >> DigitalSignature >> CA");
		step = 0;

		System.out.println("\nStep:" + ++step + " Sender generate Message");
		System.out.print(amy.generateMessage().toString());

		System.out.println("\nStep:" + ++step + " Encrypt Message Using Polyalphabetic Cipher");
		System.out.println("Encrypted Message :" + amy.processMessage("PolyalphabeticCipher"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using Substitution Cipher");
		System.out.println("Encrypted Message :" + amy.processMessage("SubstitutionCipher"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using DigitalSignature");
		System.out.println("Hashed Message :" + amy.processMessage("DigitalSignature"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using CertificationAuthorities");
		System.out.println("Encrypted Message & Signature:" + amy.processMessage("CertificationAuthorities"));

		System.out.println("\n ------Sender sends the test packet to Receiver through internet" + "\n");

		net.sendToReceiver(amy.getPacket());

		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");

		net.setInternetCondition(0);

		System.out.println("------Asumme perfect Internet with no error----- ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| " + "\n");

		System.out.println("------Receiver receives the test packet through network");

		bob.receive(net);
		System.out.println("\nStep:" + ++step + " Decrypt Message Using CertificationAuthorities");
		System.out.println("Decrypted Message :");

		if(bob.processPacket("CertificationAuthorities")!=null) {

		System.out.println("\nStep:" + ++step + " Decrypt Message Using DigitalSignature");
		System.out.println("Decrypted Message :");

		if(bob.processPacket("DigitalSignature")!=null) {

		System.out.println("\nStep:" + ++step + " Decrypt Message Using Substitution Cipher");
		System.out.println("Decrypted Message :" + bob.processPacket("SubstitutionCipher"));

		System.out.println("\nStep:" + ++step + " Decrypt Message Using Polyalphabetic Cipher");
		System.out.println("Decrypted Message :" + bob.processPacket("PolyalphabeticCipher"));
		}
		}

		// -------------------------------------------------------
		// ------------ TEST WITH NETWORK ATTACKS----------------
		// -------------------------------------------------------

		System.out.println("Test SHIFT >> RSA >> HASH >> CA");
		step = 0;

		System.out.println("\nStep:" + ++step + " Sender generate Message");
		System.out.print(amy.generateMessage().toString());

		System.out.println("\nStep:" + ++step + " Encrypt Message Using Shift Cipher");
		System.out.println("Encrypted Message :" + amy.processMessage("ShiftCipher"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using RSA");
		System.out.println("Encrypted Message :" + amy.processMessage("RSA"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using Hash");
		System.out.println("Hashed Message :" + amy.processMessage("Hash"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using CertificationAuthorities");
		System.out.println("Encrypted Message & Signature:" + amy.processMessage("CertificationAuthorities"));

		System.out.println("\n ------Sender sends the test packet to Receiver through internet" + "\n");

		net.sendToReceiver(amy.getPacket());

		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");

		net.setInternetCondition(1);

		System.out.println("------Asumme Compromised Internet with error----- ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| " + "\n");

		System.out.println("------Receiver receives the test packet through network");

		bob.receive(net);
		System.out.println("\nStep:" + ++step + " Decrypt Message Using CertificationAuthorities");
		System.out.println("Decrypted Message :");

		if(bob.processPacket("CertificationAuthorities")!=null) {

		System.out.println("\nStep:" + ++step + " Decrypt Message Using RSA");
		System.out.println("Decrypted Message :" + bob.processPacket("RSA"));

		System.out.println("\nStep:" + ++step + " Decrypt Message Using ShiftCipher");
		System.out.println("Decrypted Message :" + bob.processPacket("ShiftCipher"));
		}

		System.out.println("Test CBC >> RSA >> MAC >> CA");
		step = 0;

		System.out.println("\nStep:" + ++step + " Sender generate Message");
		System.out.print(amy.generateMessage().toString());

		amy.setMap(map);
		bob.setMap(map);
		System.out.println("\nStep:" + ++step + " Make IV");
		System.out.println("IV + Message :" + amy.setMessage(new BigInteger("123")));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using Cipher Block Chaining");
		System.out.println("Encrypted Message :" + amy.processMessage("CipherBlockChaining"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using RSA");
		System.out.println("Encrypted Message :" + amy.processMessage("RSA"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using MAC");
		System.out.println("Hashed Message :" + amy.processMessage("MAC"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using CertificationAuthorities");
		System.out.println("Encrypted Message & Signature:" + amy.processMessage("CertificationAuthorities"));

		System.out.println("\n ------Sender sends the test packet to Receiver through internet" + "\n");

		net.sendToReceiver(amy.getPacket());

		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");

		net.setInternetCondition(1);

		System.out.println("------Asumme Compromised Internet with error----- ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| " + "\n");

		System.out.println("------Receiver receives the test packet through network");

		bob.receive(net);
		System.out.println("\nStep:" + ++step + " Decrypt Message Using CertificationAuthorities");
		System.out.println("Decrypted Message :");

		if(bob.processPacket("CertificationAuthorities")!=null) {

		System.out.println("\nStep:" + ++step + " Decrypt Message Using MAC");
		System.out.println("Decrypted Message :");

		if(bob.processPacket("MAC")!=null) {

		System.out.println("\nStep:" + ++step + " Decrypt Message Using RSA");
		System.out.println("Decrypted Message :" + bob.processPacket("RSA"));

		System.out.println("\nStep:" + ++step + " Decrypt Message Using Cipher Block Chaining");
		System.out.println("Decrypted Message :" + bob.processPacket("CipherBlockChaining"));
		}
		}

		System.out.println("Test SubstitutionCipher>> RSA >> DigitalSignature >> CA");
		step = 0;

		System.out.println("\nStep:" + ++step + " Sender generate Message");
		System.out.print(amy.generateMessage().toString());

		System.out.println("\nStep:" + ++step + " Encrypt Message Using Substitution Cipher");
		System.out.println("Encrypted Message :" + amy.processMessage("SubstitutionCipher"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using RSA");
		System.out.println("Encrypted Message :" + amy.processMessage("RSA"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using DigitalSignature");
		System.out.println("Hashed Message :" + amy.processMessage("DigitalSignature"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using CertificationAuthorities");
		System.out.println("Encrypted Message & Signature:" + amy.processMessage("CertificationAuthorities"));

		System.out.println("\n ------Sender sends the test packet to Receiver through internet" + "\n");

		net.sendToReceiver(amy.getPacket());

		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");

		net.setInternetCondition(1);

		System.out.println("------Asumme Compromised Internet with error----- ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| " + "\n");

		System.out.println("------Receiver receives the test packet through network");

		bob.receive(net);
		System.out.println("\nStep:" + ++step + " Decrypt Message Using CertificationAuthorities");
		System.out.println("Decrypted Message :");

		if(bob.processPacket("CertificationAuthorities")!=null) {

		System.out.println("\nStep:" + ++step + " Decrypt Message Using DigitalSignature");
		System.out.println("Decrypted Message :");

		if(bob.processPacket("DigitalSignature")!=null) {

		System.out.println("\nStep:" + ++step + " Decrypt Message Using RSA");
		System.out.println("Decrypted Message :" + bob.processPacket("RSA"));

		System.out.println("\nStep:" + ++step + " Decrypt Message Using Substitution Cipher");
		System.out.println("Decrypted Message :" + bob.processPacket("SubstitutionCipher"));
		}
		}

		System.out.println("Test Polyalphabetic cipher >> RSA >> DigitalSignature >> CA");
		step = 0;

		System.out.println("\nStep:" + ++step + " Sender generate Message");
		System.out.print(amy.generateMessage().toString());

		System.out.println("\nStep:" + ++step + " Encrypt Message Using Polyalphabetic Cipher");
		System.out.println("Encrypted Message :" + amy.processMessage("PolyalphabeticCipher"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using RSA");
		System.out.println("Encrypted Message :" + amy.processMessage("RSA"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using DigitalSignature");
		System.out.println("Hashed Message :" + amy.processMessage("DigitalSignature"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using CertificationAuthorities");
		System.out.println("Encrypted Message & Signature:" + amy.processMessage("CertificationAuthorities"));

		System.out.println("\n ------Sender sends the test packet to Receiver through internet" + "\n");

		net.sendToReceiver(amy.getPacket());

		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");

		net.setInternetCondition(1);

		System.out.println("------Asumme Compromised Internet with error----- ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| " + "\n");

		System.out.println("------Receiver receives the test packet through network");

		bob.receive(net);
		System.out.println("\nStep:" + ++step + " Decrypt Message Using CertificationAuthorities");
		System.out.println("Decrypted Message :");

		if(bob.processPacket("CertificationAuthorities")!=null) {

		System.out.println("\nStep:" + ++step + " Decrypt Message Using DigitalSignature");
		System.out.println("Decrypted Message :");

		if(bob.processPacket("DigitalSignature")!=null) {

		System.out.println("\nStep:" + ++step + " Decrypt Message Using RSA");
		System.out.println("Decrypted Message :" + bob.processPacket("RSA"));

		System.out.println("\nStep:" + ++step + " Decrypt Message Using Polyalphabetic Cipher");
		System.out.println("Decrypted Message :" + bob.processPacket("PolyalphabeticCipher"));
		}
		}

		System.out.println("Test Polyalphabetic cipher >> Substitution Cipher >> DigitalSignature >> CA");
		step = 0;

		System.out.println("\nStep:" + ++step + " Sender generate Message");
		System.out.print(amy.generateMessage().toString());

		System.out.println("\nStep:" + ++step + " Encrypt Message Using Polyalphabetic Cipher");
		System.out.println("Encrypted Message :" + amy.processMessage("PolyalphabeticCipher"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using Substitution Cipher");
		System.out.println("Encrypted Message :" + amy.processMessage("SubstitutionCipher"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using DigitalSignature");
		System.out.println("Hashed Message :" + amy.processMessage("DigitalSignature"));

		System.out.println("\nStep:" + ++step + " Encrypt Message Using CertificationAuthorities");
		System.out.println("Encrypted Message & Signature:" + amy.processMessage("CertificationAuthorities"));

		System.out.println("\n ------Sender sends the test packet to Receiver through internet" + "\n");

		net.sendToReceiver(amy.getPacket());

		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");

		net.setInternetCondition(1);

		System.out.println("------Asumme Compromised Internet with error----- ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| ");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||| " + "\n");

		System.out.println("------Receiver receives the test packet through network");

		bob.receive(net);
		System.out.println("\nStep:" + ++step + " Decrypt Message Using CertificationAuthorities");
		System.out.println("Decrypted Message :");

		if(bob.processPacket("CertificationAuthorities")!=null) {

		System.out.println("\nStep:" + ++step + " Decrypt Message Using DigitalSignature");
		System.out.println("Decrypted Message :");

		if(bob.processPacket("DigitalSignature")!=null) {

		System.out.println("\nStep:" + ++step + " Decrypt Message Using Substitution Cipher");
		System.out.println("Decrypted Message :" + bob.processPacket("SubstitutionCipher"));

		System.out.println("\nStep:" + ++step + " Decrypt Message Using Polyalphabetic Cipher");
		System.out.println("Decrypted Message :" + bob.processPacket("PolyalphabeticCipher"));
		}
		}

	}

}
