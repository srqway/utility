package idv.hsiehpinghan.packageutility.utility;

import idv.hsiehpinghan.packageutility.configuration.SpringConfiguration;
import idv.hsiehpinghan.packageutility.suit.TestngSuitSetting;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.springframework.context.ApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PackageUtilityTest {
	private PackageUtility packageUtility;
	
	@BeforeClass
	public void beforeClass() {
		setObjects();
	}

	@Test
	public void getSpringConfigurationPackages() throws IOException {
		String[] pkgArr = packageUtility.getSpringConfigurationPackages();
		List<String> pkgList = Arrays.asList(pkgArr);
		String springPkgNm = SpringConfiguration.class.getPackage().getName();
		Assert.assertTrue(pkgList.contains(springPkgNm));
	}
	
	private void setObjects() {
		ApplicationContext applicationContext = TestngSuitSetting
				.getApplicationContext();
		packageUtility = applicationContext.getBean(PackageUtility.class);
	}
}
