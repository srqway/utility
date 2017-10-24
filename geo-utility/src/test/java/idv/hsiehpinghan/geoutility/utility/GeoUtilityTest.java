package idv.hsiehpinghan.geoutility.utility;

import org.gavaghan.geodesy.Ellipsoid;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GeoUtilityTest {

	@Test
	public void getDistance() {
		double latitude_0 = 25.06014633460441000000;
		double longitude_0 = 121.61652971070410000000;
		double elevation_0 = 0;
		double latitude_1 = 25.06024071483413000000;
		double longitude_1 = 121.61660380672810000000;
		double elevation_1 = 0;
		Ellipsoid ellipsoid = Ellipsoid.WGS84;
		double distance = GeoUtility.getDistance(latitude_0, longitude_0, elevation_0, latitude_1, longitude_1, elevation_1, ellipsoid);
		Assert.assertEquals(String.valueOf(distance), "12.853008759361398");
	}
}
