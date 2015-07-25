package idv.hsiehpinghan.streamutility.utility;

import java.io.Reader;
import java.io.StringReader;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReaderUtilityTest {
	private final String string = "abcdefghijklmnopqrstuvwxyz";

	@Test
	public void readAsString() throws Exception {
		Reader reader = new StringReader(string);
		String returnString = ReaderUtility.readAsString(reader);
		Assert.assertEquals(returnString, string);
	}
}
