package BubbleSort;

import java.util.Iterator;
import java.util.LinkedList;

public class BubbleSortClass {
	public static void bubbleSort(int[] a) {
		int temp;
		for (int i = 0; i < a.length; i++) {
			for (int j = a.length - 1; j > i; j--) {
				if(a[j]<a[j-1]){
					temp=a[j];
					a[j]=a[j-1];
					a[j-1]=temp;
				}
			}
		}
	}
	
	public static void main(String[]args){
		LinkedList<String> ls = new LinkedList<String>();
		ls.add("123");
		ls.add("234");
		ls.add("345");
		
		Iterator<String> iterator = ls.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			
		}
	}
}
