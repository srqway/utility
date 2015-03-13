package idv.hsiehpinghan.testutility.utility;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class PrintUtility {
	public static void print(Object... objects) {
		int i = 0;
		for (Object obj : objects) {
			if (i > 0) {
				System.err.print(" / ");
			}
			System.err.print(obj);
			++i;
		}
		System.err.println();
	}

	public static void print(List<String> strs) {
		int i = 0;
		for (String str : strs) {
			if (i > 0) {
				System.err.print(" / ");
			}
			System.err.print(str);
			++i;
		}
		System.err.println();
	}

	public static void print(byte[] bytes) {
		for (byte b : bytes) {
			System.err.print(b);
		}
		System.err.println();
	}

	public static void print(Map<?, ?> map) {
		for (Map.Entry<?, ?> entry : map.entrySet()) {
			System.err.println(entry.getKey() + "/" + entry.getValue());
		}
	}

	public static void print(String[] strArr) {
		for (String s : strArr) {
			System.err.println(s);
		}
	}

	public static void print(Vector<?> vec) {
		for (int i = 0, size = vec.size(); i < size; ++i) {
			System.err.println(vec.get(i));
		}
	}

	public static void print(Hashtable<?, ?> hashTable) {
		Enumeration<?> en = hashTable.keys();
		while (en.hasMoreElements()) {
			Object key = en.nextElement();
			Object value = hashTable.get(key);
			System.err.println(key + " / " + value);
		}
	}

}
