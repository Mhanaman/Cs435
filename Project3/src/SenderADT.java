import java.math.BigInteger;
/**
 * The interface of Sender
 * to control the sender's actions (Alice)
 * @author Brad Vogeler
 */
public interface SenderADT {
	
	/**
     * create a message and change it into 
     * a Packet to be used by processMessage
     *
     * @return the Packet data of the new message
     *
     */
	public Packet generateMessage();
	
	/**
     * Take the string / message and encrypt it using various
     * methods and classes to keep it confidential
     * and sustain integrity
     *
     * @param inStr BigInteger message to be converted
     * @return the BigInteger data of the Encrypted inStr 
     *
     */
	public Packet processMessage(String str);
	
	/**
     * Send the Encrypted BigInteger to the network class
     * to be "sent" to the receiver
     *
     * @param inStr BigInteger message to be transfered
     *
     */
	public void sendPacketToNetwork(BigInteger inStr);
}
