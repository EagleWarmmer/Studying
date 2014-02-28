package com;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.logging.SimpleFormatter;


public class TestDouble {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Double  d1=9847328.23;
		Double  d2=847328.23;
		Double d = d2-d1;
		if(d<0){
			System.out.println("sdfasdf");
		}
		
		String bb = "0E422E00";
		bb="1079F680";
		System.out.println(getTXFloat(bb));
	}
	
	private static float getTXFloat (String hexStr) {
		float f = 0;
		String s1, s2;
		double d1, d2;
		
		if (hexStr==null)
			return 0;
		
		s1 = hexStr.substring(0,2);
		s2 = hexStr.substring(2,hexStr.length());
		int i1 = Integer.valueOf(s1,16).intValue();
		int i2 = Integer.valueOf(s2,16).intValue();
		
		d2 =(double) i2/8388608;
		d1 = (double) Math.pow(2, i1);
		
		BigDecimal bcs = new BigDecimal(i2+"");
		BigDecimal b1 = bcs.divide(new BigDecimal("8388608"));
		
//		BigDecimal b1 = new BigDecimal(Double.toString(d2));
		BigDecimal b2 = new BigDecimal(Double.toString(d1));
		BigDecimal cBigDecimal =  b1.multiply(b2);
		float result = b1.multiply(b2).floatValue();
		
		return result;
	}
}
