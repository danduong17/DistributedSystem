package RMI;

// Exercise 2 - 280322
// A Java RMI program which accept parameters values from the client and find Fib numbers done by server and result returned to client.
// Server program

import java.rmi.*;
import java.rmi.registry.*;
import java.net.*;

public class FibServer {
    public static void main(String args[]) {
        try {
            FibImpl localObj = new FibImpl();
            LocateRegistry.createRegistry(2001);
            Naming.rebind("rmi://localhost:2001/Server", localObj);
        }
        catch(RemoteException re) {
            re.printStackTrace();
        }
        catch(MalformedURLException mfurle) {
            mfurle.printStackTrace();
        }
    }
}
