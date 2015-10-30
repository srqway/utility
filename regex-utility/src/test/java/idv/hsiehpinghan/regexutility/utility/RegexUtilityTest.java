package idv.hsiehpinghan.regexutility.utility;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegexUtilityTest {

	@Test
	public void isNumberString() {
		Assert.assertFalse(RegexUtility.isNumberString("12.345a"));
		Assert.assertTrue(RegexUtility.isNumberString("12.345"));
	}
}
