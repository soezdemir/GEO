/**
 * @author soezdemir
 * @version 0.01
 *
 * */


public class RectangleCalculation {

    private double diagonalVector = 0.0;
    private double angleDiagonalVector = 0.0;
    private double distanceBetweenTwoPoints = 0.0;
    private double distanceCPtoCB = 0.0;
    private double distanceCPtoBD = 0.0;
    private double distanceCPtoDA = 0.0;
    private double distanceCPtoAC = 0.0;
    private static double distanceCPtoPointZ = 0.0;
    private static double angleOfVector = 0.0;
    private static double intersectionPoint = 0.0;
    private static double x1 = 0.0;
    private static double x2 = 0.0;
    private static double y1 = 0.0;
    private static double y2 = 0.0;
    private static double intersecX = 0.0;
    private static double intersecY = 0.0;
    private static double borderX = 0.0;
    private static double borderY = 0.0;

    /** Standard-Constructor
     *
     * */
    public RectangleCalculation(){}


    /** Methods to determine the coordinates of the corner points
     * from a cloned rectangle
     *  @return x and y coordinate of a corner point
     * */
    public static double getXofCornerPointA(Rectangle object){
        return object.getCornerPointAx() - object.getCenterPointX();
    }

    public static double getYofCornerPointA(Rectangle object){
        return object.getCornerPointAy() - object.getCenterPointY();
    }

    public static double getXofCornerPointB(Rectangle object){
        return object.getCornerPointBx() - object.getCenterPointX();
    }

    public static double getYofCornerPointB(Rectangle object){
        return object.getCornerPointBy() - object.getCenterPointY();
    }

    public static double getXofCornerPointC(Rectangle object){
        return object.getCornerPointBx() - object.getCenterPointX();
    }

    public static double getYofCornerPointC(Rectangle object){
        return object.getCornerPointBy() - object.getCenterPointY();
    }

    public static double getXofCornerPointD(Rectangle object){
        return object.getCornerPointAx() - object.getCenterPointX();
    }

    public static double getYofCornerPointD(Rectangle object){
        return object.getCornerPointAy() - object.getCenterPointY();
    }

    public static double getXofCenterPoint(Rectangle object){
        return object.getCenterPointX() - object.getCenterPointX();
    }

    public static double getYofCenterPoint(Rectangle object){
        return object.getCenterPointY() - object.getCenterPointY();
    }

    /**
     *
     * */
    public static Point rectangleCenterPoint(Rectangle object){
        return new Point (getXofCenterPoint(object), getYofCenterPoint(object));
    }

    public static Point rectangleCornerPointA(Rectangle object){
        return new Point (getXofCornerPointA(object), getYofCornerPointA(object));
    }

    public static Point rectangleCornerPointB(Rectangle object){
        return new Point (getXofCornerPointB(object), getYofCornerPointB(object));
    }

    public static Point rectangleCornerPointC(Rectangle object){
        return new Point (getXofCornerPointC(object), getYofCornerPointC(object));
    }

    public static Point rectangleCornerPointD(Rectangle object){
        return new Point (getXofCornerPointD(object), getYofCornerPointD(object));
    }

    //ToDooooooooooooooooooooooooooooo 	Koordinaten Schnittpunkt X-Achse
    public static double getIntersectionPointX (Rectangle object, Point z){

        double adjacent = Math.abs(object.getCenterPointX() - z.getX()); //Laenge der Ankathete (length) x2 - x1
        double opposite = Math.abs(object.getCenterPointY() - z.getY()); //Laenge der Gegenkathete (heigth) y2 - y1
        double slopeOfVector = opposite/adjacent;   		//Steigungsdreieck bzw. Steigung der Geraden in Dezimal

        double zX = z.getX(); 								//Koordinate X von Z-Point
        double zY = z.getY();								//Koordinate Y von Z-Point

        double x1 = getXofCornerPointB(object);				//Begrenzung der x-Koordinate
        double y1 = getYofCornerPointB(object);				//Begrenzung der y-Koordinate
        double borderX = getXofCornerPointA(object);
        double borderY = getYofCornerPointA(object);

        double intersecX = ( ( object.getCornerPointCy() - zY ) / slopeOfVector ) + zX;
        double intersecY = (slopeOfVector * (object.getCornerPointCy() - zX ) + zY);

        if (intersecX <= x1){
            return intersecX;
        }
        else return x1;
    }


    //ToDooooooooooooooooooooooooooooo 	Koordinaten Schnittpunkt Y-Achse
    public static double getIntersectionPointY (Rectangle object, Point z){

        double adjacent = Math.abs(object.getCenterPointX() - z.getX()); //Laenge der Ankathete (length) x2 - x1
        double opposite = Math.abs(object.getCenterPointY() - z.getY()); //Laenge der Gegenkathete (heigth) y2 - y1
        double slopeOfVector = opposite/adjacent;   		//Steigungsdreieck bzw. Steigung der Geraden in Dezimal

        double zX = z.getX(); 								//Koordinate X von Z-Point
        double zY = z.getY();								//Koordinate Y von Z-Point

        double x1 = getXofCornerPointB(object);				//Begrenzung der x-Koordinate
        double y1 = getYofCornerPointB(object);				//Begrenzung der y-Koordinate
        double borderX = getXofCornerPointA(object);
        double borderY = getYofCornerPointA(object);

        double intersecX = ( ( object.getCornerPointCy() - zY ) / slopeOfVector ) + zX;
        double intersecY = (slopeOfVector * (object.getCornerPointCy() - zX ) + zY);

        if (intersecY <= object.getCornerPointCy()){
            return intersecY;
        }
        else return y1;
    }

    //ToDooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
    public double getDistanceZPointToIntersectionPoint(Rectangle object, Point z){

        double radLat1 = z.getX();
        double radLon1 = z.getY();
        double radLat2 = getIntersectionPointX(object, z);
        double radLon2 = getIntersectionPointY(object, z);

        return distanceBetweenTwoPoints = (Math.sqrt((Math.pow((radLat2 - radLat1),2))
                + (Math.pow((radLon2 - radLon1),2))));
    }

    //ToDooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
    public double getDistanceCenterPointToIntersectionPoint(Rectangle object, Point z){

        double radLat1 = 0.0;//z.getXcenterPoint();
        double radLon1 = 0.0;//z.getYcenterPoint();
        double radLat2 = getIntersectionPointX(object, z);
        double radLon2 = getIntersectionPointY(object, z);

        return distanceBetweenTwoPoints = (Math.sqrt((Math.pow((radLat2 - radLat1),2))
                + (Math.pow((radLon2 - radLon1),2))));
    }



    //ToDoooooooooooooooooooooooooooooooooooo 	Schnittpunkt zweier Geraden - TESTCODE
    public static Point intersectionOfTwoLines (Rectangle object, Point z){

        double adjacent = Math.abs(object.getCenterPointX() - z.getX()); //Laenge der Ankathete (length) x2 - x1
        double opposite = Math.abs(object.getCenterPointY() - z.getY()); //Laenge der Gegenkathete (heigth) y2 - y1
        double slopeOfVector = opposite/adjacent;   		//Steigungsdreieck bzw. Steigung der Geraden in Dezimal

        double zX = z.getX(); 								//Koordinate X von Z-Point
        double zY = z.getY();								//Koordinate Y von Z-Point

        double x1 = getXofCornerPointB(object);				//Begrenzung der x-Koordinate
        double y1 = getYofCornerPointB(object);				//Begrenzung der y-Koordinate
        double borderX = getXofCornerPointA(object);
        double borderY = getYofCornerPointA(object);

        double intersecX = ( ( object.getCornerPointCy() - zY ) / slopeOfVector ) + zX;
        double intersecY = (slopeOfVector * (object.getCornerPointCy() - zX ) + zY);
        //TESTAUSGABE
        //System.out.println("adj.=> "+adjacent+" | opp.=> "+opposite+" | slope=> "+slopeOfVector);

        if (intersecY <= object.getCornerPointCy()){
            return new Point (x1, intersecY);
        }
        if (intersecY > y1){
            return new Point (intersecX, y1);
        }

        //funzt noch net :-|
        if (( zX > x1 && zY > y1 ) || ( zX < borderX && zY > borderY )) {
            System.out.println(" --->>> NO intersection <<<---");
        }
        return null;
    }




    /**
     * Getter for Diagonal Vector of Rectangle
     * @return diagVector
     **/
    public double getDiagVector(Rectangle object){
        return diagonalVector = (Math.sqrt((Math.pow(object.getSideA(),2)) + (Math.pow(object.getSideB(),2))));
    }

    /** Getter Angle of Diagonal Vector Rectangle
     * 	@return	length of diagonal vector
     * */
    public double getAngleOfVector(Rectangle object){
        return angleDiagonalVector = (Math.toDegrees(Math.acos(((object.getSideB()))
                / (Math.sqrt ((Math.pow((object.getSideB()),2))
                + (Math.pow((object.getSideA()),2)))))));
    }



    /** Getter for distances between CenterPoint
     *  and the MiddlePoints of a Vector
     * 	@return Coordinates of a MiddlePoint from
     * 			Length or Height of a Rectangle
     */
    public double getDistanceCenterToPointCB(Rectangle object){
        return distanceCPtoCB = (Math.sqrt((Math.pow(object.getCornerPointCx() - object.getCenterPointX(),2))
                + (Math.pow(object.getCenterPointY() - object.getCenterPointY(),2))));
    }

    public double getDistanceCenterToPointBD(Rectangle object){
        return distanceCPtoBD = (Math.sqrt((Math.pow(object.getCenterPointX() - object.getCenterPointX(),2))
                + (Math.pow(object.getCornerPointDy() - object.getCenterPointY(),2))));
    }

    public double getDistanceCenterToPointDA(Rectangle object){
        return distanceCPtoDA = (Math.sqrt((Math.pow(object.getCornerPointDx() - object.getCenterPointX(),2))
                + (Math.pow(object.getCenterPointY() - object.getCenterPointY(),2))));
    }

    public double getDistanceCenterToPointAC(Rectangle object){
        return distanceCPtoAC = (Math.sqrt((Math.pow(object.getCenterPointX() - object.getCenterPointX(),2))
                + (Math.pow(object.getCornerPointCy() - object.getCenterPointY(),2))));

    }


    /** Getter for the distance between
     *  the CenterPoint and the Point Z
     *  @return distance between two points
     */
    public static double getDistanceBetweenCenterPointAndPointZ (Rectangle object, Point z){

        double radLat1 = object.getCenterPointX();
        double radLon1 = object.getCenterPointY();
        double radLat2 = z.getX();
        double radLon2 = z.getY();

        return distanceCPtoPointZ = (Math.sqrt((Math.pow((radLat2 - radLat1),2)) + (Math.pow((radLon2 - radLon1),2))));
    }




    /** Getter for Angle of Vector between
     *  CenterPoint and Point Z
     * 	@return	Angle of a Vector in Degrees
     * */
    public static double getAngleOfVectorCenterPointToPointZ(Rectangle object, Point z){

        double radLat1 = object.getCenterPointX();
        double radLon1 = object.getCenterPointY();
        double radLat2 = z.getX();
        double radLon2 = z.getY();

        double angleOfVector = (Math.toDegrees(Math.acos(((radLat2 - radLat1))
                / (Math.sqrt ((Math.pow((radLat2 - radLat1),2))
                + (Math.pow((radLon2 - radLon1),2)))))));

        if (((radLat2 < radLat1) && (radLon2 < radLon1))
                || ((radLat2 > radLat1) && (radLon2 < radLon1))
                || ((radLat2 <= radLat1) && (radLon2 < radLon1)))
        {
            double tmp = 180 - angleOfVector;
            angleOfVector = 180 + tmp;
        }

        return angleOfVector;
    }



    //ToDoooooooo	Distanz zwischen zwei berechneten Punkten
    //           	(in diesem Fall CP nach Mittelpunkt von BC)
    //				Rest ist noch zu implementieren!!!!!
    public double getDistanceBetweenTwoPoints (Rectangle object){

        double radLat1 = object.getCenterPointX();
        double radLon1 = object.getCenterPointY();
        double radLat2 = object.getCornerPointCx();
        double radLon2 = object.getCenterPointY();

        return distanceBetweenTwoPoints = (Math.acos( Math.cos(radLat1) * Math.cos(radLon1) * Math.cos(radLat2) * Math.cos(radLon2)
                + Math.cos(radLat1) * Math.sin(radLon1) * Math.cos(radLat2) * Math.sin(radLon2)
                + Math.sin(radLat1) * Math.sin(radLat2) ));
    }





    public String toString(){
        return	" Diagonal Vector of Rectangle\t ==> "+ diagonalVector + "\n" +
                " Angle of Diagonal Vector\t ==> "+ angleDiagonalVector + "° \n" +
                " Distance  CenterPoint -> Point CB\t==> " + distanceCPtoCB + "\n" +
                " Distance  CenterPoint -> Point BD\t==> " + distanceCPtoBD + "\n" +
                " Distance  CenterPoint -> Point DA\t==> " + distanceCPtoDA + "\n" +
                " Distance  CenterPoint -> Point AC\t==> " + distanceCPtoAC + "\n" +
                "------------------------------------------------------------------------------" + "\n";
        //" Centerpoint " + rectangleCenterPoint() +
        //" , Point A " + rectangleCornerPointA() +
        //" , Point B " + rectangleCornerPointB() +
        //" , Point C " + rectangleCornerPointC() +
        //" , Point D " + rectangleCornerPointD(); // +
        //" Distance between CP -> VectorMiddlePoint of [CB] =====> " + distanceBetweenTwoPoints + "\n";
    }
}


/** 		//zur Berechnung mit Längen- u. Breitengraden mit zehntel Micrograd Parametern!
 Latitude in form like (49.62332258)
 Longitude in form like (6.912214231)

 double radLat1 = Math.toRadians(centerpoint.getLatitude() / TEN_MILLION);
 double radLon1 = Math.toRadians(centerpoint.getLongitude() / TEN_MILLION);
 double radLat2 = Math.toRadians(anotherPoint.getLatitude() / TEN_MILLION);
 double radLon2 = Math.toRadians(anotherPoint.getLongitude() / TEN_MILLION);

 double result = Math.acos( Math.cos(radLat1) * Math.cos(radLon1) * Math.cos(radLat2) * Math.cos(radLon2)
 + Math.cos(radLat1) * Math.sin(radLon1) * Math.cos(radLat2) * Math.sin(radLon2)
 + Math.sin(radLat1) * Math.sin(radLat2) )  * EARTH_RAD;
 */
