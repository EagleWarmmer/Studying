package MergeSort;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSortClass m = new MergeSortClass();
		int [] a ={3,5,1,7,4};
		m.merge(a,0,4);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}

}
