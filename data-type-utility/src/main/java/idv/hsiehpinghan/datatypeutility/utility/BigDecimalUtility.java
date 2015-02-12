package idv.hsiehpinghan.datatypeutility.utility;

import java.math.BigDecimal;

public class BigDecimalUtility {
	private static final int SCALE = 2;
	private static final int ROUNDING_MODE = BigDecimal.ROUND_HALF_UP;

	public static BigDecimal divide(BigDecimal dividend, BigDecimal divisor) {
		return dividend.divide(divisor, SCALE, ROUNDING_MODE);
	}
}
