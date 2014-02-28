package 网易;

public class TestD {
	TestD(){
		System.out.print("a");
	}
	class B{
		B(){
			System.out.print("b");
		}
		public void go(){
			System.out.print("hi");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestD f = new TestD();
		f.makeB();
	}
	void makeB(){
		(new B(){}).go();
	}

}
