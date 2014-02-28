package 值传递引用传递;

class A {
	int a1 = 9;

	A(){
	}
	
	A(int a) {
		this.a1 = a;
	}

}

public class Main {

	public static int[] ints = { 1, 2, 3, 4, 5 };
	public static String string = "12345";

	//改变不了对象引用的指向
	public static void changeA1(A a) {
		a = new A(6);
	}

	//引用传递
	public static void changeA2(A a) {
		a.a1 = 8;
	}

	//引用传递，但是效果是值传递 因为String是final的
	public static void changeS(String s) {
		s = "3333";
	}

	//引用传递，数组是对象
	public static void changeZ1(int[] a) {
		a[0]=9;
	}
	
	//改变不了对象引用的指向
	public static void changeZ2(int[] ints) {
		ints = new int[]{0,0,0,0};
	}

	public static void main(String[] args) {
		A a = new A();
		changeA1(a);
		System.out.println("changeA1:"+a.a1);
		changeA2(a);
		System.out.println("changeA2:"+a.a1);
		
		changeS(string);
		System.out.println("changeS:"+string);
		
		changeZ1(ints);
		System.out.println("changeZ1:"+ints[0]);
		changeZ2(ints);
		System.out.println("changeZ2:"+ints[0]);
	}
}
