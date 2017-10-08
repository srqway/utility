package idv.hsiehpinghan.logbackclassicutility.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class BasicTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(BasicTest.class);

	@Test
	public void logTest() throws Exception {
		LOGGER.trace("trace");
		LOGGER.debug("debug");
		LOGGER.info("info");
		LOGGER.warn("warn");
		LOGGER.error("error");
	}
}
