package Socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1286);

        Socket s = ss.accept();

        // Khi có lệnh accept, máy tính sẽ block hết các dòng code sau đó
        // Chờ đến khi có client gửi request thì mới run tiếp các đoạn code đằng sau lệnh accept đó
        // Vì Java hoạt động chủ yếu dựa trên synchronous
        OutputStream socketOutStream = s.getOutputStream();
        DataOutputStream socketDOS = new DataOutputStream(socketOutStream);
        
        socketDOS.writeUTF("Hello, World!");

        socketDOS.close();
        socketOutStream.close();
        s.close();
        ss.close();
    }
}
