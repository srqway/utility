package idv.hsiehpinghan.formatutility.utility;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CurrencyFormatUtilityTest {

	@Test
	public void format() {
		Assert.assertEquals(CurrencyFormatUtility.format(1234567890),
				"$1,234,567,890.00");
		Assert.assertEquals(CurrencyFormatUtility.format(12345.67890),
				"$12,345.68");
	}

}
