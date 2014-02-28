package 网易;

import java.util.HashMap;
import java.util.Map;

public class TestC {
	static class C {
		String day;
		int hash;

		C(String d, int h) {
			day = d;
			hash = h;
		}

		public int hashcode() {
			return hash;
		}

		public boolean equals(Object o) {
			return ((C) o).day == this.day;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<C,String>m = new HashMap<C, String>();
		C t1 = new C("Monday", 1);
		C t2 = new C("Monday", 2);
		C t3 = new C("Tuesday", 3);
		C t4 = new C(new String("Tuesday"), 3);
		C t5 = new C(new String("Tuesday").intern(), 4);
		m.put(t1, "1");
		m.put(t2, "2");
		m.put(t3, "3");
		m.put(t4, "4");
		m.put(t5, "5");
		System.out.println(m.size());
	}

}
