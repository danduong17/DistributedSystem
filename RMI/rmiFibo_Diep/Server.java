package rmiFibo;
import java.rmi.*;
import java.rmi.registry.*;
import java.net.*;
public class Server {
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(2046);
			FibonacciImp localobj = new FibonacciImp();
			 Naming.rebind("rmi://localhost:2046/diep", localobj);
		}
		catch(RemoteException re) {
			re.printStackTrace();
		}
		catch(MalformedURLException mue) {
			mue.printStackTrace();
		}
		
	}
}
