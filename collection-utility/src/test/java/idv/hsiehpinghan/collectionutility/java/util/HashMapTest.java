package idv.hsiehpinghan.collectionutility.java.util;

import idv.hsiehpinghan.collectionutility.valueobject.HashCodeAndEquals;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HashMapTest {

	@Test
	public void HashCodeAndEquals() {
		final int SIZE = 2;
		Map<HashCodeAndEquals, String> map = new HashMap<HashCodeAndEquals, String>(
				SIZE);
		for (int i = 0, size = SIZE; i < size; ++i) {
			map.put(generateHashCodeAndEquals(i), "value_" + i);
		}
		for (int i = 0, size = SIZE; i < size; ++i) {
			map.put(generateHashCodeAndEquals(i), "value_" + i);
		}
		Assert.assertEquals(SIZE, map.size());
	}

	private HashCodeAndEquals generateHashCodeAndEquals(int i) {
		HashCodeAndEquals obj = new HashCodeAndEquals();
		obj.setId(i);
		obj.setName("name_" + i);
		return obj;
	}
}
