package idv.hsiehpinghan.threadutility.utility;

public class ThreadUtility {
	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// Do nothing.
		}
	}
}
