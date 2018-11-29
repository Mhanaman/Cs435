import java.math.BigInteger;
import java.util.Random;
/**
 * This defines the class of Sender to act for the methods 
 * of sending encrypted messages
 * @author Brad Vogeler
 */
public class Sender implements SenderADT{

    private Packet pk;
 
    public final BigInteger publicKeyE = new BigInteger(""+3);
    public final BigInteger publicKeyN = new BigInteger(""+55);
    public final BigInteger PrivateKeyD = new BigInteger(""+27);
    public final BigInteger PrivateKeyN = new BigInteger(""+55);

    private BigInteger[] map;
    private BigInteger secret = new BigInteger("49");
    
    private BigInteger certPrivateKey = new BigInteger(""+203671); 
  
    public Sender() {
        System.out.println("----Sender is created-----");
        pk = new Packet(new BigInteger("13"), new BigInteger("2"),new BigInteger("5"));
        System.out.println("The test packet to be sent to network is :\n " + pk.toString());
    }
    /**
     * get the packet
     *
     * @return the Packet data 
     *
     */
    public Packet getPacket(){
       
           return pk;
    
    }
    
    /**
     * create a message and change it into 
     * a BigInteger to be used by processMessage
     *
     * @return the BigInteger data of the new message
     *
     */
	public Packet generateMessage(int n) {
		//generate a message between 0 and n
		BigInteger newMessage = new BigInteger(""+(new Random().nextInt(n)+1));
		//return the packet with the old information and new message
		return pk = new Packet(pk.getSessionKey(),newMessage,pk.getSignature());
	}
	/**
     * create a message and change it into 
     * a BigInteger to be used by processMessage
     *
     * @return the BigInteger data of the new message
     *
     */
	public Packet generateMessage() {
		//generate a message between 1 and 25
		BigInteger newMessage = new BigInteger(""+(new Random().nextInt(25)+1));
		//return the packet with the old information and new message
		return pk = new Packet(pk.getSessionKey(),newMessage,pk.getSignature());
	}
	/**
     * Encrypt a message str 
     *
     *
     *@param str the string message
     * @return the encrypted Packet
     *
     */
	public Packet processMessage(String str) {
		switch(str) {
		
		case "CertificationAuthorities":
			CertificationAuthorities certificationAuthorities = new CertificationAuthorities();
			//sign encrypted public key to the end of the message
			pk.setMessage(new BigInteger(""+pk.getMessage()+certificationAuthorities.Encrypt(new BigInteger(""+publicKeyE+publicKeyN),certPrivateKey)));
			break;
			
		case "CipherBlockChaining":
			CipherBlockChaining CBC = new CipherBlockChaining();
			CBC.Encrypt(pk.getMessage(), map);
			break;
			
		case "RSA":
			RSA rsa = new RSA();
			BigInteger rsaReceived = rsa.Encrypt(pk.getMessage(), publicKeyE, publicKeyN);
	        pk.setMessage(new BigInteger(rsaReceived.toString()));
			break;
			
		case "Hash":
			int n = pk.getMessage().toString().length();
			pk.setMessage(new BigInteger(""+pk.getMessage().mod(publicKeyN)));
			break;
			
		case "ShiftCipher":
			ShiftCipher shiftCipher = new ShiftCipher();
			pk.setMessage(shiftCipher.Encrypt(pk.getMessage(),pk.getSessionKey()));
			break;
			
		case "MAC":
			MessageAuthenticationCode mac = new MessageAuthenticationCode();
			pk.setMessage(mac.Encrypt(secret, pk.getMessage(), pk.getSessionKey()));
			break;
			
		case "SubstitutionCipher":
			SubstitutionCipher sub = new SubstitutionCipher();
			String key = "2345678901";
			System.out.println("The Key is: "+key);
			pk.setMessage(new BigInteger(""+sub.Encrypt(pk.getMessage().toString(), key)));
			break;
			
		case "PolyalphabeticCipher":
			PolyalphabeticCipher poly = new PolyalphabeticCipher();
			pk.setMessage(poly.Encrypt(pk.getMessage(), pk.getSessionKey()));
			break;
			
		case "DigitalSignature":
			DigitalSignatures DS = new DigitalSignatures();
			pk.setMessage(DS.Encrypt(pk.getMessage(), pk.getSessionKey(),new BigInteger(""+PrivateKeyD + PrivateKeyN)));
			break;
		}
			
		return pk;
	}
	
	public void setMap(BigInteger[] m) {
		map = m;
	}
	/**
     * set message to the packet
     *
     *@param BigInteger of the message to be set
     * @return the Packet data of the new message
     *
     */
	public Packet setMessage(BigInteger msg) {
		return pk = new Packet(pk.getSessionKey(),new BigInteger(""+pk.getMessage() + msg),pk.getSignature());
	}
	@Override
	public void sendPacketToNetwork(BigInteger inStr) {
		// TODO Auto-generated method stub
		
	}
}
