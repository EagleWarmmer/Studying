package Mianshi;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StringBuff {

	public static void stringReplace(String testString){
		testString = testString.replace('j', 'i');
		testString = "123";
	}
	
	public static void bufferReplace(StringBuffer text) {
		text = text.append("C");
	}
	
	public static void main(String []args){
		String textString = new String("java");
		StringBuffer textBufferString = new StringBuffer("java");
		stringReplace(textString);
		bufferReplace(textBufferString);
		System.out.println(textString+textBufferString);
		
		List list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add(1,"3");
		List list2 = new LinkedList(list);
		list.addAll(list2);
		list2.clear();
		System.out.println(list);
		list2 = list.subList(2,5);
		list2.clear();
		System.out.println(list);
	}
}
