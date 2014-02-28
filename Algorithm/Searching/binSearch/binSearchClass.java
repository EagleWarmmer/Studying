package binSearch;

public class binSearchClass {
	public static <T extends Comparable<? super T>> int binSearch(T[] data, int first, int last, T target) {
		int mid;
		T midvalue;
		while (first < last) {
			mid = (first + last) / 2;
			midvalue = data[mid];
			if(target==midvalue){
				return mid;
			}else if (target.compareTo(midvalue)<0) {
				last=mid;
			}else{
				first=mid;
			}
		}
		return -1;
	}
}
