package PalindromeNumber;

public class PalindromeNumber {
	public int reverse(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int result = 0;

		while (x > 0) {
			result = result * 10 + x % 10;
			x /= 10;
		}
		return result;
	}

	public boolean isPalindrome(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (x < 0) {
			return false;
		}
		return x == reverse(x);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
