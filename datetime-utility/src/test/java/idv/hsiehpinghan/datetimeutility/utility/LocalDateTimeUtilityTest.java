package idv.hsiehpinghan.datetimeutility.utility;

import java.time.LocalDateTime;
import java.util.Date;

import junit.framework.Assert;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.testng.annotations.Test;

public class LocalDateTimeUtilityTest {

	@Test
	public void getLocalDateTime() {
		Date date = new Date();
		LocalDateTime localDateTime = LocalDateTimeUtility
				.getLocalDateTime(date.getTime());
		String expected = DateFormatUtils.format(date, "yyyy-MM-dd") + "T"
				+ DateFormatUtils.format(date, "hh:mm:ss.SSS");
		String actual = localDateTime.toString();
		Assert.assertEquals(expected, actual);
	}
}
