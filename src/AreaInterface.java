/**
 * @author soezdemir
 * @version 0.01
 *
 * */



/** Interface Area mit Methoden
 *  zum ueberpruefen ob ein Punkt
 *  in einer bestimmten Flaeche liegt*/

public interface AreaInterface{

    boolean isInArea(WGS84Point point); /**Mittelpunkt der Flaeche*/

    boolean isInArea(long latitude, long longitude);/**Punkt in einer bestimmten Flaeche*/

    boolean intersectsArea(AreaInterface area);/**Uberschneidung von Flaechen*/

}