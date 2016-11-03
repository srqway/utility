package idv.hsiehpinghan.datetimeutility.utility;

import java.time.LocalDateTime;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocalDateTimeUtilityTest {
	private final int YEAR = 2016;
	private final int MONTH = 11;
	private final int DAY_OF_MONTH = 3;
	private final int HOUR = 12;
	private final int MINUTE = 54;
	private final int SECOND = 23;

	@Test
	public void getLocalDateTime() {
		Date date = new Date();
		LocalDateTime localDateTime = LocalDateTimeUtility.getLocalDateTime(date.getTime());
		String expected = DateFormatUtils.format(date, "yyyy-MM-dd") + "T"
				+ DateFormatUtils.format(date, "HH:mm:ss.SSS");
		String actual = localDateTime.toString();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void toString_() {
		LocalDateTime localDateTime = LocalDateTime.of(YEAR, MONTH, DAY_OF_MONTH, HOUR, MINUTE, SECOND);
		String expected = String.format("%02d", YEAR) + "-" + String.format("%02d", MONTH) + "-"
				+ String.format("%02d", DAY_OF_MONTH) + " " + String.format("%02d", HOUR) + ":"
				+ String.format("%02d", MINUTE) + ":" + String.format("%02d", SECOND);
		String actual = LocalDateTimeUtility.toString(localDateTime, "yyyy-MM-dd HH:mm:ss");
		Assert.assertEquals(expected, actual);
	}

}
