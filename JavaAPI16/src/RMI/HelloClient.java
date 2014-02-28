package RMI;



import java.rmi.Naming;


public class HelloClient {

	public static void main(String[] args) {
		try{
			HelloRMII hrHelloRMII =(HelloRMII) Naming.lookup("//192.168.10.208:1099/hRmii");//默认是本地1099端口
			System.out.println("client ready");
			hrHelloRMII.Hello();
		}catch(Exception e){
			System.out.println("Client failed");
			e.printStackTrace();
		}
	}

}
