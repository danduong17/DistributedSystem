// Homework - Socket - How server & client communicate
// Reference: file Client.Java

package Socket;

import java.io.*;
import java.net.*;

public class SocketClient_while {
    public static void main(String[] args) throws IOException {

        // Creates a stream socket and connects it to the specified port number (in file SocketServer_while.java) at the specified IP address.
        // When put in out of block "try", remember to add "throws IOException"
        Socket socket = new Socket("localhost", 1286); 
		
        DataInputStream socketDIS = null;
		DataOutputStream socketDOS = null;
		BufferedReader buffRead = null;

		try
		{
			socketDIS = new DataInputStream(socket.getInputStream());

			// Returns the OutputStream attached with this socket.
	
			OutputStream outputStream = socket.getOutputStream();
			socketDOS = new DataOutputStream(outputStream);
			
			buffRead = new BufferedReader(new InputStreamReader(System.in));

			String fromServer = "", toClient = "";
			while (!fromServer.equals("stop") || fromServer.equals("Stop")) {
				fromServer = buffRead.readLine();
				socketDOS.writeUTF(fromServer);
				socketDOS.flush();
				toClient = socketDIS.readUTF();
				System.out.println("Server says: " + toClient.toLowerCase());
			}

		}
		catch (Exception exe) {
			exe.printStackTrace();
		}
		finally {
			try {

				if (buffRead != null) {
					buffRead.close();
				}

				if (socketDIS != null) {
					socketDIS.close();
				}

				if (socketDOS != null) {
					socketDOS.close();
				}
				if (socket != null) {
					// Closes this socket
					socket.close();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
