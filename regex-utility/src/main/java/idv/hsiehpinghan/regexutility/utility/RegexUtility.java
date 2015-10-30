package idv.hsiehpinghan.regexutility.utility;

public class RegexUtility {
	private static final String NUMBER_REGEX = "^\\d+(\\.\\d+)?";

	public static boolean isNumberString(String string) {
		return string.matches(NUMBER_REGEX);
	}

}
