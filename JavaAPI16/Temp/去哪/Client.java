package 去哪;

import java.io.*;
import java.net.Socket;

import 线程.TreadSynOandM;


public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket =null;
		

		try {
			socket = new Socket("172.21.15.18", 6000);
			BufferedReader in =new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true); 

			String string = "";
			string = "end"+"\r\n";
			out.write(string);
			out.flush();
//			while(true){
//				String string2 = in.readLine();
//				if(string2.equals("to end")){
//					System.out.println("yes sir");
//					break;
//				}
//			}
			

		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				System.out.println("closed client");
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
