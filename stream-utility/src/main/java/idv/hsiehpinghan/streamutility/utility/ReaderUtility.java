package idv.hsiehpinghan.streamutility.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.CharBuffer;

public class ReaderUtility {
	private static final int CAPACITY = 1024;

	/**
	 * Convert reader content to string.
	 * 
	 * @param reader
	 * @return
	 * @throws IOException
	 */
	public static String readAsString(Reader reader) throws IOException {
		CharBuffer buffer = CharBuffer.allocate(CAPACITY);
		StringBuilder sb = new StringBuilder();
		while (reader.read(buffer) >= 0) {
			sb.append(buffer.flip());
		}
		return sb.toString();
	}

	/**
	 * Convert inputStream content to string.
	 * 
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	public static String readAsString(InputStream inputStream)
			throws IOException {
		try (BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(inputStream))) {
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				sb.append(line);
			}
			return sb.toString();
		}
	}
}
