package com.deltagames.tictacchec.Model.Pieces;

import com.deltagames.tictacchec.Model.Board.Board;
import com.deltagames.tictacchec.Model.Board.Coordinates;
import com.deltagames.tictacchec.Model.Players.Player;
import com.deltagames.tictacchec.Model.Utils.Color;

/**
 * Class to manage a rook
 * Created by Bernabé Borrero on 23/04/15.
 */
public class Rook extends LinearPiece {

    private final static String IMAGE_PATH="img/rook.png";

    /**
     * Basic constructor
     *
     * @param coordinates the initial coordinates of the Piece
     * @param color       the Color of the Piece
     */
    public Rook(Player player, Coordinates coordinates, Color color, Board board) {
        super(player, coordinates, color, IMAGE_PATH, board);
        setDirections(new Direction[]{
                Direction.UP, Direction.RIGHT, Direction.DOWN, Direction.LEFT
        });
    }

    @Override
    protected void setDirectionCoordinates(Coordinates movingCoordinates, Direction direction) {
        switch (direction) {
            case UP:
                movingCoordinates.setY(movingCoordinates.getY() - 1);
                break;
            case RIGHT:
                movingCoordinates.setX(movingCoordinates.getX() + 1);
                break;
            case DOWN:
                movingCoordinates.setY(movingCoordinates.getY() + 1);
                break;
            case LEFT:
                movingCoordinates.setX(movingCoordinates.getX() - 1);
                break;
        }
    }
}
