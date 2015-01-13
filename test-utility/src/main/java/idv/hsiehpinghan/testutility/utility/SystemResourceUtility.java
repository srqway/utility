package idv.hsiehpinghan.testutility.utility;

import java.io.File;
import java.net.URL;

public class SystemResourceUtility {
	public static File getFileResource(String filePath) {
		URL url = ClassLoader.getSystemResource(filePath);
		return new File(url.getPath());
	}
}
