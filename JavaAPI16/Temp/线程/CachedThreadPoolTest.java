package 线程;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CachedThreadPoolTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * try {
		 * 
		 * // 建新线程的线程池，如果之前构造的线程可用则重用它们 ExecutorService executorService =
		 * Executors.newCachedThreadPool(); for (int i = 1; i <= 4; i++) {
		 * executorService.execute(new Task(i)); } executorService.shutdown();
		 * 
		 * } catch (Exception e) { }
		 */

		BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6, 1,
				TimeUnit.DAYS, queue);

		for (int i = 1; i < 5; i++) {
			/*
			 * executor.execute(new Runnable() {
			 * 
			 * public void run() { try { Thread.sleep(1000); } catch
			 * (InterruptedException e) { e.printStackTrace(); }
			 * System.out.println(String.format("thread %d finished",
			 * this.hashCode())); } });
			 */
			executor.execute(new Task(i));
		}
		executor.shutdown();
		
		int a = 128;
		Integer b = 128;
		System.out.println(a==b);
	}
}
