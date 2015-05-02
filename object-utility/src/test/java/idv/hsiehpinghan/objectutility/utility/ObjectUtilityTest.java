package idv.hsiehpinghan.objectutility.utility;

import idv.hsiehpinghan.objectutility.interfaces.OuterInterface;
import idv.hsiehpinghan.objectutility.object.FieldTest;
import idv.hsiehpinghan.objectutility.object.InterfaceTest;
import idv.hsiehpinghan.objectutility.object.OuterObj;
import idv.hsiehpinghan.objectutility.object.OuterObj.InnerObj;
import idv.hsiehpinghan.objectutility.object.ReflectionBase;
import idv.hsiehpinghan.objectutility.object.ReflectionSub;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ObjectUtilityTest {

	@Test
	public void readField() throws IllegalAccessException {
		ReflectionSub sub = new ReflectionSub();
		Object rowKey = ObjectUtility.readField(sub, "rowKey");
		Assert.assertSame(sub.getRowKey(), rowKey);
	}

	@Test
	public void getFieldsByType() {
		// Sub-class test
		List<Field> fields = ObjectUtility.getFieldsByAssignableType(
				FieldTest.class, ReflectionBase.class);
		List<String> fNms = convertToFieldNames(fields);
		Assert.assertTrue(fNms.contains("sub"));
		// Interface test
		List<Field> iFields = ObjectUtility.getFieldsByAssignableType(
				FieldTest.class, InterfaceTest.class);
		List<String> ifNms = convertToFieldNames(iFields);
		Assert.assertTrue(ifNms.contains("itf"));
	}

	@Test
	public void getOuterObject() throws NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException {
		OuterObj outer = new OuterObj();
		InnerObj inner = outer.new InnerObj();
		Object ot = ObjectUtility.getOuterObject(inner);
		Assert.assertSame(outer, ot);
	}

	@Test
	public void createInnerClassInstance() throws NoSuchMethodException,
			SecurityException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		OuterObj outerObj = new OuterObj();
		// Test no parameter constructor.
		Object innerObj = ObjectUtility.createInnerClassInstance(outerObj,
				OuterObj.InnerObj.class);
		Assert.assertSame(OuterObj.InnerObj.class, innerObj.getClass());
		// Test parameter constructor.
		Object innerObj2 = ObjectUtility.createInnerClassInstance(outerObj,
				OuterObj.InnerObj.class, outerObj);
		Assert.assertSame(OuterObj.InnerObj.class, innerObj2.getClass());
		// Test interface parameter constructor.
		OuterInterface outerItf = new OuterObj();
		Object innerObj3 = ObjectUtility.createInnerClassInstance(outerItf,
				OuterObj.InnerObj.class, outerItf);
		Assert.assertSame(OuterObj.InnerObj.class, innerObj3.getClass());
	}

	@Test
	public void setField() throws Exception {
		String str = "test";
		Field field = ObjectUtility.getFieldByName(FieldTest.class, "str");
		FieldTest fieldTest = new FieldTest();
		ObjectUtility.setField(fieldTest, field, str);
		Assert.assertEquals(fieldTest.getStr(), str);
	}

	private List<String> convertToFieldNames(List<Field> fields) {
		List<String> fNms = new ArrayList<String>(fields.size());
		for (Field f : fields) {
			fNms.add(f.getName());
		}
		return fNms;
	}

}
