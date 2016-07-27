package idv.hsiehpinghan.collectionutility.java.util;

import java.util.LinkedHashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import idv.hsiehpinghan.collectionutility.valueobject.HashCodeAndEquals;

public class LinkedHashSetTest {

	@Test
	public void insertOrder() {
		final int SIZE = 2;
		Set<HashCodeAndEquals> set = new LinkedHashSet<HashCodeAndEquals>();
		for (int i = SIZE; i > 0; --i) {
			set.add(generateHashCodeAndEquals(i, "first"));
		}
		for (int i = SIZE; i > 0; --i) {
			set.add(generateHashCodeAndEquals(i, "second"));
		}
		Assert.assertEquals(SIZE, set.size());
		for (HashCodeAndEquals item : set) {
			Assert.assertTrue(item.getName().startsWith("first"));
		}
		int i = SIZE;
		for (HashCodeAndEquals vo : set) {
			Assert.assertEquals(vo.getId(), i);
			--i;
		}
	}

	private HashCodeAndEquals generateHashCodeAndEquals(int i, String name) {
		HashCodeAndEquals obj = new HashCodeAndEquals();
		obj.setId(i);
		obj.setName(name + "_" + i);
		return obj;
	}
}
