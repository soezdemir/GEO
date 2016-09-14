/**
 * @author soezdemir
 * @version 0.01
 * */


import java.util.*;
import java.lang.*;


class RectangleMain{
    private static ArrayList<Point> zPoints = new ArrayList<Point>();


    public static void main (String[] args) {
        start();
    }


    private static void start() {

        double x, y;

        Point a = new Point(4.0, 8.0);
        Point b = new Point(8.0, 6.0);

        System.out.print("\n------------------------------------------------------------------------------"
                + "\n\t\t\t ******** RECTANGLE AREA ********" +
                "\n------------------------------------------------------------------------------\n");

        /**
         Point a = scanPoint(" Point A [x] ==> ", " Point A [y] ==> ");
         Point b = scanPoint(" Point B [x] ==> ", " Point B [y] ==> ");
         */

        System.out.println (" Point A " + a + "\t" +" Point B " + b +
                "\n------------------------------------------------------------------------------");

        try {
            Rectangle object = new Rectangle (a, b);
            Rectangle cloneRec = new Rectangle(	new Point ( a.x - object.getCenterPointX(), a.y - object.getCenterPointY()),
                    new Point ( b.x - object.getCenterPointX(), b.y - object.getCenterPointY()));
            //verschiebt Punkt A und Punkt B über die CenterPoint Koordinaten!
            RectangleCalculation calculator = new RectangleCalculation();

            System.out.print(object); //Aufruf toString-Methode aus der Rectangle Klasse


            calculator.getDiagVector(object);
            calculator.getDistanceBetweenTwoPoints(object);
            calculator.getAngleOfVector(object);
            calculator.getDistanceCenterToPointCB(object);
            calculator.getDistanceCenterToPointAC(object);
            calculator.getDistanceCenterToPointBD(object);
            calculator.getDistanceCenterToPointDA(object);

            System.out.println(calculator);
            System.out.println("\n=============================================================================="
                    + "\n\t\t\t ******  Cloned Rectangle ******"
                    + "\n==============================================================================\n"
                    + cloneRec + calculator ); //Methodenaufruf toString() aus Calculator Klasse

            //TESTAUSGABEN
            /**System.out.println( " CornerPoints => A " + calculator.rectangleCornerPointA(cloneRec)
             + "| B " + calculator.rectangleCornerPointB(cloneRec)
             + "| C " + calculator.rectangleCornerPointC(cloneRec)
             + "| D " + calculator.rectangleCornerPointD(cloneRec)
             + "\n CenterPoint  => " + calculator.rectangleCenterPoint(cloneRec) + "\n");
             */
            //Point newA = new Point ( a.x - object.getCenterPointX(), a.y - object.getCenterPointY());
            //Point newB = new Point ( b.x - object.getCenterPointX(), b.y - object.getCenterPointY());

            //Point cornerPointC  = new Point (cloneRec.getCornerPointCx(), cloneRec.getCornerPointCy());
            //Point cornerPointD  = new Point (cloneRec.getCornerPointDx(), cloneRec.getCornerPointDy());

            /**System.out.println ("\n TESTOUTPUT - Distance between CP and PointCB =====> "
             + object.getDistanceBetweenTwoPoints());
             System.out.println ("\n TESTOUTPUT - Distance between CP and PointCB =====> "
             + object.getDistanceBetweenPointAandPointB());
             System.out.println("\n TESTOUTPUT - Center Point of Area ("
             + object.getCenterPointX() + "/" + object.getCenterPointY() + ")\n");*/


            pointInArea(calculator, object);
            pointInArea(calculator, cloneRec);

        }catch(RuntimeException rte) {
            rte.printStackTrace();
        }

    }

    private static void pointInArea(RectangleCalculation calculator, Rectangle object) {
        String answer;
        Scanner restart = new Scanner(System.in);
        boolean run = true;

        testPoint();
        //testPoints();
        int i = 0;
        Point z = null;

        while(run) {//Wiederholung der Abfrage fuer gesuchte Punkte

            //Point z = scanPoint(" Point Z [x] ==> ", " Point Z [y] ==> ");

            if(i < zPoints.size()){
                z = zPoints.get(i);
                i = i+1;
            }

            /**prueft ob Point Z in GeoArea
             if(object.isPointInArea(z)) {
             System.out.print (" IS in GeoArea! \n");
             if ((z.x == object.getCenterPointX() && z.y == object.getCenterPointY()))
             System.out.print (" Point Z is CenterPoint \n\n");
             }
             else {
             System.out.print (" NOT in GeoArea! \n\n");
             }*/

            //  System.out.println(" Distance between CenterPoint and another Point Z[" + i + "] --> "
            //						+ calculator.getDistanceBetweenCenterPointAndPointZ(object, z));
            //  System.out.println(" Angle of Vector CenterPoint and Point Z[" + i + "] --> "
            //						+ calculator.getAngleOfVectorCenterPointToPointZ(object, z) + "°\n");
            //  System.out.println("\n------------------------------------------------------------------------------");
            //  System.out.println(" CornerPoint A (" + calculator.getXofCornerPointA(object)
            //						+ "|" + calculator.getYofCornerPointA(object) + ") of cloned Rectangle");
            //  System.out.println(" CornerPoint B (" + calculator.getXofCornerPointB(object)
            //						+ "|" + calculator.getYofCornerPointB(object) + ") of cloned Rectangle");
            //

            //  System.out.println(" TEEEESST --- Point A " +	calculator.clonedRectangleCornerPointA(object)
            //						+ " Point B " + calculator.clonedRectangleCornerPointB(object)
            //						+ " Point C " + calculator.clonedRectangleCornerPointC(object)
            //						+ " Point D " + calculator.clonedRectangleCornerPointD(object));
            //	System.out.print (" Point Z[" + i + "]  " + z);
            //	System.out.println(" -|- TESTOUTPUT - Distance between Center Point and Point Z --> "
            //						+ object.getDistanceBetweenCenterPointAndPointZ(z));
            //	System.out.print(" -|- TESTOUTPUT - Minimum of Rectangle Area Equation --> "
            //						+ object.geometricFunctionOfRectangleArea(z));
            //	System.out.println("\n------------------------------------------------------------------------------");


            object.isPointInRectangleArea(object, z);
            System.out.println(" Center Point of Cloned Rectangle ==> " + calculator.rectangleCenterPoint(object));
            System.out.println(" Intersection Point [" + i + "] ==> " + calculator.intersectionOfTwoLines(object, z));
            //	System.out.println(" INTERSECTION POINT = (" + calculator.getIntersectionPointX(object, z) + "|" +calculator.getIntersectionPointY(object, z) + ")");
            System.out.println(" Distance between Point Z and Intersection Point ==> "
                    + calculator.getDistanceZPointToIntersectionPoint(object, z));
            System.out.println(" Distance between CenterPoint and Intersection Point ==> "
                    + calculator.getDistanceCenterPointToIntersectionPoint(object, z));
            System.out.println ("------------------------------------------------------------------------------");
            System.out.print ("\t\t\t\tPress [n] to complete... any key to repeat --> ");

            if((answer = restart.next()).contains("n"))
                run = false;
        }; //end of while(run)

    }

    //Private-Funktion zum Einlesen der Punkte A, B und Punkt Z
    private static Point scanPoint(String xValue, String yValue) {

        Scanner pointscanner = new Scanner(System.in);
        System.out.print(xValue);
        double x = pointscanner.nextDouble();
        System.out.print(yValue);
        double y = pointscanner.nextDouble();

        return new Point (x, y);
    }




    /**
     * Test-Rectangle with following parameters
     * @param Point A (4/2) --> new Point A (-2/-2)
     * @param Point B (8/6) --> new Point B (2/2)
     * @return zPoints Array List
     */
    private static void testPoint () {
        zPoints.add(new Point ( 0.0 , 0.0 ));   // Z1 IS CenterPoint
        zPoints.add(new Point ( 1.0 , 1.0 ));   // Z2 IS in Area
        zPoints.add(new Point ( 1.0 , -1.0 ));  // Z3 IS in Area
        zPoints.add(new Point ( -1.0 , -1.0 )); // Z4 IS in Area
        zPoints.add(new Point ( -1.0 , 1.0 ));  // Z5 IS in Area
        zPoints.add(new Point ( 0.5 , 1.5 ));   // Z6 IS in Area
        zPoints.add(new Point ( -1.0 , 1.5 ));  // Z7 IS in Area
        zPoints.add(new Point ( -1.5 , 1.75 )); // Z8 IS in Area
        zPoints.add(new Point ( -1.5 , 1.5 ));  // Z9 IS in Area
        zPoints.add(new Point ( 2.0 , 2.0 ));   // Z10 IS at the border of Area
        zPoints.add(new Point ( -2.0 , 2.0 ));  // Z11 IS at the border of Area
        zPoints.add(new Point ( -2.0 , -2.0 )); // Z12 IS at the border of Area
        zPoints.add(new Point ( 2.0 , -2.0 ));  // Z13 IS at the border of Area
        zPoints.add(new Point ( -1.5 , 3.0 ));  // Z14 NOT in Area
        zPoints.add(new Point ( -2.0 , 0.5 ));  // Z15 IS at the border of Area
        zPoints.add(new Point ( 0.0 , -3.0 ));  // Z16 NOT in Area
        zPoints.add(new Point ( 0.0 , 3.5 ));   // Z17 NOT in Area
        zPoints.add(new Point ( 2.5 , 0.0 ));   // Z18 NOT in Area
        zPoints.add(new Point ( -2.25 , 0.0 )); // Z19 NOT in Area
        zPoints.add(new Point ( 6.0, 1.0 ));    // Z20 NOT in Area
        zPoints.add(new Point ( -2.0 , -3.0 )); // Z21 NOT in Area
        zPoints.add(new Point ( 4.0 , -3.0 ));  // Z22 NOT in Area
        zPoints.add(new Point ( 3.0 , 3.0 ));   // Z23 NOT in Area
        zPoints.add(new Point ( 3.5 , 4.5 ));   // Z24 NOT in Area (no intersection)
    }

    /**
     private static void testPoints(){
     zPoints.add(new Point (-2.75, 2.75)); //Z1
     zPoints.add(new Point (-2.5, 3.0)); //Z2
     zPoints.add(new Point (-2.5, 2.5)); //Z3
     zPoints.add(new Point (-2.0, 2.25)); //Z4
     zPoints.add(new Point (-1.5, 2.0)); //Z5
     zPoints.add(new Point ( 0.5, 2.5)); //Z6
     zPoints.add(new Point ( 1.0, 1.5)); //Z7
     zPoints.add(new Point ( 1.5, 1.0)); //Z8
     zPoints.add(new Point ( 2.0, 0.5)); //Z9
     zPoints.add(new Point ( 0.0, 1.5)); //Z10
     zPoints.add(new Point ( 0.0, 0.0)); //Z11
     zPoints.add(new Point ( 1.0, -1.5)); //Z12
     zPoints.add(new Point ( -2.0, -1.0)); //Z13
     zPoints.add(new Point ( 3.0, -1.5)); //Z14
     zPoints.add(new Point ( 3.5, -2.0)); //Z15 (no intersection Point)
     zPoints.add(new Point ( 3.5, 0.5)); //Z16 (no intersection Point)
     zPoints.add(new Point ( 1.0, 4.5)); //Z17 (no intersection Point)
     zPoints.add(new Point ( -3.5, 3.5)); //Z18 (no intersection Point)
     zPoints.add(new Point ( 3.5, 5.5)); //Z19 (no intersection Point)
     }
     **/
}

/** //Testwerte zur Ermittlung einer Distanz
 * 	//Abstand zwischen den beiden Punkten betraegt etwa 40.29 Meter
 *  //http://www.gctoolbox.de/ger/tools/Abstand_und_Winkel_zwischen_zwei_Koordinaten_in_Luftlinie/distance.htm
 * 	private static final int LAT_1 = 49245924; //SB - Innovationscampus (Strasse zur fgvt)
 *  private static final int LON_1 = 6935892;
 *
 * 	private static final int LAT_2 = 49245928; //SB - Innovationscampus (Parkplatz vor fgvt)
 *	private static final int LON_2 = 6936447;
 * */