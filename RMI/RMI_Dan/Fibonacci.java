package RMI;

// Exercise 2 - 280322
// A Java RMI program which accept parameters values from the client and find Fibonacci numbers done by server and result returned to client.
// Define Remote Interface

import java.rmi.*;

public interface Fibonacci extends Remote {
    int printFib(int count) throws RemoteException;
}
