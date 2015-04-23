package com.deltagames.tictacchec.Model;

import java.util.TreeMap;

/**
 * Abstract class to manage a single piece
 * Created by Bernabé Borrero on 23/04/15.
 */
public class Piece {

    public enum Color {
        WHITE, BLACK
    }

    /**
     * Coordinates
     */
    private Coordinates coordinates;

    /**
     * Basic constructor
     * @param coordinates the initial coordinates of the piece
     */
    public Piece(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public boolean canMove(int x, int y) {
        return true;
    }

    public TreeMap<Coordinates, Boolean> getPossibleMoves() {

        return null;
    }

    public void move(Piece[][] board) {

    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
