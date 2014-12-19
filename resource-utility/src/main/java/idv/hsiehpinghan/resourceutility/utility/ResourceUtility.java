package idv.hsiehpinghan.resourceutility.utility;

import java.io.File;

public class ResourceUtility {
	// private Logger logger = Logger.getLogger(this.getClass().getName());
	
	/**
	 * Get classpath file resources.
	 * @param classLoader
	 * @param filePath
	 * @return
	 */
	public static File getFileResource(ClassLoader classLoader, String filePath) {
		classLoader.getResource(filePath);
		return new File(classLoader.getResource(filePath).getFile());
	}
}
