package RMI_Diep;

import java.rmi.*;
public interface Add extends Remote {
	 public int  addNum(int a, int b) throws RemoteException;
	 }

