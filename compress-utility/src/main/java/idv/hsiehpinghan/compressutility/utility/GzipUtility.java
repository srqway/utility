package idv.hsiehpinghan.compressutility.utility;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipUtility {
	private static final int SIZE = 1024;

	public static byte[] zipString(String string) throws IOException {
		try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);) {
			gZIPOutputStream.write(string.getBytes());
			gZIPOutputStream.close();
			return byteArrayOutputStream.toByteArray();
		}
	}

	public static String unzipToString(byte[] bytes) throws IOException {
		try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
				GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
				ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();) {
			byte[] buffer = new byte[SIZE];
			int offset = 0;
			while ((offset = gZIPInputStream.read(buffer)) != -1) {
				byteArrayOutputStream.write(buffer, 0, offset);
			}
			return byteArrayOutputStream.toString();
		}
	}
}
