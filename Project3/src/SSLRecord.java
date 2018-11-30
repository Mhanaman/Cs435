import java.math.BigInteger;

public class SSLRecord{
	private BigInteger hd_Length;
	private BigInteger hd_Type;
	private BigInteger message;
	private BigInteger MAC;

	public SSLRecord(BigInteger type, BigInteger inputMessage) {
		hd_Type = type;
		message = inputMessage;
		 	
	}
}