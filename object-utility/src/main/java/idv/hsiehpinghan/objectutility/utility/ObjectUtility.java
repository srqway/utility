package idv.hsiehpinghan.objectutility.utility;

import idv.hsiehpinghan.datatypeutility.utility.BooleanUtility;
import idv.hsiehpinghan.datatypeutility.utility.ByteUtility;
import idv.hsiehpinghan.datatypeutility.utility.CharacterUtility;
import idv.hsiehpinghan.datatypeutility.utility.DoubleUtility;
import idv.hsiehpinghan.datatypeutility.utility.FloatUtility;
import idv.hsiehpinghan.datatypeutility.utility.IntegerUtility;
import idv.hsiehpinghan.datatypeutility.utility.LongUtility;
import idv.hsiehpinghan.datatypeutility.utility.ShortUtility;
import idv.hsiehpinghan.objectutility.annotation.DoNotReset;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.TypeUtils;

public class ObjectUtility {
	// private Logger logger = Logger.getLogger(this.getClass().getName());

	/**
	 * Reset object's fields. If @DoNotReset used on a field, the field's value
	 * won't be reset, but the fields of field's value will be reset.
	 * 
	 * @param object
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static void reset(Object object) throws IllegalArgumentException,
			IllegalAccessException {
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field f : fields) {
			Annotation doNotReset = f.getAnnotation(DoNotReset.class);
			Class<?> clazz = f.getType();
			f.setAccessible(true);
			if (clazz == String.class && doNotReset == null) { // Because string
																// often used.
				f.set(object, null);
			} else if (clazz == int.class && doNotReset == null) {
				f.set(object, IntegerUtility.INT_DEFAULT_VALUE);
			} else if (clazz == boolean.class && doNotReset == null) {
				f.set(object, BooleanUtility.BOOLEAN_DEFAULT_VALUE);
			} else if (clazz == byte.class && doNotReset == null) {
				f.set(object, ByteUtility.BYTE_DEFAULT_VALUE);
			} else if (clazz == char.class && doNotReset == null) {
				f.set(object, CharacterUtility.CHAR_DEFAULT_VALUE);
			} else if (clazz == long.class && doNotReset == null) {
				f.set(object, LongUtility.LONG_DEFAULT_VALUE);
			} else if (clazz == long.class && doNotReset == null) {
				f.set(object, LongUtility.LONG_DEFAULT_VALUE);
			} else if (clazz == short.class && doNotReset == null) {
				f.set(object, ShortUtility.SHORT_DEFAULT_VALUE);
			} else if (clazz == double.class && doNotReset == null) {
				f.set(object, DoubleUtility.DOUBLE_DEFAULT_VALUE);
			} else if (clazz == float.class && doNotReset == null) {
				f.set(object, FloatUtility.FLOAT_DEFAULT_VALUE);
			} else {
				if (doNotReset == null) {
					f.set(object, null);
				} else {
					reset(f);
				}
			}
		}
	}

	/**
	 * Read field's object. (including superclass field)
	 * 
	 * @param object
	 * @param fieldName
	 * @return
	 * @throws IllegalAccessException
	 */
	public static Object readField(Object object, String fieldName)
			throws IllegalAccessException {
		return FieldUtils.readField(object, fieldName, true);
	}

	/**
	 * Get fields with filterClass(class or interface) type.
	 * 
	 * @param clazz
	 * @param filterClazz
	 * @return
	 */
	public static List<Field> getFieldsByAssignableType(Class<?> clazz,
			Class<?> filterClazz) {
		List<Field> fields = FieldUtils.getAllFieldsList(clazz);
		for (int i = fields.size() - 1; i >= 0; --i) {
			Class<?> cls = fields.get(i).getType();
			if (TypeUtils.isAssignable(cls, filterClazz) == false) {
				fields.remove(i);
			}
		}
		return fields;
	}

	/**
	 * Create inner class instance.
	 * 
	 * @param outerObject
	 * @param innerClass
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static Object createInnerClassInstance(Object outerObject,
			Class<?> innerClass) throws NoSuchMethodException,
			SecurityException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		Constructor<?> ctor = innerClass.getDeclaredConstructor(outerObject
				.getClass());
		return ctor.newInstance(outerObject);
	}

	/**
	 * Get outter object.
	 * 
	 * @param innerObject
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static Object getOuterObject(Object innerObject)
			throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {
		Field field = innerObject.getClass().getDeclaredField("this$0");
		field.setAccessible(true);
		return field.get(innerObject);
	}
}
