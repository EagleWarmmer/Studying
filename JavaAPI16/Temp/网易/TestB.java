package 网易;

public class TestB {

	public static int test() {
		int i = 1;
		try {
			i = 2;
			int a[][] ={{},{}};
			Object c = a;
			int b[] = (int [])c;
			return i;
		}
		catch (Exception e) {
		}
		finally {
			i = 3;
			System.out.print(i + ",");
			return i;
		}
//		return i;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r = test();
		System.out.print(r);
	}

}
