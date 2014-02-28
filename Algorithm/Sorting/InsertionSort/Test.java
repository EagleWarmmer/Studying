package InsertionSort;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] data = {"2","1","8","23","4","12"};
		Integer[] num ={2,1,8,23,4,12};
		
		InsertionSortClass.insertionSort(data);
		for(int i = 0; i < data.length; i++){
			System.out.print(data[i]+" ");
		}
		
		System.out.println();
		
		InsertionSortClass.insertionSort(num);
		for(int i = 0; i < num.length; i++){
			System.out.print(num[i]+" ");
		}
		
		//! int[] num ={2,1,8,23,4,12};
		//! InsertionSortClass.insertionSort(num.toString());  int没有实现Comparable接口
	}

}
