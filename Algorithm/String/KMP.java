public class KMP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sub = "aabaccfaddddaabc";
		String str = "gdsaadfdgffccsdaabaccfdaddaabaccfaddddaabcga";
		int[] next = next(sub);
		pattern(str, sub, next);

		String a = "agctagcagctagctg";
		int[] next2 = next(sub);
		
		KMP aKmp =new KMP();
		int aa[] =aKmp.getnext("aaaab");
		
		float f1=123.125f,f2;
	    int i1,i2=150;
	    i1=(int) f1;
	    f1=i2;
	    f1=i2/100;
	    f2=(float) (i2/100.0);
	    f2=(float)i2/100;
	}

	public static void pattern(String str, String sub, int[] next) {
		char[] ch1 = str.toCharArray();
		char[] ch2 = sub.toCharArray();
		int i = 0, j = 0; // i控制ch1,j控制ch2;
		for (; i < ch1.length;) {
			if (ch1[i] == ch2[j]) {// 匹配就自动递增，往后匹配。
				if (j == ch2.length - 1) {
					System.out.println(i - ch2.length + 1);
					break;
				}
				j++;
				i++;
			} else if (j == 0) {
				i++;
			} else {
				j = next[j - 1] + 1;
			}
		}
	}

	// KMP中的核心算法，获得记录跳转状态的next数组
	public static int[] next(String sub) {
		int[] a = new int[sub.length()];
		char[] c = sub.toCharArray();
		int length = sub.length();
		int i, j;
		a[0] = -1;
		i = 0;
		for (j = 1; j < length; j++) {
			i = a[j - 1];
			while (i >= 0 && c[j] != c[i + 1]) {
				i = a[i];
			}
			if (c[j] == c[i + 1]) {
				a[j] = i + 1;
			} else {
				a[j] = -1;
			}
		}
		return a;
	}

	public int[] getnext(String s) {
		int[] next = new int[s.length()];
		int i = 1;
		next[1] = 0;
		int j = 0;
		while (i < s.length()-1) {
			if (j == 0 || s.charAt(i) == s.charAt(j)) {
				i++;
				j++;
				if (s.charAt(i) != s.charAt(j)) {
					next[i] = j;
				} else {
					next[i] = next[j];
				}
			} else {
				j = next[j];
			}
		}

		return next;
	}
}
