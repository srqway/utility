package idv.hsiehpinghan.formatutility.utility;

import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IntegerFormatUtilityTest {

	@Test
	public void format() {
		Assert.assertEquals(IntegerFormatUtility.format(1234567890),
				"1,234,567,890");
		Assert.assertEquals(IntegerFormatUtility.format(12345.67890), "12,346");
	}

	@Test
	public void parse() throws ParseException {
		Assert.assertEquals(IntegerFormatUtility.parse("1,234,567,890")
				.longValue(), 1234567890L);
	}
}
