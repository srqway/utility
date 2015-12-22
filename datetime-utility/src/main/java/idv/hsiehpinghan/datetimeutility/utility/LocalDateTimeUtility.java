package idv.hsiehpinghan.datetimeutility.utility;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalDateTimeUtility {

	public static LocalDateTime getLocalDateTime(Long time) {
		if (time == null) {
			return null;
		}
		Date date = new Date(time);
		return LocalDateTime
				.ofInstant(date.toInstant(), ZoneId.systemDefault());
	}

	public static String toString(LocalDateTime localDateTime, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return localDateTime.format(formatter);
	}

}
