import java.math.BigInteger;

public class NetworkTester {

	/**
     * method to test receiving packet from sender
     *
     */
	public void testGetPacketFromSender() {
		System.out.println("Test Get Packet From Sender");
		Network network= new Network();
		
		//BigInteger m = network.getPacketFromSender();
		//System.out.println("Received Packet: " + m.toString());
	}
	

	/**
     * method to test delivering packet to receiver
     *
     */
	public void testDeliverPacketToReceiver() {
		System.out.println("Test Deliver Packet to Receiver");
		Network network= new Network();
		AsciiConverter ascii = new AsciiConverter();
		BigInteger message = ascii.StringtoBigInt("Hello World");
		
		//network.sendToReceiver(message);

		System.out.println("Packet Delivered");
	}
	

	/**
     * method to test packet hacking
     *
     */
	public void testPacketGetHacked() {
		System.out.println("Test Packet Get Hacked");
		Network network= new Network();
		AsciiConverter ascii = new AsciiConverter();
		BigInteger hack = ascii.StringtoBigInt("Hacked");
		
		//BigInteger m = network.packetGetHacked(hack);

		//System.out.println("Hacked Packet: " + m);
		
	}
}
