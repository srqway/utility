package idv.hsiehpinghan.classutility.utility;

import idv.hsiehpinghan.classutility.levelone.LevelOne;
import idv.hsiehpinghan.classutility.levelone.leveltwo.LevelTwo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ClassUtilityTest {
	private static final String PACKAGE_NAME = "idv.hsiehpinghan.classutility.levelone";

	@BeforeClass
	public void beforeClass() {
	}

	@Test
	public void getClasses() throws ClassNotFoundException, IOException {
		List<Class<?>> clses = new ArrayList<Class<?>>();
		clses.add(Class.forName(LevelOne.class.getName()));
		clses.add(Class.forName(LevelTwo.class.getName()));

		List<Class<?>> classes = ClassUtility.getClasses(PACKAGE_NAME);

		// Size equal
		Assert.assertEquals(clses.size(), classes.size());
		// Component the same
		Assert.assertTrue(classes.containsAll(clses));
	}

}
