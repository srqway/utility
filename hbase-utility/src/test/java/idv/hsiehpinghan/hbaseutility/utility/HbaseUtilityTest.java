package idv.hsiehpinghan.hbaseutility.utility;

import idv.hsiehpinghan.hbaseutility.suit.TestngSuitSetting;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HbaseUtilityTest {
	private final String tableName = "TEST_TABLE"; 
	private final String[] colFamilies = {"COLFAM_1", "COLFAM_2"};
	private HbaseUtility hbaseUtility;

	@BeforeClass
	public void beforeClass() {
		setObjects();
		dropTables();
	}

	@Test
	public void createTable() {
		try {
			hbaseUtility.createTable(tableName, colFamilies);
		} catch (IOException e) {
			Assert.assertTrue(false, "Exception !!!");
			e.printStackTrace();
		}
	}

	private void setObjects() {
		ApplicationContext applicationContext = TestngSuitSetting
				.getApplicationContext();
		hbaseUtility = applicationContext.getBean(HbaseUtility.class);
	}
	
	private void dropTables() {
		
	}
}
