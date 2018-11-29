import java.math.BigInteger;


public class Packet {

    private BigInteger sessionKey;
    private BigInteger message;
    private BigInteger signature;

    Packet() {

        sessionKey = BigInteger.ZERO;
        message = BigInteger.ZERO;
        signature = BigInteger.ZERO;

    }

    public Packet(BigInteger sessionKey, BigInteger message, BigInteger signature) {
        this.sessionKey = sessionKey;
        this.message = message;
        this.signature = signature;
    }

    /**
     * @return the sessionKey
     */
    public BigInteger getSessionKey() {
        return sessionKey;
    }

    /**
     * @param sessionKey the sessionKey to set
     */
    public void setSessionKey(BigInteger sessionKey) {
        this.sessionKey = sessionKey;
    }

    /**
     * @return the message
     */
    public BigInteger getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(BigInteger message) {
        this.message = message;
    }

    /**
     *
     * @param error
     */
    public void setErrorInMessage(BigInteger error) {
        this.message = this.message.add(error);
    }

    /**
     * @return the signature
     */
    public BigInteger getSignature() {
        return signature;
    }

    /**
     * @param signature
     */
    public void setSignature(BigInteger signature) {
        this.signature = signature;
    }

    public String toString() {

        String result = " ";

        result = result + "pk.message 'Ks(m)' = " + this.message.toString() + "\n"
                + "pk.signature 'Ks(Ka-(H(m)))' = " + this.signature.toString() + "\n"
                + "pk.sessionKey  'Kb+(Ks)' =" + this.sessionKey.toString() + "\n";

        return result;
    }

    
    
    
}
