package idv.hsiehpinghan.datetimeutility.utility;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

public class DateUtility {
	public static final long SECOND_MILLISECONDS = 1000;
	public static final long MINUTE_MILLISECONDS = 60 * SECOND_MILLISECONDS;
	public static final long HOUR_MILLISECONDS = 60 * MINUTE_MILLISECONDS;
	public static final long DAY_MILLISECONDS = 24 * HOUR_MILLISECONDS;
	public static final long WEEK_MILLISECONDS = 7 * DAY_MILLISECONDS;

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
	 * Get year.
	 * 
	 * @return
	 */
	public static int getYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}

	/**
	 * Get season.
	 * 
	 * @return
	 */
	public static int getSeason() {
		int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		switch (month) {
		case 1:
		case 2:
		case 3:
			return 1;
		case 4:
		case 5:
		case 6:
			return 2;
		case 7:
		case 8:
		case 9:
			return 3;
		case 10:
		case 11:
		case 12:
			return 4;
		default:
			throw new RuntimeException("Month(" + month + ") undefined !!!");
		}
	}

	/**
	 * Get ROC year.
	 * 
	 * @param date
	 * @return
	 */
	public static int getRocYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR) - 1911;
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

	/**
	 * Get season start date.
	 * 
	 * @param year
	 * @param season
	 * @return
	 */
	public static Date getSeasonStartDate(int year, int season) {
		int yr;
		int sn;
		if (season == 1) {
			yr = year - 1;
			sn = 4;
		} else {
			yr = year;
			sn = season - 1;
		}
		int month = sn * 3 + 1;
		return getDate(yr, month, 1);
	}

	/**
	 * Get season end date.
	 * 
	 * @param year
	 * @param season
	 * @return
	 */
	public static Date getSeasonEndDate(int year, int season) {
		int month = season * 3 + 1;
		return DateUtils.addDays(getDate(year, month, 1), -1);
	}

	/**
	 * Check if date between startDate and endDate.
	 * 
	 * @param date
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static boolean isBetween(Date date, Date startDate, Date endDate) {
		if (startDate != null) {
			if (date.getTime() < startDate.getTime()) {
				return false;
			}
		}
		if (endDate != null) {
			if (endDate.getTime() < date.getTime()) {
				return false;
			}
		}
		return true;
	}
}
