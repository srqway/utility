package idv.hsiehpinghan.runtimeutility.utility;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RuntimeUtilityTest {

	@Test
	public void execute() throws Exception {
		String command = "ping -c 1 google.com";
		int result = RuntimeUtility.execute(command);
		Assert.assertEquals(result, 0);
	}
}
