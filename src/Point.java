/**
 * @author soezdemir
 * @version 0.01
 *
 * */

public class Point{

    double x, y;
    static int counter = 0;

    public Point (double x, double y){

        this.x = x;
        this.y = y;

        counter ++;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getXofCenterPoint(){
        return this.x = 0.0;
    }

    public double getYofCenterPoint(){
        return this.y = 0.0;
    }

    public String toString(){
        String result = "(" + this.x + "/" + this.y + ")";
        return result;
    }

}
