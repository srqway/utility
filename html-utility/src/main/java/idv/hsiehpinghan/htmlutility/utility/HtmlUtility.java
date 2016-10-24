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

	public static String replaceTagAttribute(String html, String tagName, String attributeName, String replaceStr) {
		Pattern pattern = Pattern.compile(
				"(?i)<" + tagName + "[ ]+[a-zA-Z0-9=\"'_ \\-]*[ ]?" + attributeName + "[ ]?=[ ]?[\"']?([^\"' ]+)[\"']?");
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
				"(?i)<" + tagName + "[ ]+[a-zA-Z0-9=\"'_ \\-]*[ ]?" + attributeName + "[ ]?=[ ]?[\"']?([^\"' ]+)[\"']?");
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

	public static String addStringToTag(String html, String tagName, String string) {
		Pattern pattern = Pattern.compile(
				"(?i)</" + tagName +">");
		Matcher matcher = pattern.matcher(html);
		StringBuilder sb = new StringBuilder();
		if(matcher.find()) {
			int startIndex = matcher.start(0);
			sb.append(html.substring(0, startIndex));
			sb.append(string);
			sb.append(html.substring(startIndex, html.length()));
		}
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

}
