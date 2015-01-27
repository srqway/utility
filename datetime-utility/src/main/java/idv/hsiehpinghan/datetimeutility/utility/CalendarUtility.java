package idv.hsiehpinghan.datetimeutility.utility;

import java.util.Calendar;

public class CalendarUtility {
	/**
	 * Get int type of yyyyMM.
	 * 
	 * @param calendar
	 * @return
	 */
	public static int getYyyyMm(Calendar calendar) {
		return calendar.get(Calendar.YEAR) * 100
				+ (calendar.get(Calendar.MONTH) + 1);
	}

	/**
	 * Get calendar.
	 * 
	 * @param year
	 * @param month
	 * @param dayOfMonth
	 * @param hour
	 * @param minute
	 * @param second
	 * @return
	 */
	public static Calendar getCalendar(int year, int month, int dayOfMonth,
			int hour, int minute, int second) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(0);
		cal.set(year, month - 1, dayOfMonth, hour, minute, second);
		return cal;
	}

	/**
	 * Get calendar.
	 * 
	 * @param year
	 * @param month
	 * @param dayOfMonth
	 * @return
	 */
	public static Calendar getCalendar(int year, int month, int dayOfMonth) {
		return getCalendar(year, month, dayOfMonth, 0, 0, 0);
	}
}
