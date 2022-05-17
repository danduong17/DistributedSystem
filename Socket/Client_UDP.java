package Socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.InetAddress;

public class Client_UDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket dgSocket = null;
        String hostName = "localhost";
        int port = 17;
        String 

        try {
            dgSocket = new DatagramSocket();
            byte[] bytes = args[0].getBytes();
            InetAddress serverHost = InetAddress.getByName(args[1]);
            int serverPortNumber = Integer.valueOf(args[2]).intValue();

            DatagramPacket dgRequest = new DatagramPacket(bytes, args[0].length(), serverHost, port); //serverPortNumber

            dgSocket.send(dgRequest);

            byte[] byteBuffer = new byte[1000];
            DatagramPacket dgResponse = new DatagramPacket(byteBuffer, byteBuffer.length, serverHost, serverPortNumber);
            dgSocket.receive(dgResponse);
            System.out.println("Datagram Response: " + new String(dgResponse.toString()));
        }
        catch (SocketException e) {
            System.out.println("Socket Exception: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
        finally {
            if (dgSocket != null) 
                dgSocket.close();
        }
    }
}
