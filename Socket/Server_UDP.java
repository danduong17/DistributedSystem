package Socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server_UDP {
    public static void main(String[] args) throws IOException {
        // Step 1: Declare a datagram socket
        DatagramSocket dgSocket = null;
        if (args.length <= 0) {
            System.out.println("Pass the port number to the UDP server");
            System.exit(1);
        }

        try {

            int socketNumber =Integer.valueOf(args[0]).intValue();
            dgSocket = new DatagramSocket(socketNumber);

            // Create a byte buffer to store data got from server
            byte[] byteBuffer = new byte[1000];

            while (true) {
                // Get request from client, and save it into a dgRequest
                DatagramPacket dgRequest = new DatagramPacket(byteBuffer, byteBuffer.length);
                dgSocket.receive(dgRequest);

                String receiveMsg = (String).dgRequest.getData();
                receiveMsg.toUpperCase();
                byte[] responseBytes = receiveMsg.getBytes();

                // Do sth in response to the client request, then sent 
                DatagramPacket dgResponse = new DatagramPacket(dgRequest.getData(), dgRequest.getLength(), dgRequest.getAddress(). dgRequest.getPort());
                dgSocket.send(dgResponse);
            }
        }

        catch (SocketException e) {
            System.out.println("SocketException: " + e.getMessage());
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