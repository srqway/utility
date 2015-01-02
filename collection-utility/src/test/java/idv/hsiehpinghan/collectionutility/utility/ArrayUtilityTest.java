package idv.hsiehpinghan.collectionutility.utility;

import java.util.Objects;

import junit.framework.Assert;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ArrayUtilityTest {

	@BeforeClass
	public void beforeClass() {
	}

	@Test
	public void addAll() {
		byte[] b1 = { 'a', 'b', 'c' };
		byte[] b2 = { '1', '2', '3' };
		byte[] b3 = { 'A', 'B', 'C' };
		byte[] all = addAll(b1, b2, b3);
		byte[] total = ArrayUtility.addAll(b1, b2, b3);
		Assert.assertTrue(Objects.deepEquals(all, total));
	}

	private byte[] addAll(byte[]... byteArrays) {
		byte[] total = {};
		for (byte[] bs : byteArrays) {
			total = ArrayUtils.addAll(total, bs);
		}
		return total;
	}
}
