package 线程;

class Threadfirst implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		StaticSynchron.name();
	}
	
}

class ThreadSecond implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		StaticSynchron.name();
	}
	
}

public class StaticSynchron {

	public static synchronized void name() {
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000000; j++) {
				
			}
			System.out.println(i);
			Thread.yield();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new Threadfirst()); 
		Thread t2 = new Thread(new Threadfirst());
		t1.start();
		t2.start();
	}

}
