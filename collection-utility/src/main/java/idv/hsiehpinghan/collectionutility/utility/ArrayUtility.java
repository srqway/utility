package idv.hsiehpinghan.collectionutility.utility;

public class ArrayUtility {
	/**
	 * Add all byteArrays.
	 * 
	 * @param byteArrays
	 * @return
	 */
	public static byte[] addAll(byte[]... byteArrays) {
		int totalSize = getTotalSize(byteArrays);
		byte[] result = new byte[totalSize];
		int index = 0;
		for (int i = 0, size = byteArrays.length; i < size; ++i) {
			for (int j = 0, sz = byteArrays[i].length; j < sz; ++j, ++index) {
				result[index] = byteArrays[i][j];
			}
		}
		return result;
	}

	private static int getTotalSize(byte[]... byteArrays) {
		int total = 0;
		for (int i = 0, size = byteArrays.length; i < size; ++i) {
			total += byteArrays[i].length;
		}
		return total;
	}
}
