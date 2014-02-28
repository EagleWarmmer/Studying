package FastSort;

import SelectionSort.SelectionSortClass;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] data = {"2","1","8","23","4","12"};
		Integer[] num ={2,1,8,23,4,12};
		
		FastSortClass.randomFastSortX(data,0,data.length-1);
		for(int i = 0; i < data.length; i++){
			System.out.print(data[i]+" ");
		}
		
		System.out.println();
		
		FastSortClass.randomFastSortX(num,0,data.length-1);
		for(int i = 0; i < num.length; i++){
			System.out.print(num[i]+" ");
		}
	}

}
