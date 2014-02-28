package 网易;

public class TestE {
	static Thread one,two;

	public static void main(String[] args) {
		one = new Thread(){
			public void run(){
				System.out.println("A");
				try {
					two.sleep(10000);
				} catch (Exception e) {
					System.out.println("B");
				}
				System.out.println("C");
			}
		};
	
//		two = new Thread(){
//			Exception exception ;
//			public void run(){
//				System.out.println("D");
//				try {
//					one.wait();
//				} catch (Exception e) {
//					System.out.println("E");
//					exception =e;
//				}
//				System.out.println("F");
//				exception.printStackTrace();
//			}
//		};
		
		one.start();
//		two.start();
	}
}
