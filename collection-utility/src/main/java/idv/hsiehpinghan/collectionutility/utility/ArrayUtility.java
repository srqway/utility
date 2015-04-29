package idv.hsiehpinghan.collectionutility.utility;

import java.util.HashSet;

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

	/**
	 * Replace bytes with subBytes between beginIndex and endIndex.
	 * 
	 * @param bytes
	 * @param subBytes
	 * @param beginIndex
	 * @param endIndex
	 */
	public static void replace(byte[] bytes, byte[] subBytes, int beginIndex,
			int endIndex) {
		for (int i = beginIndex, j = 0; i < endIndex; ++i, ++j) {
			bytes[i] = subBytes[j];
		}
	}

	/**
	 * Get bytes fill of bt.
	 * 
	 * @param length
	 * @param bt
	 * @return
	 */
	public static byte[] getBytes(int length, byte bt) {
		byte[] bytes = new byte[length];
		for (int i = 0; i < length; ++i) {
			bytes[i] = bt;
		}
		return bytes;
	}

	/**
	 * If bytes1 < bytes2 return -1; If bytes1 > bytes2 return 1; Else return 0;
	 * 
	 * @param bytes1
	 * @param bytes2
	 * @return
	 */
	public static int compareTo(byte[] bytes1, byte[] bytes2) {
		int size1 = bytes1.length;
		int size2 = bytes2.length;
		int size = getMinSize(size1, size2);
		for (int i = 0; i < size; ++i) {
			int result = Byte.compare(bytes1[i], bytes2[i]);
			if (result != 0) {
				return result;
			}
		}
		if (size1 < size2) {
			return -1;
		} else if (size2 < size1) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * Convert array to HashSet.
	 * 
	 * @param arrays
	 * @return
	 */
	public static <T> HashSet<T> asHashSet(T[] arrays) {
		HashSet<T> result = new HashSet<T>(arrays.length);
		for (T t : arrays) {
			result.add(t);
		}
		return result;
	}

	// /**
	// * Concate string array to string with delimiter.
	// *
	// * @param strArr
	// * @param delimiter
	// * @return
	// */
	// public static String toString(String[] strArr, String delimiter) {
	// StringBuilder sb = new StringBuilder();
	// for (int i = 0, size = strArr.length; i < size; ++i) {
	// if (i != 0) {
	// sb.append(delimiter);
	// }
	// sb.append(strArr[i]);
	// }
	// return sb.toString();
	// }

	private static int getMinSize(int size1, int size2) {
		if (size1 < size2) {
			return size1;
		} else {
			return size2;
		}
	}

	private static int getTotalSize(byte[]... byteArrays) {
		int total = 0;
		for (int i = 0, size = byteArrays.length; i < size; ++i) {
			total += byteArrays[i].length;
		}
		return total;
	}
}
