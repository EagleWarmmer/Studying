package URLConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionTest {

	public void test(String ip, String port) {
		String urlStr = "http://" + ip + ":" + port;
		try {
			URL url = new URL(urlStr);
			URLConnection urlconn = url.openConnection();
			System.out.println("_________" + urlconn);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					urlconn.getInputStream()));
			String s = null;
			while ((s = in.readLine()) != null) {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
