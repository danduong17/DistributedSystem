import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server_UDP {

    public static void main(String[] args){
        DatagramSocket dgSocket = null;

        try{
 
            int socketNumber = 17;
            dgSocket = new DatagramSocket(socketNumber);
            byte[] byteBuffer = new byte[1000];
            while (true){
                // get request from clients
                DatagramPacket dgRequest = new DatagramPacket(byteBuffer, byteBuffer.length);
                dgSocket.receive(dgRequest);

                String receivedMsg = new String(dgRequest.getData());
                receivedMsg.toUpperCase();
                byte[] responseBytes = receivedMsg.getBytes();

                //Do something in response to the client's request
                DatagramPacket dgResponse = new DatagramPacket(responseBytes, responseBytes.length, dgRequest.getAddress(), dgRequest.getPort());
                dgSocket.send(dgResponse);
            }


        }
        catch(SocketException e){
            System.out.println("Socket Exception: "+ e.getMessage());
        }
        catch(IOException e){
            System.out.println("IO Exception: "+e.getMessage());
        }
        finally{
            if (dgSocket!=null){
                dgSocket.close();
            }
        }
    }

    
}
