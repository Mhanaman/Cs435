import java.math.BigInteger;
/**
 * This defines the class of Network to act for the methods 
 * of receiving and sending messages 
 * @author Brad Vogeler
 */
public class Network implements NetworkADT{

    Packet inFromSender, outToReceiver;
     

    Network() {
        System.out.println("----Network is created-----");
        inFromSender = new Packet(); 
        outToReceiver =  new Packet();
    }

    /**
     * store packet as from sender 
     *
     *
     * @param pk
     */
    public void sendToReceiver(Packet pk) {
        inFromSender = pk;
    }

    /**
     * set the error condition to cause error in message
     *
     * @param error
     */
    public void setInternetCondition(int error) {
        if (error == 0) {
            outToReceiver = inFromSender;
        } else {
            
            inFromSender.setErrorInMessage(new BigInteger(Integer.toString(error)));
            outToReceiver = inFromSender;
        }
    }

    /**
     * send packet to receiver
     *
     * @return outToReceiver
     */
    public Packet receiveFromSender() {
        return outToReceiver;

    }
}
