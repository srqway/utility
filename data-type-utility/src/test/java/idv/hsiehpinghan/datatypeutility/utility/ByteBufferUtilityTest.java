package idv.hsiehpinghan.datatypeutility.utility;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ByteBufferUtilityTest {
	private final int INTEGER = 3;
	private byte[] bytes;

	@Test
	public void convertToByteArray() {
		bytes = ByteBufferUtility.convertToByteArray(INTEGER);
	}

	@Test(dependsOnMethods = { "convertToByteArray" })
	public void convertToInt() {
		int i = ByteBufferUtility.convertToInt(bytes);
		Assert.assertEquals(i, INTEGER);
	}
}
