package idv.hsiehpinghan.htmlutility.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlUtility {
	public static String removeComment(String html) {
		return remove(html, "<!--", "-->");
	}

	public static String removeTag(String html, String tagName) {
		return remove(html, "<" + tagName, "</" + tagName + ">");
	}

	private static String remove(String html, String beginStr, String endStr) {
		List<Integer> beginIndexes = getIndexes(html, beginStr, false);
		List<Integer> endIndexes = getIndexes(html, endStr, true);
		if (beginIndexes.size() != endIndexes.size()) {
			throw new RuntimeException("beginIndexes size(" + beginIndexes.size() + ") not equals to endIndexes size("
					+ endIndexes.size() + ").");
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0, size = beginIndexes.size(); i < size; ++i) {
			if (i == 0) {
				sb.append(html.substring(0, beginIndexes.get(i)));
			} else if (i == size) {
				sb.append(html.substring(endIndexes.get(i)));
			} else {
				sb.append(html.substring(endIndexes.get(i - 1), beginIndexes.get(i)));
			}
		}
		return sb.toString();
	}

	private static List<Integer> getIndexes(String html, String str, boolean isEndTag) {
		List<Integer> indexes = new ArrayList<>();
		Pattern pattern = Pattern.compile("(?i)(" + str + ")");
		Matcher matcher = pattern.matcher(html);
		while (matcher.find()) {
			if (isEndTag == false) {
				indexes.add(matcher.start());
			} else {
				indexes.add(matcher.start() + str.length());
			}
		}
		return indexes;
	}
}
