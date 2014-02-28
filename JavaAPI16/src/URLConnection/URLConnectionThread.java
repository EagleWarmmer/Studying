package URLConnection;

public class URLConnectionThread extends Thread {
	int timer = 10;// 单位秒钟

	public void run() {
		while (true) {
			try {
				sleep(timer * 1000);
				URLConnectionTest u = new URLConnectionTest();

				u.test(Test.ip, Test.port);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
