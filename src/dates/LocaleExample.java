package dates;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class LocaleExample {

	public static void main(String[] args) {

		Calendar c = Calendar.getInstance();
		c.set(2010, 11, 14); // December 14, 2010
								// (month is 0-based
		Date d2 = c.getTime();

		Locale locIT = new Locale("it", "IT"); // Italy
		Locale locPT = new Locale("pt"); // Portugal
		Locale locBR = new Locale("pt", "BR"); // Brazil
		Locale locIN = new Locale("hi", "IN"); // India
		Locale locJA = new Locale("ja"); // Japan
		Locale locDK = new Locale("da", "DK"); // Denmark

		System.out.println("def " + locBR.getDisplayCountry());
		System.out.println("loc " + locBR.getDisplayCountry(locBR));
		System.out.println("def " + locDK.getDisplayLanguage());
		System.out.println("loc " + locDK.getDisplayLanguage(locDK));
		System.out.println("D>I " + locDK.getDisplayLanguage(locIT));

		DateFormat dfUS = DateFormat.getInstance();
		System.out.println("US       " + dfUS.format(d2));

		DateFormat dfUSfull = DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println("US full  " + dfUSfull.format(d2));

		DateFormat dfIT = DateFormat.getDateInstance(DateFormat.FULL, locIT);
		System.out.println("Italy    " + dfIT.format(d2));

		DateFormat dfPT = DateFormat.getDateInstance(DateFormat.FULL, locPT);
		System.out.println("Portugal " + dfPT.format(d2));

		DateFormat dfBR = DateFormat.getDateInstance(DateFormat.FULL, locBR);
		System.out.println("Brazil   " + dfBR.format(d2));

		// Oops! Our machine isn't configured to support locales for India or
		// Japan, but you can see how a single Date object can be formatted to
		// work for many locales.
		DateFormat dfIN = DateFormat.getDateInstance(DateFormat.FULL, locIN);
		System.out.println("India    " + dfIN.format(d2));

		DateFormat dfJA = DateFormat.getDateInstance(DateFormat.FULL, locJA);
		System.out.println("Japan    " + dfJA.format(d2));
	}
}
