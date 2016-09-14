/**
 * Created by soezdemir on 14.09.16.
 */
public class GeoCalculation {

    private static final String EX_COORD_NULL = "Could not calculate the distance ....!";

    public static final double TEN_MILLION = 10000000.0;

    public static final double EARTH_RAD = 6371000.8;


    public static long degreeToTenthMicroDegree(double degree){
        return (long) (degree * TEN_MILLION);
    }

    public static double tenthMicroDegreeToDegree(long tenthMicroDegree){
        return (double)(tenthMicroDegree / TEN_MILLION);
    }

    /** Berechnet die Distanz zwischen zwei Geographischen Koordinaten in Meter
     *
     * @param point Erster Punkt
     * @param anotherPoint Zweiter Punkt
     * @return positive Distanz in Metern oder 0 wenn beide Punkte identisch sind
     */
    public static double distanceBetweenTwoPoints(WGS84Point point, WGS84Point anotherPoint){
        if(null == point || null == anotherPoint){
            throw new IllegalArgumentException(EX_COORD_NULL);
        }
        double radLon1 = Math.toRadians(point.getLongitude() / TEN_MILLION);
        double radLat1 = Math.toRadians(point.getLatitude() / TEN_MILLION);
        double radLon2 = Math.toRadians(anotherPoint.getLongitude() / TEN_MILLION);
        double radLat2 = Math.toRadians(anotherPoint.getLatitude() / TEN_MILLION);
        double result = Math.acos( Math.cos(radLat1) * Math.cos(radLon1) * Math.cos(radLat2) * Math.cos(radLon2)
                + Math.cos(radLat1) * Math.sin(radLon1) * Math.cos(radLat2) * Math.sin(radLon2)
                + Math.sin(radLat1) * Math.sin(radLat2) )  * EARTH_RAD;
        return result;
    }







}
