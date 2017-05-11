package idv.hsiehpinghan.resourceutility.utility;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;

public class FileUtility {
	// private Logger logger = Logger.getLogger(this.getClass().getName());
	private static final FileFilter directoryFilter = generateFileFilter();

	/**
	 * List files recursively.
	 * 
	 * @param dirPath
	 * @return
	 * @throws IOException
	 */
	public static List<Path> listFilesRecursively(String dirPath) throws IOException {
		Path path = Paths.get(dirPath);
		return Files.walk(path).filter(Files::isRegularFile).collect(Collectors.toList());
	}

	/**
	 * Read lines as HashSet.
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static HashSet<String> readLinesAsHashSet(File file) throws IOException {
		List<String> lines = FileUtils.readLines(file);
		return new HashSet<String>(lines);
	}

	/**
	 * Get or create a file.
	 * 
	 * @param dir
	 * @param subDirectoryAndFileNames
	 * @return
	 * @throws IOException
	 */
	public static File getOrCreateFile(File dir, String... subDirectoriesAndFileName) throws IOException {
		int size = subDirectoriesAndFileName.length;
		String[] dirNames = ArrayUtils.subarray(subDirectoriesAndFileName, 0, size - 1);
		File directory = getOrCreateDirectory(dir, dirNames);
		File file = new File(directory, subDirectoriesAndFileName[size - 1]);
		if (file.exists()) {
			if (file.isFile() == false) {
				throw new RuntimeException("File(" + file.getAbsolutePath() + ") is not a file !!!");
			}
		} else {
			file.createNewFile();
		}
		return file;
	}

	/**
	 * Get or create an empty file.
	 * 
	 * @param dir
	 * @param subDirectoriesAndFileName
	 * @return
	 * @throws IOException
	 */
	public static File getOrCreateEmptyFile(File dir, String... subDirectoriesAndFileName) throws IOException {
		File file = getOrCreateFile(dir, subDirectoriesAndFileName);
		truncateFile(file);
		return file;
	}

	/**
	 * Get or create directory.
	 * 
	 * @param dir
	 * @param subDirectories
	 * @return
	 */
	public static File getOrCreateDirectory(File dir, String... subDirectories) {
		File tempFile = dir;
		for (int i = 0, size = subDirectories.length; i < size; ++i) {
			tempFile = new File(tempFile, subDirectories[i]);
		}
		if (tempFile.exists()) {
			if (tempFile.isDirectory() == false) {
				throw new RuntimeException("File(" + tempFile.getAbsolutePath() + ") is not a directory !!!");
			}
		} else {
			tempFile.mkdirs();
		}
		return tempFile;
	}

	/**
	 * List direct sub-directories of dir.
	 * 
	 * @param dir
	 * @return
	 */
	public static File[] listDirectories(File dir) {
		return dir.listFiles(directoryFilter);
	}

	/**
	 * Truncate file.
	 * 
	 * @param file
	 * @throws IOException
	 */
	public static void truncateFile(File file) throws IOException {
		FileUtils.write(file, "", Charsets.UTF_8);
	}

	/**
	 * Write string to file.
	 * 
	 * @param file
	 * @param string
	 * @throws FileNotFoundException
	 */
	public static void writeToFile(File file, String string) throws FileNotFoundException {
		try (PrintWriter printWriter = new PrintWriter(file)) {
			printWriter.write(string);
		}
	}

	private static FileFilter generateFileFilter() {
		return new FileFilter() {
			@Override
			public boolean accept(File file) {
				if (file.isDirectory()) {
					return true;
				} else {
					return false;
				}
			}
		};
	}
}
