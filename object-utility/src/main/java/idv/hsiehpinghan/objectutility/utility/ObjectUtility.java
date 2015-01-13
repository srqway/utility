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
	 * @param parameters
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static Object createInnerClassInstance(Object outerObject,
			Class<?> innerClass, Object... parameters)
			throws NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Class<?>[] clses = getClassArray(outerObject, parameters);
		Constructor<?> ctor = innerClass.getDeclaredConstructor(clses);
		ctor.setAccessible(true);
		Object[] objs = getObjectArray(outerObject, parameters);
		return ctor.newInstance(objs);
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

	/**
	 * Set field value.
	 * 
	 * @param object
	 * @param field
	 * @param value
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static void setField(Object object, Field field, Object value)
			throws IllegalArgumentException, IllegalAccessException {
		field.setAccessible(true);
		field.set(object, value);
	}

	/**
	 * Set field value.
	 * 
	 * @param object
	 * @param fieldName
	 * @param value
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static void setField(Object object, String fieldName, Object value)
			throws IllegalArgumentException, IllegalAccessException {
		Field field = ObjectUtility
				.getFieldByName(object.getClass(), fieldName);
		setField(object, field, value);
	}

	/**
	 * Get field by name.
	 * 
	 * @param clazz
	 * @param fieldName
	 * @return
	 */
	static Field getFieldByName(Class<?> clazz, String fieldName) {
		return FieldUtils.getField(clazz, fieldName, true);
	}

	private static Class<?>[] getClassArray(Object outerObject,
			Object... parameters) {
		int totalSize = 1 + parameters.length;
		Class<?>[] clses = new Class[totalSize];
		clses[0] = outerObject.getClass();
		for (int i = 0, size = parameters.length; i < size; ++i) {
			clses[i + 1] = parameters[i].getClass();
		}
		return clses;
	}

	private static Object[] getObjectArray(Object outerObject,
			Object... parameters) {
		int totalSize = 1 + parameters.length;
		Object[] objs = new Object[totalSize];
		objs[0] = outerObject;
		for (int i = 0, size = parameters.length; i < size; ++i) {
			objs[i + 1] = parameters[i];
		}
		return objs;
	}

}
