package 人人;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

public class Zuoyou {

	public static void pp(){
		
	}
	public int howmany(int n,int m){
		pp();
		if((n==0&&m==0)||n<0||m<0){
			return 0;
		}
		if(m==1||n==1){
			return 1;
		}
		
		return howmany(n-1, m)+howmany(n, m-1);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Zuoyou zy= new Zuoyou();
		int r = zy.howmany(3, 3);
		
		
		
		
		System.out.println("r:"+r);
		System.out.println((int)3.9);
		Math.floor(3.9);
		System.out.println(Math.floor(3.5));
		System.out.println(Math.ceil(3.1));
		System.out.println(Math.round(-0.671));
		
		BigDecimal bd = new BigDecimal(-0.679);
		BigDecimal dd =bd.setScale(2, RoundingMode.HALF_UP);
		System.out.println(dd);
		System.out.println((-10)%(-3));
		
	}

}
