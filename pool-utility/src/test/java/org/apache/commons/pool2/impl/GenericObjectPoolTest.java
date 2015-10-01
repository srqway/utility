package org.apache.commons.pool2.impl;

import idv.hsiehpinghan.poolutility.factory.TestPooledObjectFactory;
import idv.hsiehpinghan.poolutility.object.TestPooledObject;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GenericObjectPoolTest {
	private GenericObjectPool<TestPooledObject> pool;
	private TestPooledObject borrowedobject1;
	private TestPooledObject borrowedobject2;

	@BeforeClass
	public void beforeClass() {
		TestPooledObjectFactory factory = new TestPooledObjectFactory();
		pool = new GenericObjectPool<TestPooledObject>(factory);
	}

	@Test
	public void borrowObject() throws Exception {
		borrowedobject1 = pool.borrowObject();
		Assert.assertNotNull(borrowedobject1);
	}

	@Test(dependsOnMethods = { "borrowObject" })
	public void returnObject() throws Exception {
		pool.returnObject(borrowedobject1);
	}

	@Test(dependsOnMethods = { "returnObject" })
	public void borrowObjectAgain() throws Exception {
		borrowedobject2 = pool.borrowObject();
		Assert.assertTrue(borrowedobject1 == borrowedobject2);
	}
}
