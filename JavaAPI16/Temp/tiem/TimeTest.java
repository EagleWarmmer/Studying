package tiem;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTest {
	public static void main (String[] args){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try{
			Date date = sdf.parse("2012-11-14 23:00:01");
			System.out.println(date);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
