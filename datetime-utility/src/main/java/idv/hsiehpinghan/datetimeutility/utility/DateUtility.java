package idv.hsiehpinghan.datetimeutility.utility;

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

}
