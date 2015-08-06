package idv.hsiehpinghan.collectionutility.java.util;

import idv.hsiehpinghan.collectionutility.valueobject.HashCodeAndEquals;

import java.util.HashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HashSetTest {

	@Test
	public void HashCodeAndEquals() {
		final int SIZE = 2;
		Set<HashCodeAndEquals> set = new HashSet<HashCodeAndEquals>();
		for (int i = 0, size = SIZE; i < size; ++i) {
			set.add(generateHashCodeAndEquals(i, "first"));
		}
		for (int i = 0, size = SIZE; i < size; ++i) {
			set.add(generateHashCodeAndEquals(i, "second"));
		}
		Assert.assertEquals(SIZE, set.size());
		for (HashCodeAndEquals item : set) {
			Assert.assertTrue(item.getName().startsWith("first"));
		}
	}

	private HashCodeAndEquals generateHashCodeAndEquals(int i, String name) {
		HashCodeAndEquals obj = new HashCodeAndEquals();
		obj.setId(i);
		obj.setName(name + "_" + i);
		return obj;
	}
}
