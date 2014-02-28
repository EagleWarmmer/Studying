package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiInterface extends Remote {
	public void printf(String s)throws RemoteException;
}
