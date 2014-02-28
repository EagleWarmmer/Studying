package ncigen;

public class MainTest {

	/**
	 * 开n次方
	 * 
	 * @param root
	 *            被开方数
	 * @param n
	 *            开方，开n次方
	 * @param baoliu
	 *            小数部分保留的位数
	 * @return
	 */
	public static String extract(String root, int n, int baoliu) {
		String[] zhengShu = null;
		String[] xiaoShu = null;

		int pointIndex = root.indexOf('.');
		if (pointIndex == -1) {
			zhengShu = getZhengShu(root, n);
			xiaoShu = getXiaoshu("0", n, baoliu);
		} else {
			zhengShu = getZhengShu(root.substring(0, pointIndex), n);
			xiaoShu = getXiaoshu(root.substring(pointIndex + 1), n, baoliu);
		}
		String result = "";
		long a = 0;// 初值
		long c = 0;// 差
		long b = 0;// 尝试的商值
		int index = 0;
		while (index < zhengShu.length) {
			c = c * power(10, n) + Long.parseLong(zhengShu[index]);
			b = 1;
			while (power(10 * a + b, n) - power(10 * a, n) <= c) {
				System.out.println(power(10 * a + b, n));
				System.out.println(power(10 * a , n));
				b++;
				if (b == 10) {
					break;
				}
			}
			b = b - 1;
			c = c - (power(10 * a + b, n) - power(10 * a, n));
			a = a * 10 + b;
			index++;
		}
		result += a + ".";// 整数部分计算完毕
		index = 0;
		while (index < xiaoShu.length) {
			c = c * power(10, n) + Long.parseLong(xiaoShu[index]);
			b = 1;
			while (power(10 * a + b, n) - power(10 * a, n) <= c) {
				b++;
				if (b == 10) {
					break;
				}
			}
			b = b - 1;
			c = c - (power(10 * a + b, n) - power(10 * a, n));
			a = a * 10 + b;
			index++;
		}
		result += (a + 5) % power(10, baoliu + 1);// 这里 a + 5 是为了实现四舍五入
		result = result.substring(0, result.length() - 1);// 放弃最后1位
		return result;
	}

	/**
	 * 根据开方n的数值，将整数部分划分成若干片段
	 * 
	 * @param str
	 * @param n
	 * @return
	 */
	private static String[] getZhengShu(String str, int n) {
		int length = str.length() / n;
		if (str.length() % n != 0) {
			length += 1;
		}
		String[] zhengShu = new String[length];
		for (int i = zhengShu.length - 1; i > 0; i--) {
			zhengShu[i] = str.substring(str.length() - n);
			str = str.substring(0, str.length() - n);
		}
		zhengShu[0] = str;
		return zhengShu;
	}

	/**
	 * 根据开方n的数值和保留的位数，将小数部分划分成若干片段
	 * 
	 * @param str
	 * @param n
	 * @param decimalDigits
	 * @return
	 */
	private static String[] getXiaoshu(String str, int n, int decimalDigits) {
		int length = decimalDigits + 1;
		while (str.length() < length * n) {
			str += "0";
		}
		String[] xiaoShu = new String[length];
		for (int i = 0; i < xiaoShu.length; i++) {
			xiaoShu[i] = str.substring(0, n);
			str = str.substring(n);
		}
		return xiaoShu;
	}

	/**
	 * 得到一个数的n次方
	 * 
	 * @param shu
	 * @param n
	 * @return
	 */
	private static long power(long shu, int n) {
		long result = 1;
		while (n > 0) {
			result *= shu;
			n--;
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("将3开2次方，保留3位小数：" + extract("987654321987654321", 5, 4));
		System.out.println("将3开5次方，保留3位小数：" + extract("3", 5, 3));
		System.out.println("将3.08开2次方，保留3位小数：" + extract("3.08", 2, 3));
	}

}
