package com.deltagames.tictacchec.Model;

import com.deltagames.tictacchec.Model.Pieces.Piece;

/**
 * Class to manage the board
 * Created by Bernabé Borrero on 24/04/15.
 */
public class Board {

    /**
     * Number of rows and columns of the board
     */
    public static final int ROWS = 4;
    public static final int COLS = 4;

    /**
     * The actual board array
     */
    private Piece[][] board;

    /**
     * Basic constructor
     */
    public Board() {
        board = new Piece[COLS][ROWS];
    }

    /**
     * Returns a piece given its x and y position
     * @param x the position in the x axis
     * @param y the position in the y axis
     * @return the Piece in the specified position, or null if the position is empty
     */
    public Piece get(int x, int y) {
        return board[x][y];
    }

    /**
     * Returns a piece given its coordinates
     * @param coordinates the coordinates of the piece to retrieve
     * @return the Piece in the specified coordinates, or null if position is empty
     */
    public Piece get(Coordinates coordinates) {
        return board[coordinates.getX()][coordinates.getY()];
    }

    /**
     * Changes the position of the piece in the board
     * @param piece the Piece to move
     * @param x the new position in the x axis
     * @param y the new position in the y axis
     */
    public void set(Piece piece, int x, int y) {
        board[x][y] = piece;
        piece.setCoordinates(new Coordinates(x, y));
    }

    /**
     * Changes the position of the piece in the board
     * @param piece the Piece to move
     * @param coordinates the new Coordinates of the piece in the board
     */
    public void set(Piece piece, Coordinates coordinates) {
        board[coordinates.getX()][coordinates.getY()] = piece;
        piece.setCoordinates(coordinates);
    }

    /**
     * Checks if a pair of Coordinates are in the bounds of the board
     * @param coordinates the Coordinates to check
     * @return true if the Coordinates are in bounds of the board, false otherwise
     */
    public boolean hasInBounds(Coordinates coordinates) {
        return (coordinates.getX() >= 0 && coordinates.getX() < Board.COLS &&
                coordinates.getY() >= 0 && coordinates.getY() < Board.ROWS);
    }

}
