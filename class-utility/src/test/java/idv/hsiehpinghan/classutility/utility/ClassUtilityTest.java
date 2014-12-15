package idv.hsiehpinghan.classutility.utility;

import idv.hsiehpinghan.classutility.levelone.LevelOne;
import idv.hsiehpinghan.classutility.levelone.leveltwo.LevelTwo;
import idv.hsiehpinghan.classutility.suit.TestngSuitSetting;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ClassUtilityTest {
	private static final String PACKAGE_NAME = "idv.hsiehpinghan.classutility.levelone";
	private ClassUtility classUtility;
	
	@BeforeClass
	public void beforeClass() {
		setObjects();
	}

	@Test
	public void getClasses() {
		try {
			List<Class<?>> clses = new ArrayList<Class<?>>();
			clses.add(Class.forName(LevelOne.class.getName()));
			clses.add(Class.forName(LevelTwo.class.getName()));

			List<Class<?>> classes = classUtility.getClasses(PACKAGE_NAME);
			
			// Size equal
			Assert.assertEquals(clses.size(), classes.size());
			// Component the same
			Assert.assertTrue(classes.containsAll(clses));
		} catch (Exception e) {
			Assert.assertTrue(false, "Exception !!!");
			e.printStackTrace();
		}

	}
	
	private void setObjects() {
		ApplicationContext applicationContext = TestngSuitSetting
				.getApplicationContext();
		
		classUtility = applicationContext.getBean(ClassUtility.class);
	}
}
