package idv.hsiehpinghan.datatypeutility.utility;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IntegerUtilityTest {
	private final int INTEGER = 3;
	private byte[] bytes;

	@Test
	public void convertToByteArray() {
		bytes = IntegerUtility.convertToByteArray(INTEGER);
	}

	@Test(dependsOnMethods = { "convertToByteArray" })
	public void convertToInt() {
		int i = IntegerUtility.convertToInt(bytes);
		Assert.assertEquals(i, INTEGER);
	}
}
