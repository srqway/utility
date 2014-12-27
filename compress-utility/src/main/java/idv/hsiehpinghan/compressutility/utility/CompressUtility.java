package idv.hsiehpinghan.compressutility.utility;

import java.io.File;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class CompressUtility {
	/**
	 * Unzip file to extractDirectory/file.getName() and return it.
	 * 
	 * @param file
	 * @param extractDirectory
	 * @return
	 * @throws ZipException
	 */
	public static File unzip(File file, File extractDirectory)
			throws ZipException {
		ZipFile zip = new ZipFile(file);
		String dir = extractDirectory.getAbsolutePath() + "/" + file.getName();
		File target = new File(dir);
		if (target.exists() == false) {
			target.mkdir();
		}
		zip.extractAll(target.getAbsolutePath());
		return target;
	}
}
