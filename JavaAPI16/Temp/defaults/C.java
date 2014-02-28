package defaults;
class X{
	Y b =new Y();
	X(){
		System.out.println("x");
	}
}
class Y{
	Y(){
		System.out.println("Y");
	}
}
public class C extends X{
	Y y = new Y();
	
	C(){
		System.out.println("c");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new C();
	}

}
