package idv.hsiehpinghan.poolutility.utility;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import idv.hsiehpinghan.poolutility.annotation.DoNotReset;
import idv.hsiehpinghan.poolutility.constant.Constant;

public class PoolUtility {

	/**
	 * Reset object's fields. If @DoNotReset used on a field, the field's value
	 * won't be reset, but the fields of field's value will be reset.
	 * 
	 * @param object
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static void reset(Object object) throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field f : fields) {
			Annotation doNotReset = f.getAnnotation(DoNotReset.class);
			Class<?> clazz = f.getType();
			f.setAccessible(true);
			if (clazz == String.class && doNotReset == null) { // Because string
																// often used.
				f.set(object, null);
			} else if (clazz == int.class && doNotReset == null) {
				f.set(object, Constant.INT_DEFAULT_VALUE);
			} else if (clazz == boolean.class && doNotReset == null) {
				f.set(object, Constant.BOOLEAN_DEFAULT_VALUE);
			} else if (clazz == byte.class && doNotReset == null) {
				f.set(object, Constant.BYTE_DEFAULT_VALUE);
			} else if (clazz == char.class && doNotReset == null) {
				f.set(object, Constant.CHAR_DEFAULT_VALUE);
			} else if (clazz == long.class && doNotReset == null) {
				f.set(object, Constant.LONG_DEFAULT_VALUE);
			} else if (clazz == long.class && doNotReset == null) {
				f.set(object, Constant.LONG_DEFAULT_VALUE);
			} else if (clazz == short.class && doNotReset == null) {
				f.set(object, Constant.SHORT_DEFAULT_VALUE);
			} else if (clazz == double.class && doNotReset == null) {
				f.set(object, Constant.DOUBLE_DEFAULT_VALUE);
			} else if (clazz == float.class && doNotReset == null) {
				f.set(object, Constant.FLOAT_DEFAULT_VALUE);
			} else {
				if (doNotReset == null) {
					f.set(object, null);
				} else {
					reset(f);
				}
			}
		}
	}

}
