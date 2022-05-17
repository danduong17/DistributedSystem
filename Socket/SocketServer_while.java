// Homework - Socket - How server & client communicate
// Reference: file Server.Java

package Socket;

import java.io.*;
import java.net.*;

public class SocketServer_while {
    public static void main(String[] args) throws IOException {
		// Creates a server socket, bound to the specified port.
        ServerSocket ss = new ServerSocket(1286);
        System.out.println("Server is waiting for client request... ");

        DataInputStream socketDIS = null;
        DataOutputStream socketDOS = null;
		BufferedReader buffRead = null;

		try
		{
			/*
			 * Listens for a connection to be made to this socket and
			 * accepts it. The method blocks until a connection is
			 * made.
			 */
			Socket socket = ss.accept();

            /* 
             * Khi có lệnh accept, máy tính sẽ block hết các dòng code sau đó
             * Chờ đến khi có client gửi request thì mới run tiếp các đoạn code đằng sau lệnh accept đó
             * Vì Java hoạt động chủ yếu dựa trên synchronous
             */
            
			socketDIS = new DataInputStream(socket.getInputStream());
			
			OutputStream socketOutStream = socket.getOutputStream();
			socketDOS = new DataOutputStream(socketOutStream);
			
			// Optimize the process -> faster
			buffRead = new BufferedReader(new InputStreamReader(System.in));

			String ClientInput = "", ServerOutput = "";
			while (!ClientInput.equals("stop") || ClientInput.equals("Stop")) {
				ClientInput = socketDIS.readUTF();
				System.out.println("Client says: " + ClientInput.toUpperCase());
				ServerOutput = buffRead.readLine();
				socketDOS.writeUTF(ServerOutput);
				socketDOS.flush();
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

				if (ss != null) {
					// Closes the server socket
					ss.close();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
