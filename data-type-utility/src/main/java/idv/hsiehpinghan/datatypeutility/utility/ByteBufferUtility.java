package idv.hsiehpinghan.datatypeutility.utility;

import java.nio.ByteBuffer;

public class ByteBufferUtility {
	public static String convertToString(ByteBuffer byteBuffer) {
		if (byteBuffer == null) {
			return null;
		}
		return new String(byteBuffer.array(), CharsetUtility.UTF_8);
	}

	public static byte[] convertToByteArray(int i) {
		return ByteBuffer.allocate(Integer.BYTES).putInt(i).array();
	}

	public static int convertToInt(byte[] bytes) {
		return ByteBuffer.wrap(bytes).getInt();
	}
}
