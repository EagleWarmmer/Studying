package Mianshi;

abstract class Yuanlei{
	abstract void A();
//	final abstract void B();
}

class  FugaisFulei{
	public static void A(int a){
		System.out.println(a);
	}
	public final static void A(){
		
	}
}

public class FuGai extends FugaisFulei{
	
	public static void A(int a){
		System.out.println(a+"123");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FuGai.A(1);
		FugaisFulei.A(3);
		
	}
}
