package idv.hsiehpinghan.datetimeutility.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DateUtilityTest {
	private static Pattern PATTERN_DD_MMMM_YYYY = Pattern.compile("(\\d{2} [a-zA-Z]{4,} \\d{4})");
	private static SimpleDateFormat SIMPLE_DATE_FORMAT__DD_MMMM_YYYY = new SimpleDateFormat("dd MMMM yyyy");

	@Test
	public void getDate() throws ParseException {
		Date date = null;
		date = DateUtility.getDate(PATTERN_DD_MMMM_YYYY, SIMPLE_DATE_FORMAT__DD_MMMM_YYYY, "23 October 2016");
		Assert.assertEquals(date.toString(), "Sun Oct 23 00:00:00 CST 2016");
	}
}
