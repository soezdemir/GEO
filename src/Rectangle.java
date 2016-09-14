/**
 * @author soezdemir
 * @version 0.01
 *
 * */

public class Rectangle{

    private Point a, b;
    private double length, heigth;
    private int counter = 0;

    /** Factor for calculations of 10th micro-degree to degree
     */
    private static final double TEN_MILLION = 10000000.0;

    /** The radius of the earth in meters.
     */
    private static final double EARTH_RAD = 6371000.8;

    /** Rectangle Constructor
     *  @param Point a, Point b
     * */
    public Rectangle (Point a, Point b){
        if(a == null)
            throw new RuntimeException();

        this.a = a;
        this.b = b;
        counter++;

        length = (b.x - a.x) ;
        heigth = (b.y - a.y) ;
    }


    /** Getter of RectangleArea
     *  @return area
     * */
    public double getArea(){
        return (length * heigth);
    }

    /** Getter of RectangleExtend
     *  @return extend
     * */
    public double getExtend(){
        return (2 * (length + heigth));
    }



    /** Getter for Heigth of Rectangle
     * 	@return	heigth
     * */
    public double getSideA(){
        if (this.heigth < 0)
            return this.heigth = this.heigth * (-1);
        else
            return this.heigth;
    }

    /** Getter for Length of Rectangle
     * 	@return	length
     * */
    public double getSideB(){
        if (this.length < 0)
            return this.length = this.length * (-1);
        else
            return this.length;
    }



    /** Getter for the CenterPoint of a Rectangle
     *  @return Coordinates of the CenterPoint
     * */
    public double getCenterPointX(){
        return ((a.x + b.x) /2);
    }

    public double getCenterPointY(){
        return ((a.y + b.y) /2);
    }

    /** Getter for the CornerPoints of a Rectangle
     *  @return Coordinates of the CornerPoints
     * */

    public double getCornerPointAx(){
        return a.x;
    }

    public double getCornerPointAy(){
        return a.y;
    }

    public double getCornerPointBx(){
        return b.x;
    }

    public double getCornerPointBy(){
        return b.y;
    }

    public double getCornerPointCx(){
        return b.x;
    }

    public double getCornerPointCy(){
        return a.y;
    }

    public double getCornerPointDx(){
        return a.x;
    }

    public double getCornerPointDy(){
        return b.y;
    }

    //ToDoooooo  Getter fuer alle wichtigen Punkte des Rechtecks
    public Point getCenterPoint(){
        return new Point(getCenterPointX(), getCenterPointY());
    }

    public Point getCornerPointA(){
        return new Point (getCornerPointAx(), getCornerPointAy());
    }

    public Point getCornerPointB(){
        return new Point (getCornerPointBx(), getCornerPointBy());
    }

    public Point getCornerPointC(){
        return new Point (getCornerPointCx(), getCornerPointCy());
    }

    public Point getCornerPointD(){
        return new Point (getCornerPointDx(), getCornerPointDy());
    }


    //ToDo______________________________________________________________
    //Mathematisch nicht Korrekt !!!!!
    public Point getVectorPointCB(){
        return new Point(getCornerPointCx(), getCenterPointY());
    }

    public Point getVectorPointBD(){
        return new Point(getCenterPointX(), getCornerPointDy());
    }

    public Point getVectorPointDA(){
        return new Point(getCornerPointDx(), getCenterPointY());
    }

    public Point getVectorPointAC(){
        return new Point(getCenterPointX(), getCornerPointCy());
    }


    /** Geometric function F for a rectangular area
     *	ETSI EN 302 931 V1.0.0 (2010-12)
     *	Geographical Area Definition - Intelligent Transport Systems (ITS)
     *  A Method to determine whether a Point Z is in
     *  the Rectangle Area
     *  value = 1 ---> Point is the center Point
     *  value > 0 ---> Point is in the Area
     *  value = 0 ---> Point at the border of the Area
     *  value < 0 ---> Point is outside of the Area
     * */
    public double geometricFunctionOfRectangleArea(Point a){

        double xValue = a.getX();;
        double yValue = a.getY();;
        double valueOfSideA = Math.abs(getSideA()/2);
        double valueOfSideB = Math.abs(getSideB()/2);
		/*
		if (valueOfSideA < 0){
			valueOfSideA = valueOfSideA * (-1);
		}
		if (valueOfSideB < 0){
			valueOfSideB = valueOfSideB * (-1);
		}
		if (xValue < 0){
			xValue = xValue * (-1);
		}
		if (yValue < 0){
			yValue = yValue * (-1);
		}*/

        double result = Math.min ( 1 - (Math.pow(xValue/valueOfSideA, 2)) ,  1 - (Math.pow(yValue/valueOfSideB, 2)) );

        return result;
    }



    public void isPointInRectangleArea(Rectangle object, Point z) {

        if (object.geometricFunctionOfRectangleArea(z) == 1){
            System.out.print (" Point Z " + z + " IS CENTERPOINT of GeoArea \n");
        }
        else if(object.geometricFunctionOfRectangleArea(z) > 0){
            System.out.print (" Point Z " + z + " IS in GeoArea! \n");
        }
        else if(object.geometricFunctionOfRectangleArea(z) == 0){
            System.out.print (" Point Z " + z + " is at the BORDER of GeoArea! \n");
        }
        else if(object.geometricFunctionOfRectangleArea(z) < 0){
            System.out.print (" Point Z " + z + " is OUTSIDE the GeoArea! \n");
        }
    }


    /** Method to check wether a Point is in the Rectangle Area
     * @return true (Point IS in Area)
     * @return false (Point IS NOT in Area)
     */
    public boolean isPointInArea(Point pointZ) {
        boolean posIntervalX = (pointZ.x >= a.x) && (pointZ.x <= b.x);
        boolean posIntervalY = (pointZ.y >= a.y) && (pointZ.y <= b.y);
        boolean negIntervalX = (pointZ.x <= a.x) && (pointZ.x >= b.x);
        boolean negIntervalY = (pointZ.y <= a.y) && (pointZ.y >= b.y);

        if ( posIntervalX && posIntervalY	//prueft ob Punkt im Quadrant 1
                || negIntervalX && posIntervalY //prueft ob Punkt im Quadrant 2
                || negIntervalX && negIntervalY //prueft ob Punkt im Quadrant 3
                || posIntervalX && negIntervalY	//prueft ob Punkt im Quadrant 4
                ){
            return true;
        }
        return false;
    }

    /**
     * toString Method For The Output Of Rectangle Data
     * */
    @Override
    public final String toString(){ //umgestalten mit String.format --> API
        String result =
                " Side [a] of Rectangle \t\t ==> " + getSideA() + "\n" +
                        " Side [b] of Rectangle \t\t ==> " + getSideB() + "\n" +
                        " Area of Rectangle \t\t ==> " + getArea() + "\n" +
                        " Extend of Rectangle \t\t ==> " + getExtend() + "\n" +
                        " Center Point of Rectangle \t ==> " + getCenterPoint() + "\n" +
                        " Corner Point A \t\t ==> " + getCornerPointA() + "\n" +
                        " Corner Point B \t\t ==> " + getCornerPointB() + "\n" +
                        " Corner Point C \t\t ==> " + getCornerPointC() + "\n" +
                        " Corner Point D \t\t ==> " + getCornerPointD() + "\n" +
                        "------------------------------------------------------------------------------" + "\n" +
                        " Point CB " + getVectorPointCB() +
                        " , Point BD " + getVectorPointBD() +
                        " , Point DA " + getVectorPointDA() +
                        " , Point AC " + getVectorPointAC() + "\n" +
                        "------------------------------------------------------------------------------" + "\n" ;

        return result;
    }
}
