package com.deltagames.tictacchec.Model;

/**
 * Class to store a pair of coordinates
 * Created by Maxi on 23/04/2015.
 */
public class Coordinates implements Comparable {

    /**
     * The x and y coordinates in the board
     */
    private int x;
    private int y;

    /**
     * Default constructor
     */
    public Coordinates() { }

    /**
     * Basic constructor
     * @param x the position in the x axis
     * @param y the position in the y axis
     */
    public Coordinates(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    /**
     * Set the position of the Coordinates
     * @param x the new position in the x axis
     * @param y the new position in the y axis
     */
    public void set(int x, int y) {
        this.x = x;
        this.y = y;
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
