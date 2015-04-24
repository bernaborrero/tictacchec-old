package com.deltagames.tictacchec.Model.Pieces;

import com.deltagames.tictacchec.Model.Coordinates;

import java.util.TreeMap;

/**
 * Class to manage a bishop
 * Created by Bernabé Borrero on 23/04/15.
 */
public class Bishop extends Piece {

    /**
     * Basic constructor
     *
     * @param coordinates the initial coordinates of the piece
     * @param color
     */
    public Bishop(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }

    @Override
    public TreeMap<Coordinates, Boolean> getValidMoves(Piece[][] board) {
        return null;
    }

}
