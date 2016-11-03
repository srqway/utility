package idv.hsiehpinghan.datetimeutility.utility;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ZonedDateTimeUtilityTest {
	private final int YEAR = 2016;
	private final int MONTH = 11;
	private final int DAY_OF_MONTH = 3;
	private final int HOUR = 12;
	private final int MINUTE = 54;
	private final int SECOND = 23;
	private final int NANO_OF_SECOND = 0;

	@Test
	public void toString_() {
		ZonedDateTime zonedDateTime = ZonedDateTime.of(YEAR, MONTH, DAY_OF_MONTH, HOUR, MINUTE, SECOND, NANO_OF_SECOND,
				ZoneId.systemDefault());
		String actual = ZonedDateTimeUtility.toString(zonedDateTime, DateTimeFormatter.ISO_INSTANT);
		Assert.assertEquals(actual, "2016-11-03T04:54:23Z");

	}
}
