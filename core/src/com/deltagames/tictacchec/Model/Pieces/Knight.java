package com.deltagames.tictacchec.Model.Pieces;

import com.deltagames.tictacchec.Model.Coordinates;

import java.util.TreeMap;

/**
 * Class to manage a knight
 * Created by Bernabé Borrero on 23/04/15.
 */
public class Knight extends Piece {

    /**
     * Basic constructor
     *
     * @param coordinates the initial coordinates of the piece
     * @param color
     */
    public Knight(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }

    @Override
    public TreeMap<Coordinates, Boolean> getValidMoves(Piece[][] board) {
        return null;
    }

}
