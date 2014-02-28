package SelectionSort;

public class SelectionSortClass {
	public static <T extends Comparable<? super T>> void selectionSort(T[] data) {
		int small;
		int i, j, size = data.length;

		for (i = 0; i < size - 1; i++) {
			small=i;
			for (j = i + 1; j < size; j++) {
				if(data[j].compareTo(data[small])<0){
					small = j;
				}
			}
			if(small!=i){
				T temp = data[i];
				data[i]=data[small];
				data[small] =temp;
			}
		}
	}
}
