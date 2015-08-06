package idv.hsiehpinghan.collectionutility.java.util;

import idv.hsiehpinghan.collectionutility.valueobject.HashCodeAndEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayListTest {

	@Test
	public void HashCodeAndEquals() {
		List<HashCodeAndEquals> list = new ArrayList<HashCodeAndEquals>();
		HashCodeAndEquals entity_1 = generateHashCodeAndEquals(1);
		list.add(entity_1);
		HashCodeAndEquals entity_2 = generateHashCodeAndEquals(1);
		Assert.assertTrue(list.contains(entity_2));
	}

	private HashCodeAndEquals generateHashCodeAndEquals(int i) {
		HashCodeAndEquals obj = new HashCodeAndEquals();
		obj.setId(i);
		obj.setName("name_" + i);
		return obj;
	}
}
