package idv.hsiehpinghan.threadutility.example;

public class DoubleCheckLocking {
	private static DoubleCheckLocking instance = null;

	public static DoubleCheckLocking getInstance() {
		if (instance == null) {
			synchronized (DoubleCheckLocking.class) {
				if (instance == null) {
					instance = new DoubleCheckLocking();
				}
			}
		}
		return instance;
	}
}
