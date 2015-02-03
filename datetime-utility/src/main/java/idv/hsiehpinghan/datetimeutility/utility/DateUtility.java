package idv.hsiehpinghan.datetimeutility.utility;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

public class DateUtility {
	/**
	 * Get date.
	 * 
	 * @param year
	 * @param month
	 * @param dayOfMonth
	 * @return
	 */
	public static Date getDate(int year, int month, int dayOfMonth) {
		return CalendarUtility.getCalendar(year, month, dayOfMonth).getTime();
	}

	/**
	 * Get Roc date string.
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String getRocDateString(Date date, String pattern) {
		Date dt = DateUtils.addYears(date, -1911);
		String dateStr = DateFormatUtils.format(dt, pattern);
		if (pattern.startsWith("yyyy")) {
			return dateStr.substring(1);
		}
		return dateStr;
	}

	/**
	 * Get year.
	 * 
	 * @param date
	 * @return
	 */
	public static int getYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}

	/**
	 * Get month.
	 * 
	 * @param date
	 * @return
	 */
	public static int getMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH) + 1;
	}

	/**
	 * Get day of month.
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * Parse roc date.
	 * 
	 * @param dateString
	 * @param datePattern
	 * @return
	 * @throws ParseException
	 */
	public static Date parseRocDate(String dateString, String pattern)
			throws ParseException {
		if (pattern.startsWith("yyyy") == false) {
			throw new RuntimeException("Date pattern(" + pattern
					+ ") not implements !!!");
		}
		Integer year = Integer.valueOf(dateString.substring(0, 3)) + 1911;
		String remain = dateString.substring(3);
		String dateStr = year + remain;
		return DateUtils.parseDate(dateStr, pattern);
	}
}
