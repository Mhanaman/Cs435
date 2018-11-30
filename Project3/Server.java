import java.math.BigInterger;

/**
 * This defines the class of Receiver to act for the methods 
 * of receiving encrypted messages and dealing with them
 * @author Brad Vogeler, Mark Hanaman, Clayton Fyfe
 */

public class Server{
	
	public String[] methodList; //From Constructor
	public BigInteger serverNonce; //Pick the nonce 333
	public String chosenAlgorithm; 
	
	
	public BigInteger clientNonce; //Assigned by sim 
	public BigInteger premasterSecret; //Assigned by sim
	public BigInteger serverKey; //Generated keys 4,5 
	public BigInteger serverMAC; //generated keys 6,7 drop the last digit
	
	public Server() {
		methodList = new String[] {"cipherBlockChain","blockCipher","polyalphabeticCipher","substitutionCipher","shiftCipher"};
		serverNonce = new BigInteger("333");
	}
	
	public void pickEncryption(String[] clientList) {
		outerloop:
		//Checks if there are any matches
		try {
			//For each client algorithm, runs through every algorithm on the server side.
		for(int clientAlgorithm = 0; clientAlgorithm < clientList.length; clientAlgorithm++) {
			for(int serverAlgorithm =0; serverAlgorithm < methodList.length; serverAlgorithm++) {
				//Checks to see if strings match
				if(clientList[clientAlgorithm] == methodList[serverAlgorithm]) 
					{
					    //Prints out the algorithm
						System.out.println("Algorithm: " + methodList[serverAlgorithm]);
						//Assigns algorithm to public string
						chosenAlgorithm = methodList[serverAlgorithm];
						//Breaks out of loop so that future algorithms aren't assigned over it.
						break outerloop;
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("No matching algorithms");
		}
	}
	
	public void generateKeys() {
		BigInteger firstStep = preMasterSecret.multiply(clientNonce.multiply(serverNonce));
		String secondStep = firstStep.toString();
		String stringServerKey = secondStep.substring(4,5);		
		String stringServerMAC = secondStep.substring(6,7);
		serverKey = new BigInteger("stringClientKey");
		serverMAC = new BigInteger("stringClientMAC");
	}
}