package Time;

import java.text.SimpleDateFormat;
import java.util.*;

public class TimeAddTest {


	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String specifiedDay = sdf.format(date);
		System.out.println(specifiedDay);

		sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			date = sdf.parse("2012-11-14 23:00:01");
			System.out.println(date);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, 7);
		String dayAfter = new SimpleDateFormat("yyyyMMdd").format(c.getTime());

		System.out.print(dayAfter);
	}

}
