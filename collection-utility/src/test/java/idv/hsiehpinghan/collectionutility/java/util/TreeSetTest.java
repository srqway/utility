package idv.hsiehpinghan.collectionutility.java.util;

import idv.hsiehpinghan.collectionutility.valueobject.HashCodeAndEqualsAndComparable;

import java.util.Set;
import java.util.TreeSet;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TreeSetTest {

	@Test
	public void HashCodeAndEqualsAndComparable() {
		final int SIZE = 2;
		Set<HashCodeAndEqualsAndComparable> set = new TreeSet<HashCodeAndEqualsAndComparable>();
		for (int i = 0, size = SIZE; i < size; ++i) {
			set.add(generateHashCodeAndEquals(i, "first"));
		}
		for (int i = 0, size = SIZE; i < size; ++i) {
			set.add(generateHashCodeAndEquals(i, "second"));
		}
		Assert.assertEquals(SIZE, set.size());
		for (HashCodeAndEqualsAndComparable item : set) {
			Assert.assertTrue(item.getName().startsWith("first"));
		}
	}

	@Test
	public void contains() {
		HashCodeAndEqualsAndComparable obj = generateHashCodeAndEquals(1,
				"name");
		Set<HashCodeAndEqualsAndComparable> set = new TreeSet<HashCodeAndEqualsAndComparable>();
		set.add(obj);
		Assert.assertTrue(set.contains(obj));
	}

	private HashCodeAndEqualsAndComparable generateHashCodeAndEquals(int i,
			String name) {
		HashCodeAndEqualsAndComparable obj = new HashCodeAndEqualsAndComparable();
		obj.setId(i);
		obj.setName(name + "_" + i);
		return obj;
	}
}
