package idv.hsiehpinghan.runtimeutility.utility;

public class CpuUtility {
	public static int getAvailableProcessorAmount() {
		return Runtime.getRuntime().availableProcessors();
	}
}
