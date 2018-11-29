import java.math.BigInteger;

public class SSLRecordKeeper 
{
    private BigInteger hd_Length;
    private BigInteger hd_Type;
    private BigInteger message;
    private BigInteger MAC;
    
    public void SSLRecorKeeper(BigInteger userMessage, BigInteger userType)
    {
    	message = userMessage;
    	hd_Type = userType;
    }
    
    

}
