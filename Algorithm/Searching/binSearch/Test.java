package binSearch;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] num ={1,2,4,8,12,23};
		int count =binSearchClass.binSearch(num, 0, num.length, 23);
		System.out.println(count);
	}

}
