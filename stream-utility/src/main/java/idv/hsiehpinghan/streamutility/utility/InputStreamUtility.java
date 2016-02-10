package idv.hsiehpinghan.streamutility.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamUtility {

	/**
	 * Convert inputStream content to string.
	 * 
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	public static String readAsString(InputStream inputStream)
			throws IOException {
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(
					inputStream));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				sb.append(line);
			}
			return sb.toString();
		} finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		}
	}

	/**
	 * Convert inputStream content to byte array.
	 * 
	 * @param inputStream
	 * @param length
	 * @return
	 * @throws IOException
	 */
	public static byte[] readAsByteArray(InputStream inputStream, int length)
			throws IOException {
		byte[] byteArray = new byte[length];
		inputStream.read(byteArray);
		return byteArray;
	}
}
