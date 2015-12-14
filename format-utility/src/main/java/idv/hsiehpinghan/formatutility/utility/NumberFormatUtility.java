package idv.hsiehpinghan.formatutility.utility;

import java.text.NumberFormat;
import java.text.ParseException;

public class NumberFormatUtility {

	private static NumberFormat formatter = NumberFormat.getNumberInstance();

	public static String format(double number) {
		return formatter.format(number);
	}

	public static String format(long number) {
		return formatter.format(number);
	}

	public static Number parse(String string) throws ParseException {
		return formatter.parse(string);
	}

}
