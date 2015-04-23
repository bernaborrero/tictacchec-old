package com.deltagames.tictacchec.Model.Pieces;

import com.deltagames.tictacchec.Model.Coordinates;

import java.util.TreeMap;

/**
 * Class to manage a pawn
 * Created by Bernabé Borrero on 23/04/15.
 */
public class Pawn extends Piece {

    /**
     * Basic constructor
     *
     * @param coordinates the initial coordinates of the piece
     * @param color
     */
    public Pawn(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }

    @Override
    public TreeMap<Coordinates, Boolean> getValidMoves() {
        if(getPossibleMoves() == null) {
            // calculate moves


            setPossibleMoves(null);
        }

        return getPossibleMoves();
    }

}
