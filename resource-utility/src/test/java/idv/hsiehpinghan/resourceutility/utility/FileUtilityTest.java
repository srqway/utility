package idv.hsiehpinghan.resourceutility.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUtilityTest {

	@Test
	public void writeToFile() throws Exception {
		String str = "FileUtilityTest";
		File file = new File("/tmp/FileUtilityTest_writeToFile");
		FileUtility.writeToFile(file, str);
		FileInputStream fileInputStream = new FileInputStream(file);
		InputStreamReader inputStreamReader = new InputStreamReader(
				fileInputStream);
		try (BufferedReader bufferedReader = new BufferedReader(
				inputStreamReader)) {
			Assert.assertEquals(bufferedReader.readLine(), str);
		}
	}
}
