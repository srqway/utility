package idv.hsiehpinghan.compressutility.utility;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GzipUtilityTest {
	private final String STRING = "string";

	@Test
	public void zipAndUnzipString() throws IOException {
		byte[] stringBytes = GzipUtility.zipString(STRING);
		String string = GzipUtility.unzipToString(stringBytes);
		Assert.assertEquals(string, STRING);
	}
}
