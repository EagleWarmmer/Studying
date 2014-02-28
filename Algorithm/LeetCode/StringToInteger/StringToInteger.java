package StringToInteger;

public class StringToInteger {
	public int atoi(String str) {
		// Start typing your Java solution below
		// DO NOT write main() function
		str = str.trim();
		char[] array = str.toCharArray();
		String s = new String();
		int count = 0;
		boolean re = false;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > '9' || array[i] < '0') {
				// 字符中间出现非数字，后面舍掉
				if (count > 0) {
					break;
				}
				// 连续两个非数字，后面舍掉
				if (i > 0 && (array[i - 1] > '9' || array[i - 1] < '0')) {
					break;
				}

			} else {
				count++;
				//判断首个数字前一位：负号、正号、其他。
				if (count == 1 && i > 0) {
					if (array[i - 1] > '9' || array[i - 1] < '0') {
						if (array[i - 1] == '-') {
							re = true;
						} else if (array[i - 1] == '+') {
							re = false;
						} else {
							break;
						}
					}
				}
				s += array[i];
			}
		}
		if (s.equals("")) {
			return 0;
		}
		if (re) {
			try {
				return Integer.parseInt(s.toString(), 10) * (-1);
			} catch (NumberFormatException e) {
				return -2147483648;
			}
		}

		try {
			return Integer.parseInt(s.toString(), 10);
		} catch (NumberFormatException e) {
			return 2147483647;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringToInteger ati = new StringToInteger();
		System.out.println(ati.atoi("+1"));
		System.out.println(ati.atoi2("+1"));
	}

	public int atoi2(String str) {
		int i = 0;
		int sign = 1;
		boolean innum = false;
		int max = 2147483647;
		int premax = 214748364;
		int min = -2147483648;
		char[] array = str.toCharArray();
		for (int j = 0; j < array.length; j++) {
			char c = array[j];
			if (c >= '0' && c <= '9') {
				innum = true;
				int digit = c - '0';
				boolean overflow = false;
				if (i - premax >= 1) {
					overflow = true;
				} else if (i == premax) {
					overflow = digit > 7;
				}
				if (overflow)
					return (sign == 1 ? max : min);
				i = 10 * i + (c - '0');
			} else {
				if (innum)
					break;
				if (c == '-') {
					sign = -1;
					innum = true;
				} else if (c == '+') {
					innum = true;
				} else if (c != ' ') {
					break;
				}
			}
		}
		return sign * i;
	}
}
