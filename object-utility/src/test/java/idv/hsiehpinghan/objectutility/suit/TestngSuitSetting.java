package idv.hsiehpinghan.objectutility.suit;

import idv.hsiehpinghan.objectutility.configuration.SpringConfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.BeforeSuite;

public class TestngSuitSetting {
	private static ApplicationContext applicationContext;

	@BeforeSuite()
	public void beforeSuite() {
		applicationContext = new AnnotationConfigApplicationContext(
				SpringConfiguration.class);
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

}
