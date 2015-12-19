package idv.hsiehpinghan.resourceutility.utility;

import java.io.IOException;
import java.io.InputStream;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ResourceUtilityTest {

	@BeforeClass
	public void beforeClass() {
	}

	@Test
	public void getResourceAsStream() throws IOException {
		InputStream in = ResourceUtility
				.getResourceAsStream("log4j.properties");
		Assert.assertEquals(2996, in.available());
	}

}
