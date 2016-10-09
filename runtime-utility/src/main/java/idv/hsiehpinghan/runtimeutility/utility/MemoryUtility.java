package idv.hsiehpinghan.runtimeutility.utility;

public class MemoryUtility {
	public static final long MB_SIZE = 1024 * 1024;

	public static long getTotalMemory() {
		Runtime runtime = Runtime.getRuntime();
		return runtime.totalMemory();
	}

	public static long getFreeMemory() {
		Runtime runtime = Runtime.getRuntime();
		return runtime.freeMemory();
	}

	public static long maxMemory() {
		Runtime runtime = Runtime.getRuntime();
		return runtime.maxMemory();
	}

	public static long getTotalMemoryInMegaBytes() {
		Runtime runtime = Runtime.getRuntime();
		return runtime.totalMemory() / MB_SIZE;
	}

	public static long getFreeMemoryInMegaBytes() {
		Runtime runtime = Runtime.getRuntime();
		return runtime.freeMemory() / MB_SIZE;
	}

	public static long maxMemoryInMegaBytes() {
		Runtime runtime = Runtime.getRuntime();
		return runtime.maxMemory() / MB_SIZE;
	}
}
