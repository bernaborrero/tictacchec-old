package com.deltagames.tictacchec.Model.Pieces;

import com.deltagames.tictacchec.Model.Board;
import com.deltagames.tictacchec.Model.Coordinates;
import com.deltagames.tictacchec.Model.Moves;

/**
 * Class to manage a pawn
 * Created by Bernabé Borrero on 23/04/15.
 */
public class Pawn extends Piece {

    /**
     * Whether the pawn is advancing or receding
     */
    private boolean rightDirection;

    /**
     * Basic constructor
     *
     * @param coordinates the initial coordinates of the piece
     * @param color
     */
    public Pawn(Coordinates coordinates, Color color) {
        super(coordinates, color);

        setInitialRightDirection(coordinates);
    }

    /**
     * Set the initial right direction.
     * ATTENTION: method only valid for calling from constructor
     * @param coordinates the current coordinates of the piece
     */
    private void setInitialRightDirection(Coordinates coordinates) {
        if(getColor() == Color.WHITE) {
            rightDirection = coordinates.getY() != 0;
        } else {
            rightDirection = coordinates.getY() != Board.ROWS - 1;
        }
    }

    @Override
    public Moves getValidMoves(Board board) {
        Moves validMoves = super.getValidMoves(board);
        if (validMoves.isEmpty()) {
            // calculate moves

            if (getColor() == Color.WHITE && isRightDirection() ||
                    getColor() == Color.BLACK && !isRightDirection()) {
                calculateDownToUpMoves(board, validMoves);
            }
            else {
                calculateUpToDownMoves(board, validMoves);
            }

            setPossibleMoves(validMoves);
        }

        return getPossibleMoves();
    }

    /**
     * Calculates the valid Moves for a piece moving down to up on the board
     * @param board the Board
     * @param validMoves the current valid Moves
     */
    private void calculateDownToUpMoves(Board board, Moves validMoves) {
        boolean collision = false;
        Coordinates coordinates = getCoordinates();
        int i = coordinates.getY();

        // straight, down to up
        while (i > 0 && !collision) {
            if (board.get(coordinates.getX(), i) == null) {
                validMoves.add(new Coordinates(coordinates.getX(), i));
            } else {
                collision = true;
            }

            i--;
        }

        // up left kill
        Coordinates upLeftCoordinates = new Coordinates(coordinates.getX() - 1, coordinates.getY() - 1);
        if (board.hasInBounds(upLeftCoordinates) &&
                this.canOptToKill(board.get(upLeftCoordinates))) {
            validMoves.add(upLeftCoordinates);
        }

        // up right kill
        Coordinates upRightCoordinates = new Coordinates(coordinates.getX() + 1, coordinates.getY() -1);
        if (board.hasInBounds(upRightCoordinates) &&
                this.canOptToKill(board.get(upRightCoordinates))) {
            validMoves.add(upRightCoordinates);
        }
    }

    /**
     * Calculates the valid Moves for a piece moving up to down on the board
     * @param board the Board
     * @param validMoves the current valid Moves
     */
    private void calculateUpToDownMoves(Board board, Moves validMoves) {
        boolean collision = false;
        Coordinates coordinates = getCoordinates();
        int i = coordinates.getY();

        // straight, up to down
        while (i < Board.ROWS && !collision) {
            if (board.get(coordinates.getX(), i) == null) {
                validMoves.add(new Coordinates(coordinates.getX(), i));
            } else {
                collision = true;
            }

            i++;
        }

        // down left kill
        Coordinates downLeftCoordinates = new Coordinates(coordinates.getX() - 1, coordinates.getY() + 1);
        if (board.hasInBounds(downLeftCoordinates) &&
                this.canOptToKill(board.get(downLeftCoordinates))) {
            validMoves.add(downLeftCoordinates);
        }

        // down right kill
        Coordinates downRightCoordinates = new Coordinates(coordinates.getX() + 1, coordinates.getY() + 1);
        if (board.hasInBounds(downRightCoordinates) &&
                this.canOptToKill(board.get(downRightCoordinates))) {
            validMoves.add(downRightCoordinates);
        }
    }

    public boolean isRightDirection() {
        return rightDirection;
    }

    public void setRightDirection(boolean rightDirection) {
        this.rightDirection = rightDirection;
    }
}
