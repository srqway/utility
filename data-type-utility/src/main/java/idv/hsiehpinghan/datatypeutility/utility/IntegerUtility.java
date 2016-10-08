package idv.hsiehpinghan.datatypeutility.utility;

public class IntegerUtility {
	public static final int INT_DEFAULT_VALUE = 0;
	public static final int INT_BYTE_AMOUNT = Integer.BYTES;

	public static byte[] convertToByteArray(int i) {
		byte[] result = new byte[4];
		result[3] = (byte) (i & 0xff);
		result[2] = (byte) ((i >> 8) & 0xff);
		result[1] = (byte) ((i >> 16) & 0xff);
		result[0] = (byte) (i >> 24);
		return result;
	}

	public static int convertToInt(byte[] bytes) {
		return bytes[3] & 0xFF | (bytes[2] & 0xFF) << 8 | (bytes[1] & 0xFF) << 16 | (bytes[0] & 0xFF) << 24;
	}

}
