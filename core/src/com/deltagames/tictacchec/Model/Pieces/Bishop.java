package com.deltagames.tictacchec.Model.Pieces;

import com.deltagames.tictacchec.Model.Coordinates;

/**
 * Class to manage a bishop
 * Created by Bernabé Borrero on 23/04/15.
 */
public class Bishop extends LinearPiece {

    /**
     * Basic constructor
     * @param coordinates the initial coordinates of the Piece
     * @param color the Color of the Piece
     */
    public Bishop(Coordinates coordinates, Color color) {
        super(coordinates, color);
        setDirections(new Direction[]{
                Direction.UP_LEFT, Direction.UP_RIGHT, Direction.DOWN_RIGHT, Direction.DOWN_LEFT
        });
    }

    @Override
    protected void setDirectionCoordinates(Coordinates movingCoordinates, Direction direction) {
        switch (direction) {
            case UP_LEFT:
                movingCoordinates.set(movingCoordinates.getX() - 1, movingCoordinates.getY() - 1);
                break;
            case UP_RIGHT:
                movingCoordinates.set(movingCoordinates.getX() + 1, movingCoordinates.getY() - 1);
                break;
            case DOWN_RIGHT:
                movingCoordinates.set(movingCoordinates.getX() + 1, movingCoordinates.getY() + 1);
                break;
            case DOWN_LEFT:
                movingCoordinates.set(movingCoordinates.getX() - 1, movingCoordinates.getY() + 1);
                break;
        }
    }

}
