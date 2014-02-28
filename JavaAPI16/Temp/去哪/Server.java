package 去哪;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;

public class Server {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket ss = null;
		Socket s = null;
		try {
			ss = new ServerSocket(6000);
			s = ss.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					s.getInputStream()));
			OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream());
			

			while (true) {
				String string = in.readLine();
				if (string != null) {
					System.out.println("br: " + string);

					if (string.equals("end")) {
						out.write("to end"+"\r\n");
						out.flush();
						out.close();
						System.out.println("end");
						break;
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			s.close();
			ss.close();
		}
	}
}
