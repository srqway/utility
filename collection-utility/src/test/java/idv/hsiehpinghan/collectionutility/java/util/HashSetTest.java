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
			set.add(generateHashCodeAndEquals(i));
		}
		for (int i = 0, size = SIZE; i < size; ++i) {
			set.add(generateHashCodeAndEquals(i));
		}
		Assert.assertEquals(SIZE, set.size());
	}

	private HashCodeAndEquals generateHashCodeAndEquals(int i) {
		HashCodeAndEquals obj = new HashCodeAndEquals();
		obj.setId(i);
		obj.setName("name_" + i);
		return obj;
	}
}
