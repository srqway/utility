package idv.hsiehpinghan.formatutility.utility;

import java.text.NumberFormat;

public class CurrencyFormatUtility {
	private static NumberFormat formatter = NumberFormat.getCurrencyInstance();

	public static String format(double number) {
		return formatter.format(number);
	}

	public static String format(long number) {
		return formatter.format(number);
	}

}
