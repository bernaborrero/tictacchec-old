package com.deltagames.tictacchec.Model.Pieces;

import com.deltagames.tictacchec.Model.Board;
import com.deltagames.tictacchec.Model.Coordinates;
import com.deltagames.tictacchec.Model.Moves;

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
    public Moves getValidMoves(Board board) {
        if(getPossibleMoves() == null) {
            Moves validMoves = super.getValidMoves(board);
            if (validMoves == null) {
                // calculate moves


            }

            setPossibleMoves(null);
        }

        return getPossibleMoves();
    }

}
