package InsertionSort;

import java.util.StringTokenizer;

public class InsertionSortClass {
	public static <T extends Comparable<? super T>> void insertionSort(T[] data) {
		int i, j, n = data.length;
		T target;
		for (i = 1; i < n; i++) {
			j = i;
			target = data[i];
			while (j > 0 && target.compareTo(data[j - 1]) < 0) {
				data[j] = data[j - 1];
				j--;
			}
			data[j] = target;
		}
	}
	public static void main(String[]args){
		StringTokenizer st = new StringTokenizer("abc bcd def"," ");
		while (st.hasMoreElements()) {
			String s = st.nextToken();
			System.out.println(s);
		}
	}
}

