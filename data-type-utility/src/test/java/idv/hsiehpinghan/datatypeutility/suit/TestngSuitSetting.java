package idv.hsiehpinghan.datatypeutility.suit;

import idv.hsiehpinghan.packageutility.utility.PackageUtility;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.BeforeSuite;

public class TestngSuitSetting {
	private static ApplicationContext applicationContext;

	@BeforeSuite()
	public void beforeSuite() throws IOException {
		String[] pkgs = PackageUtility.getSpringConfigurationPackages();
		applicationContext = new AnnotationConfigApplicationContext(pkgs);
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

}
