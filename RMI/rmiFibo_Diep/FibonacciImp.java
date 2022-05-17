package rmiFibo_Diep;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.server.*;
public class FibonacciImp extends UnicastRemoteObject implements Fibonacci {
	public FibonacciImp() throws RemoteException{}
	 public int printFibonacci(int count)
	 {
		{
		  if (count <= 1)
		            return count;
		  	return printFibonacci(count - 1)
		            + printFibonacci(count - 2);
		    }
}
	}


