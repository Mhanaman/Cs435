
public class Handshake 
{
	private MethodList<BigInteger> = new ArrayList<BigInteger>();

	public void Handshake()
	{
		//•	Client sends list of algorithms it supports, along with client nonce

		//•	Server chooses algorithms from list; sends back: choice + certificate + server nonce

		//•	Client verifies certificate, extracts server’s public key, generates pre_master_secret, encrypts with server’s public key, sends to server

		//•	Client and server independently compute encryption and MAC keys from pre_master_secret and nonces

		//•	Client sends a MAC of all the handshake messages

		//•	Server sends a MAC of all the handshake messages

		//•	Client and server independently verify the MAC received from each other and establish the secure SSL Connection
		
	
	}
}
