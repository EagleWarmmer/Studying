package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class RmiObject  implements RmiInterface {

//	protected RmiObject() throws RemoteException {
//		super();
//	}

	@Override
	public void printf(String s) throws RemoteException{
		// TODO Auto-generated method stub
		System.out.println("Remoted printf arg: "+s);
	}

}

