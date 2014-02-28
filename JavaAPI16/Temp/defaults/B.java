package defaults;

public class B extends Test {
	String a,b;
	
	B(String s){
		a=s;
	}
	
	B(String t,String p){
		this(t);
		b=p;
	}
	
	public static void main(String []args){
		Test t = new Test("123");
		System.out.println(t.str);
	}
}
