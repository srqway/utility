package idv.hsiehpinghan.datetimeutility.utility;

import java.util.Calendar;

public class CalendarUtility {
	public static int getYyyyMm(Calendar calendar) {
		return calendar.get(Calendar.YEAR) * 100
				+ (calendar.get(Calendar.MONTH) + 1);

	}
}
