package pinyin;

public class Coding {
	public static String codingByPinYin(String cnStr) {
		String cn = ConvertPinYin.getFullSpellFirst(cnStr);
		StringBuffer result = new StringBuffer();
		int n = 0;
		char[] cnchars = new char[3];
		for (int i = 0; i < 3; i++) {
			cnchars[i] = cn.charAt(i);
			n = cnchars[i] - 96;
			if (n < 0) {
				result.append("00");
			} else if (n < 10) {
				result.append("0" + n);
			} else {
				result.append("" + n);
			}
		}
		return result.toString();
	}
}
