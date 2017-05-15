package idv.hsiehpinghan.datatypeutility.utility;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

public class StringUtility {
	public static final String UTF_8 = "utf-8";
	public static final String EMPTY_STRING = "";
	public static final String COMMA_STRING = ",";
	public static final String FULL_WIDTH_COMMA_STRING = "，";
	public static final String DOUBLE_UOTATION_STRING = "\"";
	public static final String SPACE_STRING = " ";
	public static final String UNDERSCORE_STRING = "_";
	public static final String SPOT_STRING = ".";
	public static final String NA_STRING = "NA";

	/**
	 * Convert inputstream to string.
	 * 
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	public static String convert(InputStream inputStream) throws IOException {
		StringWriter writer = new StringWriter();
		IOUtils.copy(inputStream, writer, Charsets.UTF_8);
		return writer.toString();
	}

	/**
	 * Convert string to another chartset string.
	 * 
	 * @param string
	 * @param chartsetName
	 * @return
	 * @throws IOException
	 */
	public static String convertToUtf8(String string, String chartsetName) throws IOException {
		return new String(string.getBytes(chartsetName), UTF_8);
	}

	/**
	 * Get final format string.(ie. stockCode -> STOCK_CODE)
	 * 
	 * @param str
	 * @return
	 */
	public static String getFinalFormatString(String str) {
		StringBuilder sb = new StringBuilder();
		for (char c : str.toCharArray()) {
			if (Character.isUpperCase(c)) {
				sb.append('_');
			}
			sb.append(Character.toUpperCase(c));
		}
		return sb.toString();
	}

	/**
	 * remove 4 bytes character.
	 * 
	 * @param string
	 * @param replacement
	 * @return
	 */
	public static String removeFourBytesCharacter(String string, String replacement) {
		return string.replaceAll("[^\\u0000-\\uFFFF]", replacement);
	}
	
	/**
	 * full split string.
	 * @param string
	 * @param regex
	 * @return
	 */
	public static String[] fullSplit(String string, String regex) {
		return string.split(regex, -1);
	}
}
