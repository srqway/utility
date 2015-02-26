package idv.hsiehpinghan.resourceutility.utility;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CsvUtility {
	// private Logger logger = Logger.getLogger(this.getClass().getName());

	public static CSVParser getParserAtDataStartRow(File file, Charset charset,
			CSVFormat format, String[] targetTitles) throws IOException {
		CSVParser parser = CSVParser.parse(file, charset, format);
		for (CSVRecord record : parser) {
			if (isContentEqual(record, targetTitles) == true) {
				return parser;
			}
		}
		throw new RuntimeException("File(" + file.getAbsolutePath()
				+ ") cannot find titles(" + targetTitles + ") !!!");
	}

	private static boolean isContentEqual(CSVRecord record,
			String[] targetTitles) {
		int size = record.size();
		int length = targetTitles.length;
		if (size != length) {
			return false;
		}
		for (int i = 0; i < length; ++i) {
			if (targetTitles[i].equals(record.get(i)) == false) {
				return false;
			}
		}
		return true;
	}
}
