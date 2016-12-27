package idv.hsiehpinghan.datetimeutility.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DateUtilityTest {
	private static Pattern PATTERN_0 = Pattern.compile("(\\d{2} [a-zA-Z]{4,} \\d{4})");
	private static SimpleDateFormat SIMPLE_DATE_FORMAT_0 = new SimpleDateFormat("dd MMMM yyyy");
	private static Pattern PATTERN_1 = Pattern.compile("(\\d{4}-\\d{1,2}-\\d{1,2}T\\d{1,2}:\\d{1,2}:\\d{1,2})\\+0000");
	private static SimpleDateFormat SIMPLE_DATE_FORMAT_1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	@Test
	public void getDate() throws ParseException {
		Date date = null;
		date = DateUtility.getDate(PATTERN_0, SIMPLE_DATE_FORMAT_0, "23 October 2016");
		Assert.assertEquals(date.toString(), "Sun Oct 23 00:00:00 CST 2016");
		date = DateUtility.getDate(PATTERN_1, SIMPLE_DATE_FORMAT_1, "2016-2-27T01:00:36+0000");
		Assert.assertEquals(date.toString(), "Sat Feb 27 01:00:36 CST 2016");

	}

}
