package idv.hsiehpinghan.datatypeutility.utility;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

public class StringUtility {
	public static final String EMPTY_STRING = "";
	public static final String COMMA_STRING = ",";
	public static final String DOUBLE_UOTATION_STRING = "\"";
	
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
	 * Get final format string.(ie. stockCode -> STOCK_CODE)
	 * @param str
	 * @return
	 */
	public static String getFinalFormatString(String str) {
		StringBuilder sb = new StringBuilder();
		for(char c : str.toCharArray()) {
			if(Character.isUpperCase(c)) {
				sb.append('_');
			}
			sb.append(Character.toUpperCase(c));
		}
		return sb.toString();
	}
}
