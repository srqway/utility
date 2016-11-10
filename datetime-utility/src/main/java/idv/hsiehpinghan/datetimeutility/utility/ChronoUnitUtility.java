package idv.hsiehpinghan.datetimeutility.utility;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class ChronoUnitUtility {
	public static long getDifferentDate(Temporal temporal1Inclusive, Temporal temporal2Exclusive) {
		return ChronoUnit.DAYS.between(temporal1Inclusive, temporal2Exclusive);
	}
}
