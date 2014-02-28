package LongestPalindromicSubstring;

public class Simple_n2 {
	
	public String longestPalindrome(String s) {
		String result="",tempString="";
        // Start typing your Java solution below
        // DO NOT write main() function
		for(int i=0;i<s.length();i++){
			tempString=loop(s, i, i);
			if(tempString.length()>result.length()){
				result=tempString;
			}
			
			tempString=loop(s, i, i+1);
			if(tempString.length()>result.length()){
				result=tempString;
			}
		}
		
		return result;
    }
	public String loop(String s,int l,int r){
		char[] array =s.toCharArray();
		while(l>=0&&r<=s.length()-1){
			if(array[l]==array[r]){
				l--;
				r++;
			}else {
				break;
			}
		}
		
		return s.substring(l+1, r);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Simple_n2 aN2 =new Simple_n2();
		System.out.println(aN2.longestPalindrome("abb"));
		System.out.println(aN2.longestPalindrome("lucdpkahsyjyfgvrirgjpqirhtdfbjlqkhqjdccebrveapzkccvotc"));
		
		System.out.println(""+new Integer(-20319));
	}

}
