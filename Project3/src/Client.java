import java.math.BigInteger;
/**
 * Used to create and process the client information in the ssl handshake
 * @author  Brad Vogeler, Mark Hanaman, Clay Fyfe
* @date 9/30/2018
*/
public class Client 
{
	//client information
	public String[] methodList;
	public BigInteger clientNonce;
	public BigInteger preMasterSecret;
	public BigInteger clientKey;
	public BigInteger clientMAC;
	
	//server information
	public BigInteger serverNonce;
	public String chosenMethod;

	public Client()
	{
		methodList = new String[]{ "polyalphabeticCipher","substitutionCipher","shiftCipher"};
		clientNonce = new BigInteger("583");
		preMasterSecret = new BigInteger("1365");
	}
	
	public void generateKeys()
	{
		BigInteger firstStep = preMasterSecret.multiply(clientNonce.multiply(serverNonce));
		String secondStep = firstStep.toString();
		String stringClientKey = secondStep.substring(0,1);
		String stringClientMAC = secondStep.substring(2,3);
		clientKey = new BigInteger("stringClientKey");
		clientMAC = new BigInteger("stringClientMAC");
	}
	
	
}
