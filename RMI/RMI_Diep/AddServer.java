package RMI_Diep;
import java.rmi.*;
import java.rmi.registry.*;
import java.net.*;
public class AddServer {
	public static void main(String[] args) {
		try {
			//LocateRegistry.createRegistry(3039);
			AddImplement localobj = new AddImplement();
			 Naming.rebind("rmi://localhost:3039/diep", localobj);
		}
		catch(RemoteException re) {
			re.printStackTrace();
		}
		catch(MalformedURLException mue) {
			mue.printStackTrace();
		}
		
	}
}