import java.math.BigInteger;

/**
 * The interface of Network
 * to control the transfer and attacks
 * @author Brad Vogeler
 */
public interface NetworkADT {

	/**
     * Retrieves the package being sent
     *
     * @return Packet the packet from sender
     *
     */
	public Packet receiveFromSender();
	
	/**
     * sends the package from the sender to the receiver
     * 
     * @param Packet message being sent to the receiver
     *
     */
	public void sendToReceiver(Packet pk);
	
	/**
     * take the packet being sent in the network and
     * change it so it has been tampered with 
     *
     * @param int the error added from hacker
     *
     */
	public void setInternetCondition(int error);
}
