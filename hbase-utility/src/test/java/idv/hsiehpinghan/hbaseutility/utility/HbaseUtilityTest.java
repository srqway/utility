package idv.hsiehpinghan.hbaseutility.utility;

import idv.hsiehpinghan.hbaseutility.suit.TestngSuitSetting;

import java.io.IOException;

import junit.framework.Assert;

import org.springframework.context.ApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HbaseUtilityTest {
	private final String tableName = "TEST_TABLE";
	private final String[] colFamilies = { "COLFAM_1", "COLFAM_2" };
	private final String packageName = "idv.hsiehpinghan.mops.dao.domain";
	private HbaseUtility hbaseUtility;

	@BeforeClass
	public void beforeClass() throws IOException {
		setObjects();
		dropTables();
	}

//	@Test
	public void createTable() throws IOException {
		hbaseUtility.createTable(tableName, colFamilies);
		Assert.assertTrue(hbaseUtility.isTableExists(tableName));
	}

//	@Test(dependsOnMethods = { "createTable" })
	public void dropTable() throws IOException {
		hbaseUtility.dropTable(tableName);
		Assert.assertFalse(hbaseUtility.isTableExists(tableName));
	}

	@Test
	public void scanAndCreateTable() throws ClassNotFoundException, IOException {
		hbaseUtility.scanAndCreateTable(packageName);
	}
	
	private void setObjects() {
		ApplicationContext applicationContext = TestngSuitSetting
				.getApplicationContext();
		hbaseUtility = applicationContext.getBean(HbaseUtility.class);
	}

	private void dropTables() throws IOException {
		if (hbaseUtility.isTableExists(tableName)) {
			hbaseUtility.dropTable(tableName);
		}
	}
}
