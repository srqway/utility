package idv.hsiehpinghan.datetimeutility.utility;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ZonedDateTimeUtility {

	public static String toString(ZonedDateTime zonedDateTime, DateTimeFormatter dateTimeFormatter) {
		return zonedDateTime.format(dateTimeFormatter);
	}

	public static long getBetweenSeconds(ZonedDateTime beforeDateTime, ZonedDateTime afterDateTime) {
		return ChronoUnit.SECONDS.between(beforeDateTime, afterDateTime);
	}
}
