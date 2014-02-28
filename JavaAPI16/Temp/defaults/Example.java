package defaults;
public class Example {
	static int getOnly(int num){
		int number =0;
		String s =num+"";
		int len =s.length();
		if(len!=0){
			for(int i=0;i<len;i++){
				char a =s.charAt(i);
				if(a=='1'){
					number++;
				}
			}
		}return number;
	}
	public static void main(String[] args) {
		int j=0;
		for(int i =0;i<5;i++){
			j++;
		}
		System.out.println(j);
		
		System.out.println(false ? 1:2);
		
		int n=2;
		int res=1;
		while((getOnly(n)+res)!=n){
			res += getOnly(n);
			++n;
			
		}
		System.out.println(n);
	}
}
