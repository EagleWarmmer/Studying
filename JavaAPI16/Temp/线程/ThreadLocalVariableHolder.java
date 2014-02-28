package 线程;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Thread1 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ThreadLocalVariableHolder.isdnfasd();
		System.out.println(ThreadLocalVariableHolder.get());
	}
	
}
class Thread2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ThreadLocalVariableHolder.isdnfasd();
		System.out.println(ThreadLocalVariableHolder.get());
	}
	
}
public class ThreadLocalVariableHolder {

	static ThreadLocal<Integer> aLocal  = new ThreadLocal <Integer>(){
		private Random random= new Random(47);
		protected synchronized Integer initialValue(){
			return random.nextInt(10000);
		}
	};
	
	public static void isdnfasd(){
		aLocal.set(aLocal.get()+1);
	}
	
	public static int get(){
		return aLocal.get();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Thread aThread = new Thread(new Thread1());
//		aThread.start();
//		aThread = new Thread(new Thread2());
//		aThread.start();
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(new Thread1());
		executorService.execute(new Thread2());
		executorService.shutdown();
	}

}
