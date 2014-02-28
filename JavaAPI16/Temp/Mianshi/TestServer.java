package Mianshi;
class Superserver{
	public Superserver(){
		this("1","2");
		System.out.println("all");
	}
	public Superserver(int y){
		this();
		System.out.println("good");
	}
	
	public Superserver(String s,String t){
		this(s+t);
	}
	
	public Superserver(String s){
		System.out.println(s);
	}
}
public class TestServer extends Superserver{
	public TestServer(){
		super(10);
		System.out.println("come");
	}
	public TestServer(int y) {
		System.out.println("things");
	}
	
	public TestServer(String s){
		System.out.println(s);
	}
	
	public TestServer(String s, String t){
		this(s+t+"3");
	}
	
	public static void main(String []args){
		TestServer server = new TestServer("text");
	}
}
