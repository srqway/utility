package idv.hsiehpinghan.datatypeutility.utility;

import java.nio.ByteBuffer;

public class LongUtility {
	public static final long LONG_DEFAULT_VALUE = 0L;
	public static final int LONG_BYTE_AMOUNT = Long.BYTES;

	public static final byte[] toBytes(long value) {
		ByteBuffer buffer = ByteBuffer.allocate(LONG_BYTE_AMOUNT);
		buffer.putLong(value);
		return buffer.array();
	}
}
