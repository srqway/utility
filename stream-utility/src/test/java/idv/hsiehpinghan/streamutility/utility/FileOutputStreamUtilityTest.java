package idv.hsiehpinghan.streamutility.utility;

import java.io.IOException;

import org.testng.annotations.Test;

public class FileOutputStreamUtilityTest {
	private final String FILE_PATH = "/tmp/FileOutputStreamUtilityTest";
	private final String CONTENT = "abcdefghijklmnopqrstuvwxyz";

	@Test
	public void write() throws IOException {
		FileOutputStreamUtility.write(FILE_PATH, CONTENT);
	}
}
