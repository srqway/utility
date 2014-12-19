package idv.hsiehpinghan.resourceutility.utility;

import java.io.File;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ResourceUtilityTest {

	@BeforeClass
	public void beforeClass() {
	}

	@Test
	public void getFileResource() {
		File file = ResourceUtility.getFileResource(this.getClass().getClassLoader(), "log4j.properties");
		Assert.assertTrue(file.exists());
	}
}
