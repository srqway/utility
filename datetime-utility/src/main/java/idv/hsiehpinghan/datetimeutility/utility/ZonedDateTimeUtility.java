package idv.hsiehpinghan.datetimeutility.utility;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeUtility {

	public static String toString(ZonedDateTime zonedDateTime, DateTimeFormatter dateTimeFormatter) {
		return zonedDateTime.format(dateTimeFormatter);
	}

}
