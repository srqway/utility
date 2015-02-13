package idv.hsiehpinghan.datatypeutility.utility;

import java.math.BigDecimal;

import junit.framework.Assert;

import org.testng.annotations.Test;

public class BigDecimalUtilityTest {
	private BigDecimal dividend;
	private BigDecimal divisor;

	@Test
	public void divide() {
		dividend = BigDecimal.TEN;
		divisor = BigDecimal.ONE;
		BigDecimal result = new BigDecimal("10");
		Assert.assertEquals(0, BigDecimalUtility.divide(dividend, divisor)
				.compareTo(result));
	}

	@Test
	public void getNaturalLogarithm() {
		BigDecimal result = new BigDecimal("2.3");
		Assert.assertEquals(0,
				BigDecimalUtility.getNaturalLogarithm(BigDecimal.TEN)
						.compareTo(result));
	}
}
