package idv.hsiehpinghan.formatutility.utility;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PercentFormatUtilityTest {

	@Test
	public void format() {
		Assert.assertEquals(PercentFormatUtility.format(1234567890),
				"123,456,789,000%");
		Assert.assertEquals(PercentFormatUtility.format(12345.67890),
				"1,234,568%");
	}
}
