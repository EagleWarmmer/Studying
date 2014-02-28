package HeapSort;

public class HeapSort {
	public static void createHeap(int[] a) {

		int j, temp;
		int n = a.length;

		for (int i = n / 2 - 1; i >= 0; i--) {
			while (i * 2 + 1 < n) {

				j = i * 2 + 1;

				if (j + 1 < n) {
					if (a[j] < a[j + 1])
						j++;
				}

				if (a[i] < a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					i = j;
				} else {
					break;
				}
			}
		}
	}

	public static void heapSort(int[] a) {

		int n = a.length, temp, j;

		for (int i = n - 1; i > 0; i--) {
			
			temp = a[0];
			a[0] = a[i];
			a[i] = temp;

			int k = 0;
			while (2 * k + 1 < i) {
				j = 2 * k + 1;
				if (j + 1 < i) {
					if (a[j] < a[j + 1]) {
						j++;
					}
				}
				if (a[k] < a[j]) {
					
					temp = a[k];
					a[k] = a[j];
					a[j] = temp;
					k = j;
				} else {
					break;
				}
			}
		}
	}
}
