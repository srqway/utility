package idv.hsiehpinghan.regexutility.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternUtility {

	public static Matcher getMatcher(String string, String regex) {
		Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(string);
	}

}
