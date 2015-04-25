package com.deltagames.tictacchec.Model.Pieces;

import com.deltagames.tictacchec.Model.Board;
import com.deltagames.tictacchec.Model.Coordinates;
import com.deltagames.tictacchec.Model.Moves;

import java.util.TreeMap;

/**
 * Class to manage a bishop
 * Created by Bernabé Borrero on 23/04/15.
 */
public class Bishop extends Piece {

    /**
     * Basic constructor
     *
     *
     * @param coordinates the initial coordinates of the piece
     * @param color
     */
    public Bishop(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }

    @Override
    public Moves getValidMoves(Board board) {
        Moves validMoves = super.getValidMoves(board);
        if (validMoves.isEmpty()) {
            // calculate moves
            boolean right = true;
            boolean left = true;

            int x = this.getCoordinates().getX();
            int y = this.getCoordinates().getY();
            for (int i = x; i < 4; i++) {

                if (right) {
                    //check if the cheap is of the same player

                    if (board.get(i, this.getCoordinates().getY()) != null) {
                        horizontal = false;
                    } else {
                        validMoves.add(new Coordinates(i, this.getCoordinates().getY()));
                    }
                }

            }
            horizontal = true;

            for (int i = this.getCoordinates().getX(); i >= 0; i--) {

                if (horizontal) {
                    //check if the cheap is of the same player
                    if (board.get(i, this.getCoordinates().getY()) != null) {
                        horizontal = false;
                    } else {
                        validMoves.add(new Coordinates(i, this.getCoordinates().getY()));
                    }
                }

            }

            for (int i = this.getCoordinates().getY(); i < 4; i++) {

                if (vertical) {
                    //check if the cheap is of the same player
                    if (board.get(this.getCoordinates().getX(), i) != null) {
                        vertical = false;
                    } else {
                        validMoves.add(new Coordinates(this.getCoordinates().getX(), i));
                    }
                }

            }

            vertical = true;
            for (int i = this.getCoordinates().getY(); i >= 0; i--) {

                if (vertical) {
                    //check if the cheap is of the same player
                    if (board.get(this.getCoordinates().getX(), i) != null) {
                        vertical = false;
                    } else {
                        validMoves.add(new Coordinates(this.getCoordinates().getX(), i));
                    }
                }

            }

            setPossibleMoves(validMoves);
        }

        return getPossibleMoves();
    }

}
