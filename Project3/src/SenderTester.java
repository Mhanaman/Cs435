import java.math.BigInteger;

public class SenderTester {
	
	/**
     * method to test generating a message for sender
     *
     */
	public void testGenerateMessage() {
		System.out.println("Test Generating Message");
		Sender sender = new Sender();
		//BigInteger m = sender.generateMessage();
		//System.out.println("Generated Message: " + m.toString());
	}
	
	/**
     * method to test encrypting a message for sender
     *
     */
	public void testProcessMessage() {
		System.out.println("Test Processing Message");
		Sender sender = new Sender();
		AsciiConverter ascii = new AsciiConverter();
		BigInteger message = ascii.StringtoBigInt("Hello World");
		//BigInteger m = sender.processMessage(message);
		//System.out.println("Processed Message: " + m.toString());
	}
	
	/**
     * method to test sending a message to receiver
     *
     */
	public void testSendPacketToNetwork() {
		System.out.println("Test Sending Packet");

		Sender sender = new Sender();
		AsciiConverter ascii = new AsciiConverter();
		
		BigInteger packet = ascii.StringtoBigInt("Hello World");
		
		sender.sendPacketToNetwork(packet);
		
		System.out.println("Packet Delivered");
	}
}
