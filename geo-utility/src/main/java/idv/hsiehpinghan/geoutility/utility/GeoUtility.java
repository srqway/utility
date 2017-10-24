package idv.hsiehpinghan.geoutility.utility;

import org.gavaghan.geodesy.Ellipsoid;
import org.gavaghan.geodesy.GeodeticCalculator;
import org.gavaghan.geodesy.GlobalPosition;

public class GeoUtility {
	public static double getDistance(double latitude_0, double longitude_0, double elevation_0, double latitude_1,
			double longitude_1, double elevation_1, Ellipsoid ellipsoid) {
		GeodeticCalculator geoCalc = new GeodeticCalculator();
		GlobalPosition globalPosition_0 = new GlobalPosition(latitude_0, longitude_0, elevation_0);
		GlobalPosition globalPosition_1 = new GlobalPosition(latitude_1, longitude_1, elevation_1);
		double distance = geoCalc.calculateGeodeticCurve(ellipsoid, globalPosition_0, globalPosition_1)
				.getEllipsoidalDistance();
		return distance;
	}
}
