package com;

public class FFint {
	public static void main(String []args){
		byte b_meterAddr = 0x11;
		int i_meterAddr = 0x00ff &  b_meterAddr; //整型表具地址编号
		System.out.println(i_meterAddr);
	}
}
