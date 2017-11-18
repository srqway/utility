package org.apache.commons.pool2.impl;

import org.apache.commons.pool2.SwallowedExceptionListener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import idv.hsiehpinghan.poolutility.factory.TestPooledObjectFactory;
import idv.hsiehpinghan.poolutility.listener.MySwallowedExceptionListener;
import idv.hsiehpinghan.poolutility.object.TestPooledObject;

public class GenericObjectPoolTest {
	private boolean lifo = GenericObjectPoolConfig.DEFAULT_LIFO;
	private long maxWaitMillis = GenericObjectPoolConfig.DEFAULT_MAX_WAIT_MILLIS;
	private long minEvictableIdleTimeMillis = GenericObjectPoolConfig.DEFAULT_MIN_EVICTABLE_IDLE_TIME_MILLIS;
	private long evictorShutdownTimeoutMillis = GenericObjectPoolConfig.DEFAULT_EVICTOR_SHUTDOWN_TIMEOUT_MILLIS;
	private long softMinEvictableIdleTimeMillis = GenericObjectPoolConfig.DEFAULT_SOFT_MIN_EVICTABLE_IDLE_TIME_MILLIS;
	private int numTestsPerEvictionRun = GenericObjectPoolConfig.DEFAULT_NUM_TESTS_PER_EVICTION_RUN;
	private String evictionPolicyClassName = GenericObjectPoolConfig.DEFAULT_EVICTION_POLICY_CLASS_NAME;
	private boolean testOnCreate = GenericObjectPoolConfig.DEFAULT_TEST_ON_CREATE;
	private boolean testOnBorrow = GenericObjectPoolConfig.DEFAULT_TEST_ON_BORROW;
	private boolean testOnReturn = GenericObjectPoolConfig.DEFAULT_TEST_ON_RETURN;
	private boolean testWhileIdle = GenericObjectPoolConfig.DEFAULT_TEST_WHILE_IDLE;
	private long timeBetweenEvictionRunsMillis = GenericObjectPoolConfig.DEFAULT_TIME_BETWEEN_EVICTION_RUNS_MILLIS;
	private boolean blockWhenExhausted = GenericObjectPoolConfig.DEFAULT_BLOCK_WHEN_EXHAUSTED;
	private int maxTotal = GenericObjectPoolConfig.DEFAULT_MAX_TOTAL;
	private int maxIdle = GenericObjectPoolConfig.DEFAULT_MAX_IDLE;
	private int minIdle = GenericObjectPoolConfig.DEFAULT_MIN_IDLE;
	private GenericObjectPool<TestPooledObject> pool;
	private TestPooledObject borrowedobject1;
	private TestPooledObject borrowedobject2;

	@BeforeClass
	public void beforeClass() {
		TestPooledObjectFactory factory = new TestPooledObjectFactory();
		GenericObjectPoolConfig genericObjectPoolConfig = generateGenericObjectPoolConfig();
		pool = new GenericObjectPool<TestPooledObject>(factory, genericObjectPoolConfig);
		SwallowedExceptionListener swallowedExceptionListener = generateSwallowedExceptionListener();
		pool.setSwallowedExceptionListener(swallowedExceptionListener);
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

	private GenericObjectPoolConfig generateGenericObjectPoolConfig() {
		GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
		genericObjectPoolConfig.setLifo(lifo);
		genericObjectPoolConfig.setMaxIdle(maxIdle);
		genericObjectPoolConfig.setMinIdle(minIdle);
		genericObjectPoolConfig.setMaxTotal(maxTotal);
		genericObjectPoolConfig.setMaxWaitMillis(maxWaitMillis);
		genericObjectPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
		genericObjectPoolConfig.setTestOnCreate(testOnCreate);
		genericObjectPoolConfig.setTestOnBorrow(testOnBorrow);
		genericObjectPoolConfig.setTestOnReturn(testOnReturn);
		genericObjectPoolConfig.setTestWhileIdle(testWhileIdle);
		genericObjectPoolConfig.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
		genericObjectPoolConfig.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		genericObjectPoolConfig.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		genericObjectPoolConfig.setSoftMinEvictableIdleTimeMillis(softMinEvictableIdleTimeMillis);
		genericObjectPoolConfig.setEvictionPolicyClassName(evictionPolicyClassName);
		genericObjectPoolConfig.setEvictorShutdownTimeoutMillis(evictorShutdownTimeoutMillis);
		return genericObjectPoolConfig;
	}

	private SwallowedExceptionListener generateSwallowedExceptionListener() {
		SwallowedExceptionListener swallowedExceptionListener = new MySwallowedExceptionListener();
		return swallowedExceptionListener;
	}
}
