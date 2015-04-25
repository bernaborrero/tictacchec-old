package com.deltagames.tictacchec.Model.Pieces;

import com.deltagames.tictacchec.Model.Board;
import com.deltagames.tictacchec.Model.Coordinates;
import com.deltagames.tictacchec.Model.Moves;

/**
 * Class to manage a knight
 * Created by Bernabé Borrero on 23/04/15.
 */
public class Knight extends Piece {

    /**
     * Basic constructor
     * @param coordinates the initial coordinates of the Piece
     * @param color the Color of the Piece
     */
    public Knight(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }

    @Override
    public Moves getValidMoves(Board board) {
        Moves validMoves = super.getValidMoves(board);
        if (validMoves.isEmpty()) {
            // calculate moves
            Coordinates coordinates = getCoordinates();
            Coordinates movingCoordinates = new Coordinates();
            int[][] toMoveCoordinates = {
                    {coordinates.getX() - 1, coordinates.getY() - 2},   // up two, left one
                    {coordinates.getX() + 1, coordinates.getY() - 2},   // up two, right one
                    {coordinates.getX() + 2, coordinates.getY() - 1},   // right two, up one
                    {coordinates.getX() + 2, coordinates.getY() + 1},   // right two, down one
                    {coordinates.getX() + 1, coordinates.getY() + 2},   // down two, right one
                    {coordinates.getX() - 1, coordinates.getY() + 2},   // down two, left one
                    {coordinates.getX() - 2, coordinates.getY() + 1},   // left two, down one
                    {coordinates.getX() - 2, coordinates.getY() - 1},   // left two, up one
            };

            for (int[] pairOfCoordinates : toMoveCoordinates) {
                movingCoordinates.set(pairOfCoordinates[0], pairOfCoordinates[1]);
                if (board.hasInBounds(movingCoordinates) &&
                        this.canOptToKill(board.get(movingCoordinates))) {
                    validMoves.add(movingCoordinates);
                }
            }

            setPossibleMoves(validMoves);
        }

        return getPossibleMoves();
    }

}
