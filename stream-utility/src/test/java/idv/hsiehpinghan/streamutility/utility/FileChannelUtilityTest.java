package idv.hsiehpinghan.streamutility.utility;

import java.io.File;

import org.testng.annotations.Test;

public class FileChannelUtilityTest {

	@Test
	public void copyFile() throws Exception {
		String inputPath = "/etc/passwd";
		String outputPath = "/tmp/FileChannelUtilityTest_copyFile";
		File inputFile = new File(inputPath);
		File outputFile = new File(outputPath);
		FileChannelUtility.copyFile(inputFile, outputFile);
	}
}
