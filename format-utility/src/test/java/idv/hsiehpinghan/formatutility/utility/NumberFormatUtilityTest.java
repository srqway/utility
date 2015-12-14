package idv.hsiehpinghan.formatutility.utility;

import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberFormatUtilityTest {

	@Test
	public void format() {
		Assert.assertEquals(NumberFormatUtility.format(1234567890),
				"1,234,567,890");
		Assert.assertEquals(NumberFormatUtility.format(12345.67890),
				"12,345.679");
	}

	@Test
	public void parse() throws ParseException {
		Assert.assertEquals(NumberFormatUtility.parse("12,345.679").toString(),
				"12345.679");
	}
}
