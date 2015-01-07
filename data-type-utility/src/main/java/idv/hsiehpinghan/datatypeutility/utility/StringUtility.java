package idv.hsiehpinghan.datatypeutility.utility;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

public class StringUtility {
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
}
