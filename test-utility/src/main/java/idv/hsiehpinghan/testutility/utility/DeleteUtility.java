package idv.hsiehpinghan.testutility.utility;

import java.io.File;

public class DeleteUtility {
	/**
	 * Delete file in directory by fileName.
	 * 
	 * @param directory
	 * @param fileName
	 */
	public static void delete(File directory, String fileName) {
		new File(directory, fileName).delete();
	}
}
