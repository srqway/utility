package idv.hsiehpinghan.resourceutility.utility;

import java.io.IOException;
import java.io.InputStream;

public class ResourceUtility {
	// private Logger logger = Logger.getLogger(this.getClass().getName());

	/**
	 * Get resource as inputStream.
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static InputStream getResourceAsStream(String filePath)
			throws IOException {
		return ClassLoader.getSystemResourceAsStream(filePath);
	}

	// /**
	// * Get classpath file resources.
	// * @param classLoader
	// * @param filePath
	// * @return
	// */
	// public static File getFileResource(String filePath) {
	// URL url = ClassLoader.getSystemResource(filePath);
	// return new File(url.getPath());
	// }

}
