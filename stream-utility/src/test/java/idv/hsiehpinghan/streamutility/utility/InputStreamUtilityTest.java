package idv.hsiehpinghan.streamutility.utility;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InputStreamUtilityTest {
	private final String STRING = "abcdefghijklmnopqrstuvwxyz";

	@Test
	public void readAsString() throws Exception {
		InputStream inutStream = new ByteArrayInputStream(STRING.getBytes());
		Assert.assertEquals(InputStreamUtility.readAsString(inutStream), STRING);
	}

}
