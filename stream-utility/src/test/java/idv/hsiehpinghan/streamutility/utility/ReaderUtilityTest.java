package idv.hsiehpinghan.streamutility.utility;

import java.io.Reader;
import java.io.StringReader;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReaderUtilityTest {
	private final String STRING = "abcdefghijklmnopqrstuvwxyz";

	@Test
	public void readAsString() throws Exception {
		Reader reader = new StringReader(STRING);
		Assert.assertEquals(ReaderUtility.readAsString(reader), STRING);
	}

}
