package com.deltagames.tictacchec.Model;

import java.util.TreeMap;

/**
 * Abstract class to manage a single piece
 * Created by Bernabé Borrero on 23/04/15.
 */
public abstract class Piece {

    /**
     * Enumeration to control the color of the piece
     */
    public enum Color {
        WHITE, BLACK
    }

    private Coordinates coordinates;
    private Color color;

    /**
     * Basic constructor
     * @param coordinates the initial coordinates of the piece
     */
    public Piece(Coordinates coordinates, Color color) {
        this.coordinates = coordinates;
        this.color = color;
    }

    /**
     * Checks if the piece can move to a given position
     * @param coordinates the coordinates where the piece wants to be moved
     * @return true if the piece can be moved, false otherwise
     */
    public boolean canMove(Coordinates coordinates) {
        return true;
    }

    /**
     * Retrieves the possible moves of the piece
     * @return a TreeMap containing the possible moves
     */
    public TreeMap<Coordinates, Boolean> getPossibleMoves() {
        return null;
    }

    /**
     * Move the piece
     * @param board a Piece array containing the position of all the pieces in the board
     */
    public void move(Piece[][] board) {

    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}