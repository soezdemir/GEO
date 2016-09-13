/**
 * @author soezdemir
 * @version 0.01
 *
 * */



/** Interface Area mit Methoden
 *  zum ueberpruefen ob ein Punkt
 *  in einer bestimmten Flaeche liegt*/

public interface AreaInterface{

    boolean isInRectangleArea(Point point); /**Mittelpunkt der Flaeche*/

    boolean isInRectangleArea(double length, double heigth);/**Punkt in einer bestimmten Flaeche*/

    boolean intersectsRectangle(AreaInterface area);/**Uberschneidung von Flaechen*/

}