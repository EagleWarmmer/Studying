package 网易;


class Tags{
	Tags(String s){
		System.out.println("tags("+s+")");
	}
}
class A{
	Tags aTags = new Tags("1");
	int i =9;
	int j;
	A(){
		System.out.println("i="+i);
		System.out.println("j="+j);
	}

	Tags bTags = new Tags("2");
	
	static int p = prt("A.p initilized");
	static int prt (String s){
		System.out.println(s);
		return 29;
	}
}
public class InitClass extends A {

	Tags cTags = new Tags("3");
	int k ;
	public InitClass() {
		j=prt("A.j initilized");
		System.out.println("j="+j);
	}
	static int q = prt("InitClass.p initilized");
	static int prt (String s){
		System.out.println(s);
		return 36;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		prt("Begin");
//		InitClass ic = new InitClass();
	}

}
