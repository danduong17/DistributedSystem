// Exercise 1 - 280322
// A Java RMI program which accept parameters values from the client and addition operation done by server and result returned to client.
// Client program

import java.rmi.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String args[]) {
        String host = "localhost";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1st parameter: ");
        int x = sc.nextInt();

        System.out.println("Enter 2nd parameter: ");
        int y = sc.nextInt();

        try {
            AddRemote remoteObj = (AddRemote)Naming.lookup("rmi://localhost:3033/dan");
            System.out.println(remoteObj.addNum(x,y));
        }
        catch(RemoteException re) {
            re.printStackTrace();
        }
        catch(NotBoundException nbe) {
            nbe.printStackTrace();
        }
        catch(MalformedURLException mfurle) {
            mfurle.printStackTrace();
        }

        sc.close();
    }
}
