/**
 * Created by soezdemir on 14.09.16.
 */
import java.io.Serializable;

public class WGS84Point implements Serializable{

    private static final long serialVersionUID = 1L;

    /** Faktor zur Berechnung auf zehntel Mikrograd
     *  10 Millionen
     */
    public static final double SAE_TO_DEGREE = 10000000.0;

    /** Erdradius
     *  6371000.8 (in Metern)
     */
    public static final double EARTH_RAD = 6371000.8;

    private long latitude; //Breitengrad
    private long longitude; //Längengrad


    public WGS84Point(long latitude, long longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }



    /**Konstruktor mit Längen- u. Breitengraddarstellung
     * @param latitudeInDegree (49.62332258)
     * @param longitudeInDegree (6.912214231)
     */
    public WGS84Point(double latitudeInDegree, double longitudeInDegree){
        this(GeoCalculation.degreeToTenthMicroDegree(latitudeInDegree),
                GeoCalculation.degreeToTenthMicroDegree(longitudeInDegree));
    }

    /**Getter
     * @return Breitengrad in zehntel Mikrograd
     */
    public final long getLatitude(){
        return this.latitude;
    }

    /**Getter
     * @return Längengrad in zehntel Mikrograd
     */
    public final long getLongitude(){
        return this.longitude;
    }

    /**Getter
     * @return Breitengrad in Grad
     */
    public final double getLatitudeDegree(){
        return GeoCalculation.tenthMicroDegreeToDegree(this.latitude);
    }

    /**
     * @return Längengrad in Grad
     */
    public final double getLongitudeDegree(){
        return GeoCalculation.tenthMicroDegreeToDegree(this.longitude);
    }

    /**
     * Returns the 10th micro degree value of a given degree value.<br>
     * Deprecated: Use the GeoCalculation-class!
     * @param degree value
     * @return 10th micro degree
     */
    @Deprecated
    public static final long degreeToTenthMicroDegree(double degree){
        return GeoCalculation.degreeToTenthMicroDegree(degree);
    }


    /**
     * Return the degree value of a given 10th micro degree value.<br>
     * Deprecated: Use the GeoCalculation-class!
     * @param tenthMicroDegree value
     * @return degree value
     */
    @Deprecated
    public static final double tenthMicroDegreeToDegree(long tenthMicroDegree){
        return GeoCalculation.tenthMicroDegreeToDegree(tenthMicroDegree);
    }


}
