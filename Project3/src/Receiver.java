import java.math.BigInteger;

/**
 * This defines the class of Receiver to act for the methods 
 * of receiving encrypted messages and dealing with them
 * @author Brad Vogeler
 */
public class Receiver implements ReceiverADT{

    
    private Packet rcvPacket;
    public final BigInteger PrivateKeyD = new BigInteger(""+27);
    public final BigInteger PrivateKeyN = new BigInteger(""+55);
    public final BigInteger senderPublicKeyE = new BigInteger(""+3);
    public final BigInteger senderPublicKeyN = new BigInteger(""+55);
    
    private BigInteger[] map;
    private BigInteger secret = new BigInteger("49");

    private BigInteger certPublicKey = new BigInteger(""+467671); 
  
   
    public Receiver() {
        System.out.println("----- Receiver is created -------");

   
        rcvPacket = new Packet();
       
   }

    /**
     * save packet on the class
     *
     * @param Network, the network between the sender and receiver
     *
     */
   public void receive(Network net) {

        System.out.println(" Receiver Receives the packet from Internet rcvPacket ");
        rcvPacket = net.receiveFromSender();       

        System.out.println("Packet is: "
                + rcvPacket.toString());
    }


   /**
    * Decrypt the message and return the updated packet
    *
    * @param String the message to be decrypted
    * @return the Packet of the decrpyted data
    *
    */
	@Override
	public Packet processPacket(String str) {
		switch(str) {
		
		case "CertificationAuthorities":
			CertificationAuthorities certificationAuthorities = new CertificationAuthorities();
			
			if(certificationAuthorities.Decrypt(new BigInteger(rcvPacket.getMessage().toString().substring(rcvPacket.getMessage().toString().length() - 6, rcvPacket.getMessage().toString().length())),certPublicKey).equals(new BigInteger(""+senderPublicKeyE+senderPublicKeyN))){
				System.out.println("------------Certificate Approved------------");
				String s = rcvPacket.getMessage().toString().substring(0,rcvPacket.getMessage().toString().length()-7);
				rcvPacket.setMessage(new BigInteger(s));
				
			}
			else {
				System.out.println("------------Certificate FAILED!------------");
				return null;
			}
			break;
			
		case "CipherBlockChaining":
				CipherBlockChaining CBC = new CipherBlockChaining();
				CBC.Decrypt(rcvPacket.getMessage(), map);
			
			break;
			
		case "RSA":
			RSA rsa = new RSA();
			rcvPacket.setMessage(rsa.Decrypt(rcvPacket.getMessage(), PrivateKeyD, PrivateKeyN));

			break;
			
		case "Hash":
			rcvPacket.setMessage(new BigInteger(""+rcvPacket.getMessage().mod(PrivateKeyN)));
			break;
			
		case "ShiftCipher":
			ShiftCipher shiftCipher = new ShiftCipher();
			rcvPacket.setMessage(shiftCipher.Decrypt(rcvPacket.getMessage(),rcvPacket.getSessionKey()));
			break;
			
		case "MAC":
			MessageAuthenticationCode mac = new MessageAuthenticationCode();
			if(mac.Authenticate(secret, rcvPacket.getMessage(), rcvPacket.getSessionKey())) {
				System.out.println("------------Authentication Approved------------");
				String s = rcvPacket.getMessage().toString().substring(3,rcvPacket.getMessage().toString().length());
				rcvPacket.setMessage(new BigInteger(s));
			}
			else {
				System.out.println("------------Authentication FAILED!------------");
				return null;
			}
				break;
			
		case "SubstitutionCipher":
			SubstitutionCipher sub = new SubstitutionCipher();
			String key = "2345678901";
			System.out.println("The Key is: "+key);
			rcvPacket.setMessage(new BigInteger(""+sub.Decrypt(rcvPacket.getMessage().toString(), key)));
			break;
			
		case "PolyalphabeticCipher":
			PolyalphabeticCipher poly = new PolyalphabeticCipher();
			rcvPacket.setMessage(poly.Decrypt(rcvPacket.getMessage(), rcvPacket.getSessionKey()));
			break;
			
		case "DigitalSignature":
				DigitalSignatures DS = new DigitalSignatures();
			if(DS.Authenticate(rcvPacket.getMessage(), rcvPacket.getSessionKey(),new BigInteger(""+senderPublicKeyE + senderPublicKeyN))) {
				System.out.println("------------Authentication Approved------------");
				String s = rcvPacket.getMessage().toString().substring(0,rcvPacket.getMessage().toString().length()-3);
				rcvPacket.setMessage(new BigInteger(s));
			}
			else {
				System.out.println("------------Authentication FAILED!------------");
				return null;
			}
			break;
		
		}
			
		return rcvPacket;
	}


    /**
     * return the receivers packet
     *
     * @return the Packet data of the receiver
     *
     */
	@Override
	public Packet getPacket() {
		return rcvPacket;
	}

    /**
     * set the shared map for use later
     *
     * @param BigInteger[] map/key 
     */
	public void setMap(BigInteger[] m) {
		map = m;
	}
    



}
