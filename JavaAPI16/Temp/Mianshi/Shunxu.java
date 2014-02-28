package Mianshi;

class Print{
	static String print(String s){
		System.out.println(s);
		return s;
	} 
}

class fu{
	fu(){
		String string1 = Print.print("f1");
	}
	String string2 = Print.print("f2");
	
	static {
		String string4 =Print.print("f4");
		System.out.println("f static block");
	}
	static String string3 = Print.print("f3");
	{
		String string5 =Print.print("f5");
	}
}

public class Shunxu extends fu {

	public Shunxu() {
		String string5=Print.print("z5");
	}
	
	
	static String string1 = Print.print("z1");
	
	String string2 = Print.print("z2");
	
	{
		String string3 =Print.print("z3");
	}
	

	static{
		String string4 =Print.print("z4");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shunxu s=new Shunxu();
	}

}
