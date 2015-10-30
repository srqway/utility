package idv.hsiehpinghan.formatutility.utility;

import java.text.NumberFormat;

public class PercentFormatUtility {

	private static NumberFormat formatter = NumberFormat.getPercentInstance();

	public static String format(double number) {
		return formatter.format(number);
	}

	public static String format(long number) {
		return formatter.format(number);
	}

}
