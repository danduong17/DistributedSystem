package Socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 1286);

        InputStream sin = s.getInputStream();

        DataInputStream socketDIS = new DataInputStream(sin);

        String testString = new String(socketDIS.readUTF());

        System.out.println(testString);

        sin.close();
        s.close();
    }
}
