package 线程;

class ThreadTest {
	public synchronized void a(){
		for(int i =0;i<100;i++){
			for (int j = 0; j < 10; j++) {
				
			}
			System.out.println("a"+i);
		}
	}
	public synchronized void b(){
		for(int i =0;i<100;i++){
			System.out.println("b"+i);
		}
		
	}
	public void c(){
		synchronized (this) {
			for(int i =0;i<100;i++){
				System.out.println("c"+i);
			}
		}
	}
	public void d(){
		synchronized (this) {
			for(int i =0;i<100;i++){
				System.out.println("d"+i);
			}
		}
	}
	public void e(){
		for(int i =0;i<1000;i++){
			for(int j=0;j<1000000;j++){
				
			}
			System.out.println("e"+i);
		}
	}
	public void f(){
		for(int i =0;i<100;i++){
			System.out.println("f"+i);
		}
	}
}

class ThreadA extends Thread{
	ThreadTest t;
	public ThreadA(ThreadTest t) {
		this.t=t;
	}
	@Override
	public void run() {
		t.a();
	}
}

class ThreadB extends Thread{
	ThreadTest t;
	public ThreadB(ThreadTest t) {
		this.t=t;
	}
	@Override
	public void run() {
		t.b();
	}
}

class ThreadC extends Thread{
	ThreadTest t;
	public ThreadC(ThreadTest t) {
		this.t=t;
	}
	@Override
	public void run() {
		t.c();
	}
}

class ThreadD extends Thread{
	ThreadTest t;
	public ThreadD(ThreadTest t) {
		this.t=t;
	}
	@Override
	public void run() {
		t.d();
	}
}

class ThreadE extends Thread{
	ThreadTest t;
	public ThreadE(ThreadTest t) {
		this.t=t;
	}
	@Override
	public void run() {
		t.e();
	}
}

class ThreadF extends Thread{
	ThreadTest t;
	public ThreadF(ThreadTest t) {
		this.t=t;
	}
	@Override
	public void run() {
		t.f();
	}
}

class ThreadZ1 extends Thread{
	ThreadTest t;
	public ThreadZ1(ThreadTest t) {
		this.t=t;
	}
	@Override
	public void run() {
		synchronized(t){
			t.e();
		}
	}
}
class ThreadZ2 extends Thread{
	ThreadTest t;
	public ThreadZ2(ThreadTest t) {
		this.t=t;
	}
	@Override
	public void run() {
		synchronized(t){
			t.f();
		}
	}
}


public class TreadSynOandM {

	public static void main(String []args){
	/**	
	 * 测试一个对象的两个synchronized方法之间的影响
	 * 结论：一个对象一次只能执行一个synchronized 但是不影响非synchronized
	 * 
		ThreadTest tt= new ThreadTest();
		Thread aTest = new Thread(new ThreadA(tt));
		aTest.start();
		Thread bTest = new Thread(new ThreadB(tt));
		bTest.start();
		
		Thread fTest = new Thread(new ThreadF(tt));
		fTest.start();
		
		*/
		/**
		 * 测试 一个对象的synchronized方法 和块 的区别
		 * 结论：无区别
		 */
		ThreadTest tt= new ThreadTest();
		
		Thread aTest = new Thread(new ThreadA(tt));
		aTest.start();
		Thread cTest = new Thread(new ThreadC(tt));
		cTest.start();
		Thread dTest = new Thread(new ThreadD(tt));
		dTest.start();
		
		Thread fTest = new Thread(new ThreadF(tt));
		fTest.start();
		
		
		/**
		 *测试synchronized一个对象 的方法
		 *结论： synchronized一个对象后，它的所有方法都得一个个执行
		 
		ThreadTest tt= new ThreadTest();
		
		Thread z1Test = new Thread(new ThreadZ1(tt));
		z1Test.start();
		Thread z2Test = new Thread(new ThreadZ2(tt));
		z2Test.start();
		*/
	}
}
