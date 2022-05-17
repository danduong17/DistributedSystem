package RMI_Diep;
import java.util.*;
import java.io.*;
import java.rmi.*;
import java.net.*;
public class AddClient {
	public static void main(String[] args) {
		
		String host = "localhost";
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the first number: ");
		int a = s.nextInt();
		System.out.println("Enter the second number: ");
		int b = s.nextInt();
		try {
			Add obj=(Add)Naming.lookup("rmi://localhost:3039/diep");
			 
			System.out.println(obj.addNum(a,b));
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
