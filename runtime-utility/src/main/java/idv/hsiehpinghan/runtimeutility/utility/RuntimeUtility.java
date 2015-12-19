package idv.hsiehpinghan.runtimeutility.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuntimeUtility {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(RuntimeUtility.class);

	public static int execute(String command) throws IOException,
			InterruptedException {
		Process process = Runtime.getRuntime().exec(command);
		int returnCode = process.waitFor();
		if (returnCode != 0) {
			throw new RuntimeException("returnCode(" + returnCode + ") != 0");
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				process.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line + System.lineSeparator());
		}
		LOGGER.info(sb.toString());
		return returnCode;
	}
}
