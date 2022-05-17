package RMI;
import java.util.*;
import java.io.*;
import java.rmi.*;
import java.net.*;

// Exercise 2 - 280322
// A Java RMI program which accept parameters values from the client and find Fib numbers done by server and result returned to client.
// Client program

public class FibClient {
    public static void main(String[] args) {
		int count = 5;
		String host = "localhost";
		Scanner sc = new Scanner(System.in);
		try {
			Fibonacci obj=(Fibonacci)Naming.lookup("rmi://localhost:2001/FibServer");
			 
			System.out.println(obj.printFib(count));
		}
        catch(RemoteException re) {
            re.printStackTrace();
        }
        catch(NotBoundException nbe) {
            nbe.printStackTrace();
        }
        catch(MalformedURLException mfurle) {
            mfurle.printStackTrace();
        }

        sc.close();
    }
}
