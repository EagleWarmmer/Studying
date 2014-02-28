package 线程;

import java.io.PrintWriter;

public class MultiThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(new Thread1()).start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(new Thread2()).start();
	}

	private static class Thread1 implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized (MultiThread.class) {
				System.out.println("1 waiting");
				try {
					MultiThread.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("1 going");
			}
		}
	}

	private static class Thread2 implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized (MultiThread.class) {
				System.out.println("2 waiting");
				MultiThread.class.notify();

				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("2 going");
			}
		}
	}
}
