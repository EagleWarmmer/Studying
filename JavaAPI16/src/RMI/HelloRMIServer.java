package RMI;


import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;


public class HelloRMIServer {
	
	public static void main(String []args){
		try{
			LocateRegistry.createRegistry(1099);//开端口
			HelloRMII hRmii = new HelloRMI();
			
			Naming.rebind("//172.21.13.85:1099/hRmii", hRmii);//注册对象
			//Naming.rebind("hRmii", hRmii); 默认是本地ip的109端口
			System.out.println("ready~~~~~~~");
		}catch (Exception e) {
			System.out.println("failed........");
		}
	}
}
