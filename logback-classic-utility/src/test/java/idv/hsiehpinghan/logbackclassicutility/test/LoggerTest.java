package idv.hsiehpinghan.logbackclassicutility.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.testng.annotations.Test;

public class LoggerTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggerTest.class);
	private static final Marker MARKER = MarkerFactory.getMarker("SEND_MAIL_MARKER");
	private static final long ONE_SECOND = 1000;
	private static final int LOOP_AMOUNT = 1;
	private static final String MDC_KEY = "MDC_KEY";

	@Test
	public void basicTest() throws Exception {
		for (int i = 0; i < LOOP_AMOUNT; ++i) {
			LOGGER.trace("trace");
			LOGGER.debug("debug");
			LOGGER.info("info");
			LOGGER.warn("warn");
			LOGGER.error("error");
			Thread.sleep(ONE_SECOND);
		}
	}

	@Test
	public void markerTest() throws Exception {
		for (int i = 0; i < LOOP_AMOUNT; ++i) {
			LOGGER.trace("NO MARKER : trace");
			LOGGER.trace(MARKER, "MARKER : trace");
			LOGGER.debug("NO MARKER : debug");
			LOGGER.debug(MARKER, "MARKER : debug");
			LOGGER.info("NO MARKER : info");
			LOGGER.info(MARKER, "MARKER : info");
			LOGGER.warn("NO MARKER : warn");
			LOGGER.warn(MARKER, "MARKER : warn");
			LOGGER.error("NO MARKER : error");
			LOGGER.error(MARKER, "MARKER : error");
			Thread.sleep(ONE_SECOND);
		}
	}
	
	@Test
	public void mdcTest() throws Exception {
		final Logger LOGGER = LoggerFactory.getLogger(LoggerTest.class);
		for (int i = 0; i < LOOP_AMOUNT; ++i) {
			LOGGER.trace("trace");
			LOGGER.debug("debug");
			LOGGER.info("info");
			LOGGER.warn("warn");
			LOGGER.error("error");
			MDC.put(MDC_KEY, "MDC_VALUE");
			LOGGER.trace("MDC : trace");
			LOGGER.debug("MDC : debug");
			LOGGER.info("MDC : info");
			LOGGER.warn("MDC : warn");
			LOGGER.error("MDC : error");
			Thread.sleep(ONE_SECOND);
		}
	}
}
