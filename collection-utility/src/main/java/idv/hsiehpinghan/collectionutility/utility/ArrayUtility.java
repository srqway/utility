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

	/**
	 * Get objects string with delimiter seperated.
	 * 
	 * @param objects
	 * @param delimiter
	 * @return
	 */
	public static String toString(Object[] objects, String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0, size = objects.length; i < size; ++i) {
			if (i != 0) {
				sb.append(delimiter);
			}
			sb.append(objects[i]);
		}
		return sb.toString();
	}

	private static int getTotalSize(byte[]... byteArrays) {
		int total = 0;
		for (int i = 0, size = byteArrays.length; i < size; ++i) {
			total += byteArrays[i].length;
		}
		return total;
	}
}
