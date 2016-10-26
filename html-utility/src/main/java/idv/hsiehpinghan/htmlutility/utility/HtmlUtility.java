package idv.hsiehpinghan.htmlutility.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlUtility {
	public static String removeComment(String html) {
		return remove(html, "<!--", "-->");
	}

	public static String removeTag(String html, String tagName) {
		return remove(html, "<" + tagName, "</" + tagName + ">");
	}

	public static String replaceMetaContentLanguage(String html, String replaceStr) {
		Pattern pattern = Pattern.compile(
				"<meta [ a-zA-Z0-9=\"'_\\-/;]*[ ]?content=[\"]?([a-zA-Z0-9-]+)[ a-zA-Z0-9=\"'_\\-]*http-equiv=\"Content-Language\">");
		return getReplacedResult(html, pattern, replaceStr);
	}

	public static String replaceMetaCharset(String html, String replaceStr) {
		Pattern pattern = Pattern
				.compile("<meta [ a-zA-Z0-9=\"'_\\-/;]*[ ]?charset=[\"]?([a-zA-Z0-9-]+)[ a-zA-Z0-9=\"'_\\-]*>");
		return getReplacedResult(html, pattern, replaceStr);
	}

	public static String replaceTagAttribute(String html, String tagName, String attributeName, String replaceStr) {
		Pattern pattern = Pattern.compile("(?i)<" + tagName + "[ ]+[a-zA-Z0-9=\"'_ \\-]*[ ]?" + attributeName
				+ "[ ]?=[ ]?[\"']?([^\"' ]+)[\"']?");
		return getReplacedResult(html, pattern, replaceStr);
	}

	public static String appendStyleUrlDomain(String html, String url) {
		Pattern pattern = Pattern.compile("(?is)<style[^>]*>([^<]*)</style>");
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
			appendUrlDomain(sb, matcher.group(1), url);
			startIndex = matcher.end(1);
		}
		sb.append(html.substring(startIndex));
		return sb.toString();
	}

	private static void appendUrlDomain(StringBuilder sb, String styleStr, String url) {
		Pattern pattern = Pattern.compile("(?is)url\\(([a-zA-Z0-9/-_\\.]+)\\)");
		Matcher matcher = pattern.matcher(styleStr);
		int startIndex = 0;
		int endIndex = 0;
		while (matcher.find()) {
			int groupCount = matcher.groupCount();
			if (groupCount <= 0) {
				throw new RuntimeException("groupCount(" + groupCount + ") <= 0 !!!");
			}
			endIndex = matcher.start(1);
			sb.append(styleStr.substring(startIndex, endIndex));
			appendAbsoluteUrl(sb, url, matcher.group(1));
			startIndex = matcher.end(1);
		}
		sb.append(styleStr.substring(startIndex));
	}

	public static String appendTagAttributeDomain(String html, String tagName, String attributeName, String url) {
		Pattern pattern = Pattern
				.compile("(?i)<" + tagName + "[ ]+[^>]*[ ]?" + attributeName + "[ ]?=[ ]?[\"']?([^\"' ]+)[\"']?");
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
			appendAbsoluteUrl(sb, url, matcher.group(1));
			startIndex = matcher.end(1);
		}
		sb.append(html.substring(startIndex));
		return sb.toString();
	}

	public static String addStringToTag(String html, String tagName, String string) {
		Pattern pattern = Pattern.compile("(?i)</" + tagName + ">");
		Matcher matcher = pattern.matcher(html);
		StringBuilder sb = new StringBuilder();
		if (matcher.find()) {
			int startIndex = matcher.start(0);
			sb.append(html.substring(0, startIndex));
			sb.append(string);
			sb.append(html.substring(startIndex, html.length()));
		}
		return sb.toString();
	}

	private static void appendAbsoluteUrl(StringBuilder sb, String url, String attrVal) {
		if (attrVal.startsWith("http")) {
			sb.append(attrVal);
		} else if (attrVal.startsWith("/")) {
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
		final int SIZE = html.length();
		StringBuilder sb = new StringBuilder();
		Integer endIndex = 0;
		Integer tempIndex = null;
		while (true) {
			String subHtml = html.substring(endIndex, SIZE);
			tempIndex = getIndex(subHtml, beginStr, false);
			if (tempIndex == null) {
				break;
			} else {
				Integer beginIndex = endIndex + tempIndex;
				sb.append(html.substring(endIndex, beginIndex));
			}
			tempIndex = getIndex(subHtml, endStr, true);
			if (tempIndex == null) {
				throw new RuntimeException("beginStr(" + beginStr + ") has no match endStr(" + endStr + ").");
			} else {
				endIndex = endIndex + tempIndex;
			}
		}
		sb.append(html.substring(endIndex, SIZE));
		return sb.toString();
	}

	private static Integer getIndex(String html, String str, boolean isEndTag) {
		Pattern pattern = Pattern.compile("(?i)(" + str + ")");
		Matcher matcher = pattern.matcher(html);
		if (matcher.find()) {
			if (isEndTag == false) {
				return matcher.start();
			} else {
				return matcher.start() + str.length();
			}
		}
		return null;
	}

	private static String getReplacedResult(String html, Pattern pattern, String replaceStr) {
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
}
