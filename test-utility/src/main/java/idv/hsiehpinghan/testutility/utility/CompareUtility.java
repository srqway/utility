package idv.hsiehpinghan.testutility.utility;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.ArrayUtils;

public class CompareUtility {
	public static Integer getIndexOfDifferentChar(String s0, String s2) {
		char[] charArr_1 = s0.toCharArray();
		char[] charArr_2 = s2.toCharArray();
		int size_1 = charArr_1.length;
		int size_2 = charArr_2.length;
		int size = (size_1 > size_2 ? size_2 : size_1);
		for (int i = 0; i < size; ++i) {
			if (charArr_1[i] != charArr_2[i]) {
				String str_1 = new String(ArrayUtils.subarray(charArr_1, i,
						size_1));
				String str_2 = new String(ArrayUtils.subarray(charArr_2, i,
						size_2));
				System.err.println("str_1 : " + str_1);
				System.err.println("str_2 : " + str_2);
				return i;
			}
		}
		return null;
	}

	public static Integer getIndexOfDifferentByte(ByteBuffer bf1, ByteBuffer bf2) {
		return getIndexOfDifferentByte(bf1.array(), bf2.array());
	}

	public static Integer getIndexOfDifferentByte(byte[] bs1, byte[] bs2) {
		int size_1 = bs1.length;
		int size_2 = bs2.length;
		int size = (size_1 > size_2 ? size_2 : size_1);
		for (int i = 0; i < size; ++i) {
			if (bs1[i] != bs2[i]) {
				System.err.println("bs1[i] : " + bs1[i]);
				System.err.println("bs2[i] : " + bs2[i]);
				return i;
			}
		}
		return null;
	}

	public static boolean compareCharSequenceMap(
			Map<CharSequence, CharSequence> map0,
			Map<CharSequence, CharSequence> map1) {
		if (map0.size() != map1.size()) {
			return false;
		}
		Map<String, String> m0 = convertCharSequenceMapToStringMap(map0);
		Map<String, String> m1 = convertCharSequenceMapToStringMap(map1);
		for (Entry<String, String> ent : m0.entrySet()) {
			String k0 = ent.getKey();
			String v0 = ent.getValue();
			String v1 = m1.get(k0);
			if (v0.equals(v1) == false) {
				return false;
			}
		}
		return true;
	}

	private static Map<String, String> convertCharSequenceMapToStringMap(
			Map<CharSequence, CharSequence> map) {
		Map<String, String> m = new HashMap<String, String>(map.size());
		map.forEach((k, v) -> {
			String key = k.toString();
			String value = v.toString();
			m.put(key, value);
		});
		return m;
	}
}
