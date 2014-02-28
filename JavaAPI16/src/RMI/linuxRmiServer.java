package RMI;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.RMISocketFactory;
import java.rmi.server.UnicastRemoteObject;


public class linuxRmiServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			RmiInterface rmi = new RmiObject();
			
			//for static socket port actually it's useless
			RMISocketFactory.setSocketFactory(new RmiSocket());
			
			//socket port is 35400
			RmiInterface stub = (RmiInterface) UnicastRemoteObject.exportObject(rmi, 35400);
			
			LocateRegistry.createRegistry(1099);
			Naming.rebind("//192.168.1.241:1099/rmi", stub);
			
			System.out.println("server ready");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

