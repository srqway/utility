package idv.hsiehpinghan.datatypeutility.utility;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalUtility {
	private static final int PRECISION = 2;
	private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;
	private static final MathContext MATH_CONTEXT = new MathContext(PRECISION,
			ROUNDING_MODE);

	public static final BigDecimal NEGATIVE_ONE = new BigDecimal("-1");
	public static final BigDecimal NEGATIVE_TEN = new BigDecimal("-10");
	public static final BigDecimal ONE_HUNDRED = new BigDecimal("100");

	/**
	 * dividend/divisor.
	 * 
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public static BigDecimal divide(BigDecimal dividend, BigDecimal divisor) {
		if (divisor == null) {
			return null;
		}
		if (dividend == null) {
			return null;
		}
		if (BigDecimal.ZERO.equals(divisor)) {
			return null;
		}
		return dividend.divide(divisor, MATH_CONTEXT);
	}

	/**
	 * ln(dividend/divisor)
	 * 
	 * @param value
	 * @return
	 */
	public static BigDecimal getNaturalLogarithm(BigDecimal value) {
		if (isPositive(value) == false) {
			return null;
		}
		return new BigDecimal(Math.log(value.doubleValue()), MATH_CONTEXT);
	}

	public static boolean isZero(BigDecimal value) {
		return BigDecimal.ZERO.compareTo(value) == 0;
	}

	public static boolean isOne(BigDecimal value) {
		return BigDecimal.ONE.compareTo(value) == 0;
	}

	public static boolean isNegtive(BigDecimal value) {
		return BigDecimal.ZERO.compareTo(value) > 0;
	}

	public static boolean isPositive(BigDecimal value) {
		return BigDecimal.ZERO.compareTo(value) < 0;
	}
}
