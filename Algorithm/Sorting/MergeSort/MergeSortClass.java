package MergeSort;

public class MergeSortClass {
	public void merge(int[] a, int begin, int end) {
		if (end>begin) {
			int m = (end +begin ) / 2;

			merge(a, 0, m);
			merge(a, m + 1, end);

			MergeSort(a, begin, m, end);
		}
	}

	private void MergeSort(int[] a, int begin, int pos, int end) {
		int len = end - begin + 1;
		int b[] = new int[len];
		int i = begin, j = pos + 1;
		for (int k = 0; k < len; k++) {
			if (j > end) {
				b[k] = a[i];
				i++;
			} else if (i > pos) {
				b[k] = a[j];
				j++;
			} else if (a[i] < a[j]) {
				b[k] = a[i];
				i++;
			} else {
				b[k] = a[j];
				j++;
			}
		}
		for(int k=0;k<len;k++){
			a[k+begin]=b[k];
		}
	}
}
