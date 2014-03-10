package dates;

import java.util.Date;

public class DateExample1 {
	public static void main(String[] args) {
		// Internally, the date and time is stored as a primitive long.
		// Specifically, the long holds the number of milliseconds (you know,
		// 1000 of these per second), between the date being represented and
		// January 1, 1970.
		Date d1 = new Date(1000000000000L); // a trillion!
		System.out.println("1st date " + d1.toString());
		
		
		
		d1.setTime(d1.getTime() + 3600000); // 3600000 millis / hour
	    System.out.println("new time " + d1.toString());
	}
}
