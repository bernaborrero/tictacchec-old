package com.deltagames.tictacchec.Model.Pieces;

import com.deltagames.tictacchec.Model.Board;
import com.deltagames.tictacchec.Model.Color;
import com.deltagames.tictacchec.Model.Coordinates;
import com.deltagames.tictacchec.Model.Move;
import com.deltagames.tictacchec.Model.Moves;
import com.deltagames.tictacchec.Model.Players.Player;

/**
 * Abstract class to manage a single piece
 * Created by Bernabé Borrero on 23/04/15.
 */
public abstract class Piece {

    private Player player;
    private Coordinates coordinates;
    private Color color;
    private Moves possibleMoves;
    private boolean inBoard;

    /**
     * Basic constructor
     * @param coordinates the initial coordinates of the Piece
     * @param color the Color of the Piece
     */
    public Piece(Player player, Coordinates coordinates, Color color) {
        this.player = player;
        this.coordinates = coordinates;
        this.color = color;
        this.possibleMoves = new Moves();
        this.inBoard = false;
    }

    /**
     * Checks if the piece can move to a given position
     * @param board the current Board
     * @param coordinates the coordinates where the piece wants to be moved
     * @return true if the piece can be moved, false otherwise
     */
    public boolean canMove(Board board, Coordinates coordinates) {
        return getValidMoves(board).hasCoordinateInMoves(coordinates);
    }

    /**
     * Retrieves the possible moves of the piece
     * @param board the current Board
     * @return a TreeMap containing the possible moves
     */
    public Moves getValidMoves(Board board) {
        Moves validMoves = getPossibleMoves();
        if (validMoves.isEmpty() && !isInBoard()) {

            for (int i = 0; i < Board.ROWS; i++) {
                for (int j = 0; j < Board.COLS; j++) {
                    if (board.get(i, j) == null) {
                        Coordinates cords = new Coordinates(i, j);
                        validMoves.add(new Move(this, cords, player.getWeightForCoordinates(cords)));
                    }
                }
            }

            setPossibleMoves(validMoves);
        }

        return getPossibleMoves();
    }

    /**
     * Checks if a piece can kill another piece
     * ATTENTION: this method does not take in consideration the position of the pieces
     * @param piece the victim Piece
     * @return true if this Piece can kill the other one, false otherwise
     */
    protected boolean canOptToKill(Piece piece) {
        return (piece != null && piece.getColor() != getColor());
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        getPlayer().changeWeightForCoordinates(this.getCoordinates(), coordinates);
        this.coordinates = coordinates;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    protected Moves getPossibleMoves() {
        return possibleMoves;
    }

    protected void setPossibleMoves(Moves possibleMoves) {
        this.possibleMoves = possibleMoves;
    }

    public boolean isInBoard() {
        return inBoard;
    }

    public void setInBoard(boolean inBoard) {
        this.inBoard = inBoard;
    }
}
