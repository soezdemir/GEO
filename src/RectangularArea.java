

/**
 * Created by soezdemir on 14.09.16.
 */
public class RectangularArea implements AreaInterface {


    private WGS84Point centerPoint;
    private WGS84Point pointA, pointB;
    private long toShortSide;
    private long heigth; //SideA
    private long toLongSide;
    private long length; //SideB
    private double azimuthAngle; //AngleOfVector


    /**Konstruktor
     * @param centerPoint
     * @param toShortSide Distanz zur kurzen Seite in Metern
     * @param toLongSide  Distanz zur langen Seite in Metern
     * @param azimuthAngle Azimuthwinkel in Grad
     */
    public RectangularArea (WGS84Point centerPoint, long toShortSide, long toLongSide, double azimuthAngle){
        if(null != centerPoint) {
            this.centerPoint = centerPoint;
        }
        else{
            this.centerPoint = new WGS84Point(0 , 0);
        }
        this.toShortSide = toShortSide;
        this.toLongSide = toLongSide;
        this.azimuthAngle = azimuthAngle;
    }

    /**Getter
     * @return CenterPoint
     * @return Distanz zur kurzen Seite in Meter
     * @return Distanz zur langen Seite in Meter
     */
    public final WGS84Point getCenterPoint(){
        return this.centerPoint;
    }

    public final long getToShortSide(){
        return this.toShortSide;
    }

    public final long getToLongSide(){
        return this.toLongSide;
    }

    public final double getAzimuthAngle(){
        return this.azimuthAngle;
    }

    /**
     * NOT IMPLEMENTED YET!
     * Returns false;
     */
    @Override
    public final boolean isInArea(WGS84Point point) {
        return false;
    }
    /**
     * NOT IMPLEMENTED YET!
     * Returns false;
     */
    @Override
    public final boolean isInArea (long latitude, long longitude){
        //WGS84Point point = new WGS84Point(latitude, longitude);
        return false;
    }
    /**
     * NOT IMPLEMENTED YET!
     * Returns false;
     */
    @Override
    public final boolean intersectsArea(AreaInterface area) throws IllegalArgumentException {
        //MOCK implementation
        return false;
    }


    @Override
    public final String toString() {
        return "RectangularGeoArea [centerPoint=" + this.centerPoint
                + ", toShortSide=" + this.toShortSide + ", toLongSide=" + this.toLongSide
                + ", azimuthAngle=" + this.azimuthAngle + "]";
    }

    /**
     * Constructor for a Rectangle Area
     * @param Point A (xValue | yValue)
     * @param Point B (xValue | yValue)
     */
    public RectangularArea(WGS84Point pointA, WGS84Point pointB){
        this.pointA = pointA;
        this.pointB = pointB;

        length = (pointB.getLatitude() - pointA.getLatitude());
        heigth = (pointB.getLongitude() - pointB.getLongitude());
    }

    /** NEW
     * Getter for the length of the diagonal vector
     * between Point A and Point B
     * @return length of the diagonal vector
     */
    public long getLengthOfDiagonalVector(){
        return (long) (Math.sqrt((Math.pow(length,2)) + (Math.pow(heigth,2))));
    }

    /** NEW
     * Getter for the X-Value of the CenterPoint of a Rectangle
     * @return x coordinate of center point
     */
    public long getCenterPointX(){
        return ((pointA.getLatitude() + pointB.getLatitude())/2);
    }

    /** NEW
     * Getter for the Y-Value of the CenterPoint of a Rectangle
     * @return y coordinate of center point
     */
    public long getCenterPointY(){
        return ((pointA.getLongitude() + pointB.getLongitude())/2);
    }

    /** NEW
     *  Getter for the CenterPoint of Rectangle
     *  @return new WGS84Point as center point of a rectangle
     */
    public WGS84Point getCenterPointOfRectangle(){
        return new WGS84Point(getCenterPointX(),getCenterPointY());
    }

    /** NEW
     *  Getter for the corner point "C" of rectangle
     *  @return x coordinate of point c
     */
    public long getCornerPointCx(){
        return (pointB.getLatitude());
    }

    /** NEW
     *  Getter for the corner point "C" of rectangle
     *  @return y coordinate of point c
     */
    public long getCornerPointCy(){
        return (pointA.getLongitude());
    }

    /** NEW
     *  Getter for the corner point "D" of rectangle
     *  @return x coordinate of point c
     */
    public long getCornerPointDx(){
        return (pointA.getLatitude());
    }

    /** NEW
     *  Getter for the corner point "D" of rectangle
     *  @return y coordinate of point c
     */
    public long getCornerPointDy(){
        return (pointB.getLongitude());
    }


    /** NEW
     *  Getter for distances between CenterPoint
     *  and the MiddlePoints of a Vector
     * 	@return Coordinates of a SideMiddlePoint
     */
    public long getDistanceCenterToPointCB(){
        return (long) Math.sqrt((Math.pow(getCornerPointCx() - getCenterPointX(),2))
                + (Math.pow(getCenterPointY() - getCenterPointY(),2)));
    }

    public long getDistanceCenterToPointBD(){
        return (long) Math.sqrt((Math.pow(getCenterPointX() - getCenterPointX(),2))
                + (Math.pow(getCornerPointDy() - getCenterPointY(),2)));
    }

    public long getDistanceCenterToPointDA(){
        return (long) Math.sqrt((Math.pow(getCornerPointDx() - getCenterPointX(),2))
                + (Math.pow(getCenterPointY() - getCenterPointY(),2)));
    }

    public long getDistanceCenterToPointAC(){
        return (long) Math.sqrt((Math.pow(getCenterPointX() - getCenterPointX(),2))
                + (Math.pow(getCornerPointCy() - getCenterPointY(),2)));

    }

}
