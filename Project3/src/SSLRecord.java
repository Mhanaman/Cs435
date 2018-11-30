import java.math.BigInteger;

public class SSLRecord{
	private BigInteger hd_Length; //Length of message + type + MAC.
	//For example^ 1234567 has a length of seven. MAC 25 has a length of 2, Type 0 have a length of 1. Total 10
	private BigInteger hd_Type; //Input in Sim
	private BigInteger message; //Input in Sim
	private BigInteger MAC; /*Since both the client and server are both using the record class, the MAC will be established in the sim manually.*/

	public SSLRecord(BigInteger type, BigInteger inputMessage, BigInteger premasterSecret) {
		hd_Type = type;
		message = inputMessage;
		
		
		//Converts all values to a string
		String numDigits = "" + hd_Type + message + MAC;
		//Makes a big int equal to the length of each 
		BigInteger value = BigInteger.valueOf(numDigits.length());
		hd_Length = value;
	}
	
	public SSLRecord(String recievedSSLString) {
		//Breaks string into string array. 
		String[] parts = recievedSSLString.split(" ");
		hd_Length = new BigInteger(parts[0]);
		hd_Type = new BigInteger(parts[1]);
		message = new BigInteger(parts[2]);
		MAC = new BigInteger(parts[3]);
		
		System.out.println("SSLRecord legnth: " + hd_Length);
		System.out.println("SSLRecord Type: " + hd_Type);
		System.out.println("SSLRecord  Message: " +  message);
		System.out.println("SSLRecord MAC: " + MAC);
	}
	
	private BigInteger findMAC() {
		
	}
}