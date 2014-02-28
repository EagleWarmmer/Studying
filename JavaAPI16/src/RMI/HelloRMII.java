package RMI;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloRMII extends Remote {
	public void Hello() throws RemoteException;
}
