package com.deltagames.tictacchec.Model;

/**
 * Class to store a pair of coordinates
 * Created by Maxi on 23/04/2015.
 */
public class Coordinates implements Comparable {

    private int x;
    private int y;

    public Coordinates(){}

    public Coordinates(int x, int y){
        this.setX(x);
        this.setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int compareTo(Object o) {
        Coordinates coordinates = (Coordinates) o;

        if(coordinates.getY() < getY()) {
            return 1;
        }
        else if(coordinates.getY() > getY()) {
            return -1;
        }
        else {
            if(coordinates.getX() < getX()) {
                return 1;
            }
            else if(coordinates.getX() > getX()) {
                return -1;
            }
        }

        return 0;
    }
}
