package 线程;

public class Xplus implements Runnable {

	int x = 1;
	int y = 2;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (this) {
			for (int i = 1; i < 10000; i ++) {
					x ++;
			}
		}
		
		System.out.println(x + " " + y + " ");
	}
	
	public static void main(String[] args) {
		Runnable run = new Xplus();
		Thread th1 = new Thread(run);
		Thread th2 = new Thread(run);
		th1.start();
		th2.start();
	}
}
