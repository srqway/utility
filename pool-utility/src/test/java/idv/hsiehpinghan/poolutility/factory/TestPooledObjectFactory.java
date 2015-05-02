package idv.hsiehpinghan.poolutility.factory;

import idv.hsiehpinghan.poolutility.object.TestPooledObject;
import idv.hsiehpinghan.poolutility.utility.PoolUtility;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class TestPooledObjectFactory extends
		BasePooledObjectFactory<TestPooledObject> {

	@Override
	public TestPooledObject create() throws Exception {
		return new TestPooledObject();
	}

	@Override
	public PooledObject<TestPooledObject> wrap(TestPooledObject object) {
		return new DefaultPooledObject<TestPooledObject>(object);
	}

	@Override
	public void passivateObject(PooledObject<TestPooledObject> pooledObject)
			throws Exception {
		TestPooledObject object = pooledObject.getObject();
		PoolUtility.reset(object);
	}
}
