package idv.hsiehpinghan.streamutility.utility;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ScannerUtility {
	public static String convertFileToString(File file) throws IOException {
		try (Scanner scanner = new Scanner(file)) {
			StringBuilder sb = new StringBuilder();
			while (scanner.hasNextLine()) {
				sb.append(scanner.nextLine());
			}
			return sb.toString();
		}
	}
}
