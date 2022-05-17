package RMI_Diep;
import java.rmi.*;
import java.rmi.server.*;
public class AddImplement extends UnicastRemoteObject implements Add {
	protected AddImplement() throws RemoteException {
		super();
}
public int addNum(int a, int b) {
		return(a+b);
	}
}
