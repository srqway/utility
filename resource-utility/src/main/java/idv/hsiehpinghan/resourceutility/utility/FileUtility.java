package idv.hsiehpinghan.resourceutility.utility;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class FileUtility {
	// private Logger logger = Logger.getLogger(this.getClass().getName());

	/**
	 * Read lines as HashSet.
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static HashSet<String> readLinesAsHashSet(File file)
			throws IOException {
		List<String> lines = FileUtils.readLines(file);
		return new HashSet<String>(lines);
	}

}
