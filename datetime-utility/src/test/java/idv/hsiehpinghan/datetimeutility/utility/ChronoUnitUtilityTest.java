package idv.hsiehpinghan.datetimeutility.utility;

import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ChronoUnitUtilityTest {

	@Test
	public void getDifferentDate() {
		int SIZE = 3;
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime after = now.plusDays(SIZE);
		Assert.assertEquals(ChronoUnitUtility.getDifferentDate(now, after), SIZE);
	}
}
