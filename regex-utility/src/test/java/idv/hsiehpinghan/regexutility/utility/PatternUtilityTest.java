package idv.hsiehpinghan.regexutility.utility;

import java.util.regex.Matcher;

import org.testng.Assert;

public class PatternUtilityTest {

	// @Test
	public void getMatcher() {
		String string = "[[\"name0\",\"0\"],[\"name1\",\"1\"],[\"name2\",\"2\"]]";
		String regex = "\\[\"(.*?)\",\"(.*?)\"\\]";
		Matcher matcher = PatternUtility.getMatcher(string, regex);
		while (matcher.find()) {
			Assert.assertEquals(matcher.group(1), "name" + matcher.group(2));
		}
	}

	// @Test
	public void caseInsensitive() {
		String string = "<html><ScRiPt>caseInsensitive</sCrIpT></html>";
		String regex = "(?i)(<script)";
		Matcher matcher = PatternUtility.getMatcher(string, regex);
		while (matcher.find()) {
			Assert.assertEquals(matcher.start(), 6);
		}
	}

	// @Test
	public void allowDotMatchNewline() {
		String string = "<style thankid=\"1\">\n" + "@charset \"utf-8\";\n" + "/* CSS Document */\n"
				+ "html{font-size:62.5%;}\n"
				+ "body{ padding:0; margin:0;  font:normal 12px/200% \"宋体\"; color:#000000;text-align:center;font-size:1.2rem;}\n"
				+ "ol,ul,li{list-style:none;}\n" + "em,i{ font-style:normal;} \n" + "/*clear*/\n"
				+ ".top_nav02 dt,.top_nav02 dd{ float:left;}\n"
				+ ".top_nav02 dd{ background:url(/img/MAIN/2014/06/114590/images/pc_nav_01.gif) no-repeat; width:1px; height:40px; overflow:hidden; margin:4px 13px 0;}\n"
				+ ".top_nav02 dt{ height:40px; text-align:center;}\n";
		String regex = "(?s)<style .*url\\(([^()]+)\\)";
		Matcher matcher = PatternUtility.getMatcher(string, regex);
		while (matcher.find()) {
			String str = matcher.group(1);
			Assert.assertEquals(str, "/img/MAIN/2014/06/114590/images/pc_nav_01.gif");
		}
	}

	// @Test
	public void greedyQuantifiers_0() {
		String string = "xxxfooxxxxxxfooxxx";
		String regex = "(x?foo)";
		Matcher matcher = PatternUtility.getMatcher(string, regex);
		int groupIndex = 0;
		while (matcher.find()) {
			printGroups(groupIndex, matcher);
			if (groupIndex == 0) {
				Assert.assertEquals(matcher.group(0), "xfoo");
				Assert.assertEquals(matcher.group(1), "xfoo");
			} else if (groupIndex == 1) {
				Assert.assertEquals(matcher.group(0), "xfoo");
				Assert.assertEquals(matcher.group(1), "xfoo");
			} else {
				throw new RuntimeException("should not be here !!!");
			}
			++groupIndex;
		}
	}

	// @Test
	public void greedyQuantifiers_1() {
		String string = "xxxfooxxxxxxfooxxx";
		String regex = "(x+foo)";
		Matcher matcher = PatternUtility.getMatcher(string, regex);
		int groupIndex = 0;
		while (matcher.find()) {
			printGroups(groupIndex, matcher);
			if (groupIndex == 0) {
				Assert.assertEquals(matcher.group(0), "xxxfoo");
				Assert.assertEquals(matcher.group(1), "xxxfoo");
			} else if (groupIndex == 1) {
				Assert.assertEquals(matcher.group(0), "xxxxxxfoo");
				Assert.assertEquals(matcher.group(1), "xxxxxxfoo");
			} else {
				throw new RuntimeException("should not be here !!!");
			}
			++groupIndex;
		}
	}

	// @Test
	public void greedyQuantifiers_2() {
		String string = "xxxfooxxxxxxfooxxx";
		String regex = "(x*foo)";
		Matcher matcher = PatternUtility.getMatcher(string, regex);
		int groupIndex = 0;
		while (matcher.find()) {
			printGroups(groupIndex, matcher);
			if (groupIndex == 0) {
				Assert.assertEquals(matcher.group(0), "xxxfoo");
				Assert.assertEquals(matcher.group(1), "xxxfoo");
			} else if (groupIndex == 1) {
				Assert.assertEquals(matcher.group(0), "xxxxxxfoo");
				Assert.assertEquals(matcher.group(1), "xxxxxxfoo");
			} else {
				throw new RuntimeException("should not be here !!!");
			}
			++groupIndex;
		}
	}

	// @Test
	public void greedyQuantifiers_3() {
		String string = "xxxfooxxxxxxfooxxx";
		String regex = "(x{5,}foo)";
		Matcher matcher = PatternUtility.getMatcher(string, regex);
		int groupIndex = 0;
		while (matcher.find()) {
			printGroups(groupIndex, matcher);
			if (groupIndex == 0) {
				Assert.assertEquals(matcher.group(0), "xxxxxxfoo");
				Assert.assertEquals(matcher.group(1), "xxxxxxfoo");
			} else {
				throw new RuntimeException("should not be here !!!");
			}
			++groupIndex;
		}
	}

	// @Test
	public void greedyQuantifiers_4() {
		String string = "xxxfooxxxxxxfooxxx";
		String regex = "(x{2,3}foo)";
		Matcher matcher = PatternUtility.getMatcher(string, regex);
		int groupIndex = 0;
		while (matcher.find()) {
			printGroups(groupIndex, matcher);
			if (groupIndex == 0) {
				Assert.assertEquals(matcher.group(0), "xxxfoo");
				Assert.assertEquals(matcher.group(1), "xxxfoo");
			} else if (groupIndex == 1) {
				Assert.assertEquals(matcher.group(0), "xxxfoo");
				Assert.assertEquals(matcher.group(1), "xxxfoo");
			} else {
				throw new RuntimeException("should not be here !!!");
			}
			++groupIndex;
		}
	}

	// @Test
	public void greedyQuantifiers_5() {
		String string = "xxxfooxxxxxxfooxxx";
		String regex = "(x{3}foo)";
		Matcher matcher = PatternUtility.getMatcher(string, regex);
		int groupIndex = 0;
		while (matcher.find()) {
			printGroups(groupIndex, matcher);
			if (groupIndex == 0) {
				Assert.assertEquals(matcher.group(0), "xxxfoo");
				Assert.assertEquals(matcher.group(1), "xxxfoo");
			} else if (groupIndex == 1) {
				Assert.assertEquals(matcher.group(0), "xxxfoo");
				Assert.assertEquals(matcher.group(1), "xxxfoo");
			} else {
				throw new RuntimeException("should not be here !!!");
			}
			++groupIndex;
		}
	}

	// @Test
	public void reluctantQuantifiers_0() {
		String string = "xxxfooxxxxxxfooxxx";
		String regex = "(x??foo)";
		Matcher matcher = PatternUtility.getMatcher(string, regex);
		int groupIndex = 0;
		while (matcher.find()) {
			printGroups(groupIndex, matcher);
			if (groupIndex == 0) {
				Assert.assertEquals(matcher.group(0), "xfoo");
				Assert.assertEquals(matcher.group(1), "xfoo");
			} else if (groupIndex == 1) {
				Assert.assertEquals(matcher.group(0), "xfoo");
				Assert.assertEquals(matcher.group(1), "xfoo");
			} else {
				throw new RuntimeException("should not be here !!!");
			}
			++groupIndex;
		}
	}

	// @Test
	public void reluctantQuantifiers_1() {
		String string = "xxxfooxxxxxxfooxxx";
		String regex = "(x+?foo)";
		Matcher matcher = PatternUtility.getMatcher(string, regex);
		int groupIndex = 0;
		while (matcher.find()) {
			printGroups(groupIndex, matcher);
			if (groupIndex == 0) {
				Assert.assertEquals(matcher.group(0), "xxxfoo");
				Assert.assertEquals(matcher.group(1), "xxxfoo");
			} else if (groupIndex == 1) {
				Assert.assertEquals(matcher.group(0), "xxxxxxfoo");
				Assert.assertEquals(matcher.group(1), "xxxxxxfoo");
			} else {
				throw new RuntimeException("should not be here !!!");
			}
			++groupIndex;
		}
	}

	// @Test
	public void reluctantQuantifiers_2() {
		String string = "xxxfooxxxxxxfooxxx";
		String regex = "(x*?foo)";
		Matcher matcher = PatternUtility.getMatcher(string, regex);
		int groupIndex = 0;
		while (matcher.find()) {
			printGroups(groupIndex, matcher);
			if (groupIndex == 0) {
				Assert.assertEquals(matcher.group(0), "xxxfoo");
				Assert.assertEquals(matcher.group(1), "xxxfoo");
			} else {
				Assert.assertEquals(matcher.group(0), "xxxxxxfoo");
				Assert.assertEquals(matcher.group(1), "xxxxxxfoo");
			}
			++groupIndex;
		}
	}

	// @Test
	public void reluctantQuantifiers_3() {
		String string = "xxxfooxxxxxxfooxxx";
		String regex = "(x{5,}?foo)";
		Matcher matcher = PatternUtility.getMatcher(string, regex);
		int groupIndex = 0;
		while (matcher.find()) {
			printGroups(groupIndex, matcher);
			Assert.assertEquals(matcher.group(0), "xxxfooxxxxxxfoo");
			Assert.assertEquals(matcher.group(1), "xxxfooxxxxxxfoo");
			++groupIndex;
		}
	}

	// @Test
	public void reluctantQuantifiers_4() {
		String string = "xxxfooxxxxxxfooxxx";
		String regex = "(x{2,3}?foo)";
		Matcher matcher = PatternUtility.getMatcher(string, regex);
		int groupIndex = 0;
		while (matcher.find()) {
			printGroups(groupIndex, matcher);
			Assert.assertEquals(matcher.group(0), "xxxfoo");
			Assert.assertEquals(matcher.group(1), "xxxfoo");
			++groupIndex;
		}
	}

	// @Test
	public void reluctantQuantifiers_5() {
		String string = "xxxfooxxxxxxfooxxx";
		String regex = "(x{3}?foo)";
		Matcher matcher = PatternUtility.getMatcher(string, regex);
		int groupIndex = 0;
		while (matcher.find()) {
			printGroups(groupIndex, matcher);
			Assert.assertEquals(matcher.group(0), "xxxfoo");
			Assert.assertEquals(matcher.group(1), "xxxfoo");
			++groupIndex;
		}
	}

	// @Test
	public void possessiveQuantifiers_0() {
		String string = "xxxfooxxxxxxfooxxx";
		String regex = "(x?+foo)";
		Matcher matcher = PatternUtility.getMatcher(string, regex);
		int groupIndex = 0;
		while (matcher.find()) {
			printGroups(groupIndex, matcher);
			Assert.assertEquals(matcher.group(0), "xfoo");
			Assert.assertEquals(matcher.group(1), "xfoo");
			++groupIndex;
		}
	}

	// @Test
	public void possessiveQuantifiers_1() {
		String string = "xxxfooxxxxxxfooxxx";
		String regex = "(x++foo)";
		Matcher matcher = PatternUtility.getMatcher(string, regex);
		int groupIndex = 0;
		while (matcher.find()) {
			printGroups(groupIndex, matcher);
			if (groupIndex == 0) {
				Assert.assertEquals(matcher.group(0), "xxxfoo");
				Assert.assertEquals(matcher.group(1), "xxxfoo");
			} else if (groupIndex == 1) {
				Assert.assertEquals(matcher.group(0), "xxxxxxfoo");
				Assert.assertEquals(matcher.group(1), "xxxxxxfoo");
			} else {
				throw new RuntimeException("should not be here !!!");
			}
			++groupIndex;
		}
	}

	// @Test
	public void possessiveQuantifiers_2() {
		String string = "xxxfooxxxxxxfooxxx";
		String regex = "(x*+foo)";
		Matcher matcher = PatternUtility.getMatcher(string, regex);
		int groupIndex = 0;
		while (matcher.find()) {
			printGroups(groupIndex, matcher);
			if (groupIndex == 0) {
				Assert.assertEquals(matcher.group(0), "xxxfoo");
				Assert.assertEquals(matcher.group(1), "xxxfoo");
			} else if (groupIndex == 1) {
				Assert.assertEquals(matcher.group(0), "xxxxxxfoo");
				Assert.assertEquals(matcher.group(1), "xxxxxxfoo");
			} else {
				throw new RuntimeException("should not be here !!!");
			}
			++groupIndex;
		}
	}

	// @Test
	public void possessiveQuantifiers_3() {
		String string = "xxxfooxxxxxxfooxxx";
		String regex = "(x{5,}+foo)";
		Matcher matcher = PatternUtility.getMatcher(string, regex);
		int groupIndex = 0;
		while (matcher.find()) {
			printGroups(groupIndex, matcher);
			if (groupIndex == 0) {
				Assert.assertEquals(matcher.group(0), "xxxxxxfoo");
				Assert.assertEquals(matcher.group(1), "xxxxxxfoo");
			} else {
				throw new RuntimeException("should not be here !!!");
			}
			++groupIndex;
		}
	}

	// @Test
	public void possessiveQuantifiers_4() {
		String string = "xxxfooxxxxxxfooxxx";
		String regex = "(x{2,3}+foo)";
		Matcher matcher = PatternUtility.getMatcher(string, regex);
		int groupIndex = 0;
		while (matcher.find()) {
			printGroups(groupIndex, matcher);
			if (groupIndex == 0) {
				Assert.assertEquals(matcher.group(0), "xxxfoo");
				Assert.assertEquals(matcher.group(1), "xxxfoo");
			} else if (groupIndex == 1) {
				Assert.assertEquals(matcher.group(0), "xxxfoo");
				Assert.assertEquals(matcher.group(1), "xxxfoo");
			} else {
				throw new RuntimeException("should not be here !!!");
			}
			++groupIndex;
		}
	}

	// @Test
	public void possessiveQuantifiers_5() {
		String string = "xxxfooxxxxxxfooxxx";
		String regex = "(x{3}+foo)";
		Matcher matcher = PatternUtility.getMatcher(string, regex);
		int groupIndex = 0;
		while (matcher.find()) {
			printGroups(groupIndex, matcher);
			if (groupIndex == 0) {
				Assert.assertEquals(matcher.group(0), "xxxfoo");
				Assert.assertEquals(matcher.group(1), "xxxfoo");
			} else if (groupIndex == 1) {
				Assert.assertEquals(matcher.group(0), "xxxfoo");
				Assert.assertEquals(matcher.group(1), "xxxfoo");
			} else {
				throw new RuntimeException("should not be here !!!");
			}
			++groupIndex;
		}
	}

	// @Test
	public void backreference_0() {
		String string = "#Yummm";
		String regex = "([a-zA-Z])\\1+";
		Matcher matcher = PatternUtility.getMatcher(string, regex);
		int groupIndex = 0;
		while (matcher.find()) {
			printGroups(groupIndex, matcher);
			if (groupIndex == 0) {
				Assert.assertEquals(matcher.group(0), "mmm");
				Assert.assertEquals(matcher.group(1), "m");
			} else {
				throw new RuntimeException("should not be here !!!");
			}
			++groupIndex;
		}

	}

	private void printGroups(int groupIndex, Matcher matcher) {
		for (int i = 0, size = matcher.groupCount(); i <= size; ++i) {
			System.err.println(groupIndex + " : " + matcher.group(i));
		}
	}
}
