package rmiFibo;
import java.rmi.*;
public interface Fibonacci extends Remote {
	 int printFibonacci(int count) throws RemoteException;
 }
