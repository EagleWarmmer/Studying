package URLConnection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Test {
	public static String ip;
	public static String port;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("ip.txt"));
		ip = in.readLine();
		port = in.readLine();

		while (true) {
			try {
				Socket socket = new Socket(ip, Integer.valueOf(port));
				String msg = "1234567\r\n";
				msg = msg.getBytes().length + msg;
				OutputStream os = socket.getOutputStream();
				os.write(msg.getBytes());
				os.flush();
				InputStream is = socket.getInputStream();
				byte[] echoMsg = new byte[2048];
				int len = is.read(echoMsg);

				String result = new String(echoMsg, 0, len);

				os.close();
				is.close();

				// is.close();
				// os.close();
				/* s.close(); */
				Thread.sleep(10000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}