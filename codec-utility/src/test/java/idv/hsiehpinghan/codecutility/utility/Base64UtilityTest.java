package idv.hsiehpinghan.codecutility.utility;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Base64UtilityTest {
	private final byte[] BYTES = new byte[] { 0x0, 0x1, 0x2 };

	@Test
	public void codeAndDecode() {
		String string = Base64Utility.encode(BYTES);
		byte[] bytes = Base64Utility.decode(string);
		for (int i = 0, size = bytes.length; i < size; ++i) {
			Assert.assertEquals(bytes[i], BYTES[i]);
		}
	}
}
