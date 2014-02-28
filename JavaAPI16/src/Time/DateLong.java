package Time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateLong {

	public static void main(String[] args) throws ParseException {
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.set(2012, 5, 1);
		d = c.getTime();
		Long l = d.getTime();
		System.out.println(l);
		
		String time = "2012-05-01";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		d = df.parse(time);
		l = d.getTime();
		System.out.println(l);

		Long ll = 1335801600000L;
		Date dd = new Date(ll);
		System.out.print(dd);
	}
}
