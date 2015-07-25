package idv.hsiehpinghan.datatypeutility.utility;

public class ByteUtility {
	public static final byte BYTE_DEFAULT_VALUE = 0;
	public static final int BYTE_BYTE_AMOUNT = Byte.BYTES;
	public static final byte[] SINGLE_SPACE_BYTE_ARRAY = new byte[] { (byte) 32 };
	public static final byte BYTE_ZERO = (byte) 0;
	public static final byte BYTE_ONE = (byte) 1;
	public static final byte[] SINGLE_ZERO_BYTE_ARRAY = new byte[] { (byte) 0 };

	// public static final byte[] SINGLE_TAB_BYTE_ARRAY = new byte[] { (byte) 9
	// };

	public static String getHexString(byte b) {
		return String.format("%02X", b);
	}

}
