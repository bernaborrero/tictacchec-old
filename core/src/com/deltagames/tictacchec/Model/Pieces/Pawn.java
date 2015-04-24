package com.deltagames.tictacchec.Model.Pieces;

import com.deltagames.tictacchec.Model.Board;
import com.deltagames.tictacchec.Model.Coordinates;

import java.util.TreeMap;

/**
 * Class to manage a pawn
 * Created by Bernabé Borrero on 23/04/15.
 */
public class Pawn extends Piece {

    private boolean rightDirection;

    /**
     * Basic constructor
     *
     * @param coordinates the initial coordinates of the piece
     * @param color
     */
    public Pawn(Coordinates coordinates, Color color) {
        super(coordinates, color);

        setRightDirection(coordinates);
    }

    private void setRightDirection(Coordinates coordinates) {
        if(getColor() == Color.WHITE) {
            if (coordinates.getY() == 3) {

            }
        }
    }

    @Override
    public TreeMap<Coordinates, Boolean> getValidMoves(Board board) {
        if(getPossibleMoves() == null) {
            TreeMap<Coordinates, Boolean> validMoves = super.getValidMoves(board);
            if (validMoves == null) {
                // calculate moves


            }

            setPossibleMoves(null);
        }

        return getPossibleMoves();
    }

}
