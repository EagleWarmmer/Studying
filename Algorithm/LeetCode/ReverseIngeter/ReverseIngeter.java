package ReverseIngeter;

public class ReverseIngeter {
	public int reverse(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int result=0, temp;
		temp = (x < 0) ? -1 * x : x;
		
		while(temp>0){
			result=result*10+temp%10;
			temp/=10;
		}
		
		result=(x<0)?-1*result:result;
		
		return result;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseIngeter s = new ReverseIngeter();
		System.out.println(s.reverse(0));
		System.out.println(Integer.parseInt("1", 10));
	}

}
