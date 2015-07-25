package idv.hsiehpinghan.streamutility.utility;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReaderUtilityTest {
	private final String STRING = "abcdefghijklmnopqrstuvwxyz";

	@Test
	public void readAsString() throws Exception {
		// readAsString(Reader reader)
		Reader reader = new StringReader(STRING);
		Assert.assertEquals(ReaderUtility.readAsString(reader), STRING);
		// String readAsString(InputStream inputStream)
		InputStream inutStream = new ByteArrayInputStream(STRING.getBytes());
		Assert.assertEquals(ReaderUtility.readAsString(inutStream), STRING);
	}

}
