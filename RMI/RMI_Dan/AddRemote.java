package RMI;
// Exercise 1 - 280322
// A Java RMI program which accept parameters values from the client and addition operation done by server and result returned to client.
// Define Remote Interface

import java.rmi.*;

public interface AddRemote extends Remote {
    public int addNum(int x, int y) throws RemoteException;
}
