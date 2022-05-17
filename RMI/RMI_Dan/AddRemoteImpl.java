package RMI;
// Exercise 1 - 280322
// A Java RMI program which accept parameters values from the client and addition operation done by server and result returned to client.
// Implementation of interface

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class AddRemoteImpl extends UnicastRemoteObject implements AddRemote {
    public AddRemoteImpl() throws RemoteException{}
    public int addNum(int x, int y) {
        return(x+y);
    }
}
