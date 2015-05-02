package idv.hsiehpinghan.objectutility.utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.TypeUtils;

public class ObjectUtility {
	// private Logger logger = Logger.getLogger(this.getClass().getName());

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
	 * Create class instance.
	 * 
	 * @param clazz
	 * @param parameters
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public static Object createClassInstance(Class<?> clazz,
			Object... parameters) throws InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?>[] clses = getClassArray(parameters);
		Constructor<?> ctor = clazz.getDeclaredConstructor(clses);
		ctor.setAccessible(true);
		Object[] objs = getObjectArray(parameters);
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

	private static Class<?>[] getClassArray(Object... parameters) {
		int size = parameters.length;
		Class<?>[] clses = new Class[size];
		for (int i = 0; i < size; ++i) {
			clses[i] = parameters[i].getClass();
		}
		return clses;
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

	private static Object[] getObjectArray(Object... parameters) {
		int size = parameters.length;
		Object[] objs = new Object[size];
		for (int i = 0; i < size; ++i) {
			objs[i] = parameters[i];
		}
		return objs;
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
