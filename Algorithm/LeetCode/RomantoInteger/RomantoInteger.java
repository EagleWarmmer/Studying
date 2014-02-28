package RomantoInteger;

public class RomantoInteger {
	public int romanToInt(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		char[] temp = s.toCharArray();
		int result = 0;
		for (int i = 0; i < temp.length; i++) {
			if (i + 1 <= temp.length-1) {
				if (all(temp[i]) >= all(temp[i + 1])) {
					result += all(temp[i]);
				} else {
					result +=(all(temp[i+1])-all(temp[i]));
					i++;
				}
			}else {
				result+=all(temp[i]);
			}
				
		}
		return result;
	}

	public int all(char a) {
		switch (a) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RomantoInteger r = new RomantoInteger();
		System.out.println(r.romanToInt("MCMLXXVI"));
	}
}
