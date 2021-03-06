package idv.hsiehpinghan.poolutility.utility;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import idv.hsiehpinghan.poolutility.constant.Constant;
import idv.hsiehpinghan.poolutility.object.Inner;
import idv.hsiehpinghan.poolutility.object.Outer;

public class PoolUtilityTest {
	private final byte BYTE = 1;
	private final short SHORT = 2;
	private final int INT = 3;
	private final long LONG = 4L;
	private final float FLOAT = 5.5f;
	private final double DOUBLE = 6.6d;
	private final char CHAR = 'c';
	private final boolean BOOLEAN = true;
	private final Object OBJECT = "Object";
	private Inner inner;
	private Inner doNotResetInner;
	private Outer outer;

	@BeforeClass
	public void beforeClass() {
		inner = new Inner(BYTE, SHORT, INT, LONG, FLOAT, DOUBLE, CHAR, BOOLEAN, OBJECT);
		doNotResetInner = new Inner(BYTE, SHORT, INT, LONG, FLOAT, DOUBLE, CHAR, BOOLEAN, OBJECT);
		outer = new Outer(BYTE, SHORT, INT, LONG, FLOAT, DOUBLE, CHAR, BOOLEAN, OBJECT, inner, doNotResetInner);
	}

	@Test
	public void reset() throws IllegalArgumentException, IllegalAccessException {
		// Assert outer
		Assert.assertEquals(outer.get_byte(), BYTE);
		Assert.assertEquals(outer.get_short(), SHORT);
		Assert.assertEquals(outer.get_int(), INT);
		Assert.assertEquals(outer.get_long(), LONG);
		Assert.assertEquals(outer.get_float(), FLOAT);
		Assert.assertEquals(outer.get_double(), DOUBLE);
		Assert.assertEquals(outer.get_char(), CHAR);
		Assert.assertEquals(outer.is_boolean(), BOOLEAN);
		Assert.assertEquals(outer.get_Object(), OBJECT);
		Assert.assertEquals(outer.getInner(), inner);
		// Assert inner
		Assert.assertEquals(inner.get_byte(), BYTE);
		Assert.assertEquals(inner.get_short(), SHORT);
		Assert.assertEquals(inner.get_int(), INT);
		Assert.assertEquals(inner.get_long(), LONG);
		Assert.assertEquals(inner.get_float(), FLOAT);
		Assert.assertEquals(inner.get_double(), DOUBLE);
		Assert.assertEquals(inner.get_char(), CHAR);
		Assert.assertEquals(inner.is_boolean(), BOOLEAN);
		Assert.assertEquals(inner.get_Object(), OBJECT);
		// Assert doNotResetInner
		Assert.assertEquals(doNotResetInner.get_byte(), BYTE);
		Assert.assertEquals(doNotResetInner.get_short(), SHORT);
		Assert.assertEquals(doNotResetInner.get_int(), INT);
		Assert.assertEquals(doNotResetInner.get_long(), LONG);
		Assert.assertEquals(doNotResetInner.get_float(), FLOAT);
		Assert.assertEquals(doNotResetInner.get_double(), DOUBLE);
		Assert.assertEquals(doNotResetInner.get_char(), CHAR);
		Assert.assertEquals(doNotResetInner.is_boolean(), BOOLEAN);
		Assert.assertEquals(doNotResetInner.get_Object(), OBJECT);

		PoolUtility.reset(outer);

		// Assert outer
		Assert.assertEquals(outer.get_byte(), Constant.BYTE_DEFAULT_VALUE);
		Assert.assertEquals(outer.get_short(), Constant.SHORT_DEFAULT_VALUE);
		Assert.assertEquals(outer.get_int(), Constant.INT_DEFAULT_VALUE);
		Assert.assertEquals(outer.get_long(), Constant.LONG_DEFAULT_VALUE);
		Assert.assertEquals(outer.get_float(), Constant.FLOAT_DEFAULT_VALUE);
		Assert.assertEquals(outer.get_double(), Constant.DOUBLE_DEFAULT_VALUE);
		Assert.assertEquals(outer.get_char(), Constant.CHAR_DEFAULT_VALUE);
		Assert.assertEquals(outer.is_boolean(), Constant.BOOLEAN_DEFAULT_VALUE);
		Assert.assertEquals(outer.get_Object(), null);
		Assert.assertNull(outer.getInner());
		// Assert doNotResetInner
		Assert.assertEquals(doNotResetInner.get_byte(), BYTE);
		Assert.assertEquals(doNotResetInner.get_short(), SHORT);
		Assert.assertEquals(doNotResetInner.get_int(), INT);
		Assert.assertEquals(doNotResetInner.get_long(), LONG);
		Assert.assertEquals(doNotResetInner.get_float(), FLOAT);
		Assert.assertEquals(doNotResetInner.get_double(), DOUBLE);
		Assert.assertEquals(doNotResetInner.get_char(), CHAR);
		Assert.assertEquals(doNotResetInner.is_boolean(), BOOLEAN);
		Assert.assertEquals(doNotResetInner.get_Object(), OBJECT);

	}

}
