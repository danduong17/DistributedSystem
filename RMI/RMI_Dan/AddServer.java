package RMI;

// Exercise 1 - 280322
// A Java RMI program which accept parameters values from the client and addition operation done by server and result returned to client.
// Server program

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.net.*;

public class AddServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(3033);
            Naming.rebind("rmi://localhost:3033/AddServer",
                    new AddRemoteImpl());
            System.out.println("Add Server is ready.");
        } 
        catch(RemoteException re) {
            re.printStackTrace();
        }
        catch(MalformedURLException mfurle) {
            mfurle.printStackTrace();
        }
    }
}
