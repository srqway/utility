package idv.hsiehpinghan.streamutility.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamUtility {
	public static void write(String filePath, String content) throws IOException {
		File file = new File(filePath);
		FileOutputStream fop = new FileOutputStream(file);
		if (!file.exists()) {
			file.createNewFile();
		}
		fop.write(content.getBytes());
		fop.flush();
		fop.close();
	}
}