package rmiFibo;
import java.util.*;
import java.io.*;
import java.rmi.*;
import java.net.*;
public class Client {
	public static void main(String[] args) {
		int count = 10;
		String host = "localhost";
		Scanner s = new Scanner(System.in);
		try {
			Fibonacci obj=(Fibonacci)Naming.lookup("rmi://localhost:2046/diep");
			 
			System.out.println(obj.printFibonacci(count));
		}
		catch(RemoteException re){
			re.printStackTrace();
}
		catch(NotBoundException nbe) {
			nbe.printStackTrace();
		}
		catch(MalformedURLException mue) {
			mue.printStackTrace();
		}
	}
}
