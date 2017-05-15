package idv.hsiehpinghan.datatypeutility.utility;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringUtilityTest {

	@Test
	public void removeFourBytesCharacter() {
		String fourBytesCharacterStr = "😍兒童節 Zen😍Fone 3 Max 手機😍";
		String actual = StringUtility.removeFourBytesCharacter(fourBytesCharacterStr, "");
		Assert.assertEquals(actual, "兒童節 ZenFone 3 Max 手機");
	}

	@Test
	public void fullSplit() {
		String string = ",,,a,b,,c,,,,";
		String[] tokens = StringUtility.fullSplit(string, ",");
		Assert.assertEquals(tokens.length, 11);
	}
}
