package idv.hsiehpinghan.regexutility.utility;

import java.util.regex.Matcher;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PatternUtilityTest {

	@Test
	public void getMatcher() {
		String string = "[[\"name0\",\"0\"],[\"name1\",\"1\"],[\"name2\",\"2\"]]";
		String regex = "\\[\"(.*?)\",\"(.*?)\"\\]";
		Matcher matcher = PatternUtility.getMatcher(string, regex);
		while (matcher.find()) {
			Assert.assertEquals(matcher.group(1), "name" + matcher.group(2));
		}
	}
}
