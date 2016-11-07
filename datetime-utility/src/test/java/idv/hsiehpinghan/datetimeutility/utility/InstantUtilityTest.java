package idv.hsiehpinghan.datetimeutility.utility;

import java.time.Instant;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InstantUtilityTest {

	@Test
	public void toString_() {
		Instant instant = Instant.parse("2005-11-12T01:02:03Z");
		Assert.assertEquals(instant.toString(), "2005-11-12T01:02:03Z");
	}
}
