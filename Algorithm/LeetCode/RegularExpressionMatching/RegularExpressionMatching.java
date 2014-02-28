package RegularExpressionMatching;

public class RegularExpressionMatching {

	public boolean isMatch(String s, String p) {
		// Start typing your Java solution below
		// DO NOT write main() function
		char[] sc = s.toCharArray();
		char[] pc = p.toCharArray();

		if (sc == null || pc == null ) {
			return false;
		}
		if (p.equals("")) {
			return s.equals("");
		}
		if( pc[0] == '*'){
			return false;
		}
		if (pc.length==1||pc[1] != '*') {
			if (s.equals("")) {
				return false;
			}
			if (pc[0] != '.' && sc[0] != pc[0]) {
				return false;
			}
			return isMatch(s.substring(1), p.substring(1));
		} else {
			int len = s.length();
			if(isMatch(s, p.substring(2))){
				return true;
			}
			for (int m =0;m<len;m++){
				if(pc[0]!='.'&&pc[0]!=sc[m]){
					return false;
				}
				if(isMatch(s.substring(m+1), p.substring(2))){
					return true;
				}
			}
			return false;
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegularExpressionMatching r = new RegularExpressionMatching();
		System.out.println(r.isMatch("ab", ".*c"));
	}

}
