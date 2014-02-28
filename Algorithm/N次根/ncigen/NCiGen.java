package ncigen;

public class NCiGen {

	public String extract(String s, int n, int baoliu) {
		String result = "";
		String zhengshu[];
		String xiaoshu[];
		int index = s.indexOf(".");
		String[] temp = new String[2];
		temp = s.split(".");
		if (index == -1) {
			zhengshu = zhengShu(s, n);
			xiaoshu = xiaoShu("0", n, baoliu);
		} else {
			zhengshu = zhengShu(temp[0], n);
			xiaoshu = xiaoShu(temp[1], n, baoliu);
		}

		long a = 0, b = 0, c = 0;
		index = 0;
		while (index < zhengshu.length) {
			c = c * shiCiMi(10, n) + Long.parseLong(zhengshu[index]);
			b = 1;
			while (shiCiMi(10 * a + b, n) - shiCiMi(10 * a, n) <= c) {
				b++;
				if (b == 10) {
					break;
				}
			}
			b--;
			c = c - (shiCiMi(10 * a + b, n) - shiCiMi(10 * a, n));
			a = a * 10 + b;
			index++;
		}
		result += a + ".";
		index = 0;
		while (index < xiaoshu.length) {
			c = c * shiCiMi(10, n) + Long.parseLong(xiaoshu[index]);
			b = 1;
			while (shiCiMi(10 * a + b, n) - shiCiMi(10 * a, n) < c) {
				b++;
				if (b == 10) {
					break;
				}
			}
			b--;
			c = c - (shiCiMi(10 * a + b, n) - shiCiMi(10 * a, n));
			a = a * 10 + b;
			index++;
		}
		result += (a + 5) % shiCiMi(10, baoliu + 1);
		result = result.substring(0, result.length() - 1);
		return result;
	}

	public String[] zhengShu(String s, int n) {
		int count = s.length() / n;
		if (s.length() % n != 0) {
			count++;
		}

		String[] result = new String[count];

		for (int i = count - 1; i > 0; i--) {
			result[i] = s.substring(s.length() - n);
			s = s.substring(0, s.length() - n);
		}
		result[0] = s;
		return result;
	}

	public String[] xiaoShu(String s, int n, int baoliu) {
		int count = baoliu + 1;

		while (s.length() < count * n) {
			s += "0";
		}

		String[] result = new String[count];

		for (int i = 0; i < count; i++) {
			result[i] = s.substring(0, n);
			s = s.substring(n);
		}
		return result;
	}

	public long shiCiMi(long l, int n) {
		long result = 1;
		while (n > 0) {
			result *= l;
			n--;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NCiGen ncg = new NCiGen();
		System.out.println(ncg.extract("987654321987654321", 5, 4));
	}

}
