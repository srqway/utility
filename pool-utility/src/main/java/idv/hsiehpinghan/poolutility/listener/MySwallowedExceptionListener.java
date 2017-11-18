package idv.hsiehpinghan.poolutility.listener;

import org.apache.commons.pool2.SwallowedExceptionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySwallowedExceptionListener implements SwallowedExceptionListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(MySwallowedExceptionListener.class);

	@Override
	public void onSwallowException(Exception e) {
		LOGGER.error("onSwallowException !!!", e);
	}

}
