package defaults;

public class Test {
	String str;
	Test(String a){ String str = a;}
	Test(){}
	
	private static int x;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Test t = new Test();
		t.name(x);
		System.out.println(x);
		
		name2(x);
		System.out.println(x);
		
		
		byte [][]big = new byte[7][7];
		byte b [][] = new byte [2][1];
		byte b3 =5;
		byte b2 [][][][] = new byte [2][3][1][2];
		
		b2[0][1]=b;
		b[0][0]=b3;
		b2[0][1][0][0]=b[0][0];
		b2[0][1]=big;
		
		String str = new String ("good");
		String str1 = "good";
		String str2 = new String ("good");
		String str3 ="good";
		
		str1+="1";
		
		System.out.println(str==str1);
		System.out.println(str1==str2);
		System.out.println(str2==str);
		System.out.println(str3==str1);
		
		int x1=0;
		boolean a1,a2,a3,a4;
		a1=a2=a3=a4=true;
		x=(a1|a2&a3^a4)?x++:--x;
		x=x++;
		
		System.out.println(x1);
		System.out.println((23+2)/2);
		
	}
	
	public void name(int x){
		x++;
	}
	public static void name2(int x){
		x++;
	}
	
/* 这个打印出来是1*/
//	public static void name(int y){
//		x++;
//	}
}
