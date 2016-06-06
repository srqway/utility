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

	public static String replaceTagAttribute(String html, String tagName, String attributeName, String replaceStr) {
		Pattern pattern = Pattern.compile(
				"(?i)<" + tagName + "[ ]+[a-zA-Z0-9=\"'_ ]*[ ]?" + attributeName + "[ ]?=[ ]?[\"']?([^\"' ]+)[\"']?");
		Matcher matcher = pattern.matcher(html);
		StringBuilder sb = new StringBuilder();
		int startIndex = 0;
		int endIndex = 0;
		while (matcher.find()) {
			int groupCount = matcher.groupCount();
			if (groupCount <= 0) {
				throw new RuntimeException("groupCount(" + groupCount + ") <= 0 !!!");
			}
			endIndex = matcher.start(1);
			sb.append(html.substring(startIndex, endIndex));
			sb.append(replaceStr);
			startIndex = matcher.end(1);
		}
		sb.append(html.substring(startIndex));
		return sb.toString();
	}

	public static String appendTagAttributeDomain(String html, String tagName, String attributeName, String url) {
		Pattern pattern = Pattern.compile(
				"(?i)<" + tagName + "[ ]+[a-zA-Z0-9=\"'_ ]*[ ]?" + attributeName + "[ ]?=[ ]?[\"']?([^\"' ]+)[\"']?");
		Matcher matcher = pattern.matcher(html);
		StringBuilder sb = new StringBuilder();
		int startIndex = 0;
		int endIndex = 0;
		while (matcher.find()) {
			int groupCount = matcher.groupCount();
			if (groupCount <= 0) {
				throw new RuntimeException("groupCount(" + groupCount + ") <= 0 !!!");
			}
			endIndex = matcher.start(1);
			sb.append(html.substring(startIndex, endIndex));
			getAbsoluteUrl(sb, url, matcher.group(1));
			sb.append(matcher.group(1));
			startIndex = matcher.end(1);
		}
		sb.append(html.substring(startIndex));
		return sb.toString();
	}

	private static void getAbsoluteUrl(StringBuilder sb, String url, String attrVal) {
		if (attrVal.startsWith("/")) {
			String host = getHostDomain(url);
			sb.append(host);
			sb.append(attrVal);
		} else {
			String subDomain = getSubDomain(url);
			sb.append(subDomain);
			sb.append("/");
			sb.append(attrVal);
		}
	}

	private static String getHostDomain(String url) {
		int index = url.indexOf("/", 10);
		return url.substring(0, index);
	}

	private static String getSubDomain(String url) {
		int index = url.lastIndexOf("/");
		return url.substring(0, index);
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
