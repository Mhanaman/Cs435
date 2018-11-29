import java.math.BigInteger;

public class ReceiverTester {
	
	/**
     * method to test receiving packet from sender
     *
     */
	public void testReceivePacket() {
		System.out.println("Test Receive Packet");
		Receiver receiver = new Receiver();
		AsciiConverter ascii = new AsciiConverter();
		BigInteger message = ascii.StringtoBigInt("Hello World");
		
		//BigInteger m = receiver.receivePacket(message);
		//System.out.println("Received Packet: " + m.toString());
	}
	

	/**
     * method to test processing packet from sender
     *
     */
	public void testProcessPacket() {
		System.out.println("Test process Packet");
		Receiver receiver = new Receiver();
		AsciiConverter ascii = new AsciiConverter();
		BigInteger message = ascii.StringtoBigInt("Hello World");
		
		//BigInteger m = receiver.processPacket(message);

		//System.out.println("Processed Packet: " + m.toString());
	}
	

	/**
     * method to test getting message from receiver
     *
     */
	public void testGetMessage() {
		System.out.println("Test get message");
		Receiver receiver = new Receiver();

		//System.out.println("Retreived Message: " + receiver.getMessage().toString());
		
	}
}
