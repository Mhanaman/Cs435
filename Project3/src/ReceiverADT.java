import java.math.BigInteger;

/**
 * The interface of Receiver
 * to control the Receiver's actions (Bob)
 * @author Brad Vogeler
 */
public interface ReceiverADT {
	
	/**
     * receive a message and store it
     * 
     * @param the Network linking sender and receiver
     *
     *
     */
	public void receive(Network net);
	
	/**
     * Take the string / message and decrypt it using various
     * methods and classes to keep it confidential
     * and sustain integrity
     *
     * @param message BigInteger message to be converted
     * @return the BigInteger data of the Decrypted message 
     *
     */
	public Packet processPacket(String str);
	
	/**
     * get the message of the receiver 
     *
     * @return message of receiver
     *
     */
	public Packet getPacket();

}
