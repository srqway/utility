package idv.hsiehpinghan.compressutility.utility;

import java.io.File;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class CompressUtility {
	/**
	 * Unzip file to extractDirectory/file.getName().
	 * @param file
	 * @param extractDirectory
	 * @throws ZipException
	 */
	public static void unzip(File file, File extractDirectory)
			throws ZipException {
		ZipFile zip = new ZipFile(file);
		String dir = extractDirectory.getAbsolutePath() + "/" + file.getName();
		zip.extractAll(dir);
	}
}
