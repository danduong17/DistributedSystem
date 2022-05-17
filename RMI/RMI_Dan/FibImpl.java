package RMI;

// Exercise 1 - 280322
// A Java RMI program which accept parameters values from the client and find Fibonacci numbers done by server and result returned to client.
// Implementation of interface

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.server.*;

public class FibImpl extends UnicastRemoteObject implements Fibonacci {
    public FibImpl() throws RemoteException{}
	public int printFib(int count) {
		if (count <= 1)
		    return count;
		  	return printFib(count - 1) + printFib(count - 2);
    }
    
}
