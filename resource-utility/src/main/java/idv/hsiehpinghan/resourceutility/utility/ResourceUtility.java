package idv.hsiehpinghan.resourceutility.utility;

import java.io.File;
import java.net.URL;

public class ResourceUtility {
	// private Logger logger = Logger.getLogger(this.getClass().getName());
	
	/**
	 * Get classpath file resources.
	 * @param classLoader
	 * @param filePath
	 * @return
	 */
	public static File getFileResource(String filePath) {
		URL url = ClassLoader.getSystemResource(filePath);
		return new File(url.getPath());
	}

}
