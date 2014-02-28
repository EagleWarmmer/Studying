package RMI;



import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloRMI extends UnicastRemoteObject implements HelloRMII {

	protected HelloRMI() throws RemoteException {
		super();
	}

	public void Hello()  throws RemoteException {
		System.out.println("HELLORMI implenments");
	}

}
