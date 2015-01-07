package idv.hsiehpinghan.compressutility.utility;

import java.io.File;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class CompressUtility {
	/**
	 * Unzip file to extractDirectory and return it.
	 * 
	 * @param file
	 * @param extractDirectory
	 * @param includeFilenameInExtractDirectory
	 * @return
	 * @throws ZipException
	 */
	public static File unzip(File file, File extractDirectory,
			boolean includeFilenameInExtractDirectory) throws ZipException {
		File target = null;
		if(includeFilenameInExtractDirectory == true) {
			target = new File(extractDirectory, file.getName());
		} else {
			target = extractDirectory;
		}
		if (target.exists() == false) {
			target.mkdir();
		}
		ZipFile zip = new ZipFile(file);
		zip.extractAll(target.getAbsolutePath());
		return target;
	}
}
