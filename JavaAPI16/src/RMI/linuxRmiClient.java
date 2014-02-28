package RMI;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;

public class linuxRmiClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			
//			System.getProperties().put("java.rmi.server.hostname", 70.70.70.20);
//			UnicastRemoteObject.exportObject(this, 1999);
			RmiInterface hrHelloRMII =(RmiInterface) Naming.lookup("//192.168.1.241:1099/rmi");//默认是本地1099端口
			
			System.out.println("client ready");
			hrHelloRMII.printf("wm");
		}catch(Exception e){
			System.out.println("Client failed");
			e.printStackTrace();
		}
	}

}
