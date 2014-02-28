package BubbleSort;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num={4,2,3,5,1,2};
		BubbleSortClass bubble=new BubbleSortClass();
		bubble.bubbleSort(num);
		for(int i=0;i<num.length;i++){
			System.out.println(num[i]);
		}
	}

}
