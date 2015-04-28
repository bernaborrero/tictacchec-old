package com.deltagames.tictacchec.Model.Players;


import com.deltagames.tictacchec.Model.Board;
import com.deltagames.tictacchec.Model.Color;
import com.deltagames.tictacchec.Model.Coordinates;

import java.util.concurrent.Semaphore;

/**
 * This class helps to handle a single player
 */
public abstract class Player {

    private Color color;
    private int activePieces;

    /**
     * Current state of the Player's pieces in the board (used by Arnold)
     */
    private int[][] horizontalPositions;
    private int[][] verticalPositions;
    private int[][] diagonalPositions;

    public Player() {
        activePieces = 0;

        horizontalPositions = new int[Board.ROWS][Board.COLS];
        verticalPositions = new int[Board.COLS][Board.ROWS];
        diagonalPositions = new int[Board.DIAGONAL_CELLS][2];
    }

    public void setActivePieces(int activePieces) {
        this.activePieces = activePieces;
    }

    // TODO: move this method to the board
    public boolean hasWon(Board board, Coordinates pieceMoved) {
        if (checkVertically(board, pieceMoved) || checkHorizontal(board, pieceMoved) || checkDiagonal(board, pieceMoved)) {
            return true;
        }

        return false;
    }


    private boolean checkVertically(Board board, Coordinates pieceMoved) {
        int i = 0;
        boolean valid = true;
        if (board != null) {
            while (i < 4 && valid) {
                if (board.get(new Coordinates(pieceMoved.getY(), i)) == null || board.get(new Coordinates(pieceMoved.getY(), i)).getColor() != this.getColor()) {
                    valid = false;
                }
                if (valid) {
                    i++;
                }
            }
        }
        return valid;
    }

    private boolean checkHorizontal(Board board, Coordinates pieceMoved) {
        int i = 0;
        boolean valid = true;
        if (board != null) {
            while (i < 4 && valid) {
                if (board.get(new Coordinates(i, pieceMoved.getX())) == null || board.get(new Coordinates(i, pieceMoved.getX())).getColor() != this.getColor()) {
                    valid = false;
                }
                if (valid) {
                    i++;
                }
            }
        }
        return valid;
    }

    private boolean checkDiagonal(Board board, Coordinates pieceMoved) {
        boolean valid = true;
        int i = 0;

        while (i < 4 && valid) {
            if (board.get(i, i) == null || board.get(i, i).getColor() != this.getColor()) {
                valid = false;
            }
            i++;
        }

        if (!valid) {
            valid = true;
            i = 3;
            while (i >= 0 && valid) {
                if (board.get(i, i) == null || board.get(i, i).getColor() != this.getColor()) {
                    valid = false;
                }
            }
            return valid;
        } else {
            return valid;
        }
    }

    /**
     * Returns a value representing the importance of that move in the current state of the private summing board
     * @param coordinates the Coordinates to check
     * @return the importance of a move from any piece to the specified Coordinates
     */
    public int getWeightForCoordinates(Coordinates coordinates) {
        int weight = getHorizontalWeight(coordinates) + getVerticalWeight(coordinates);

        int diagonalNumber = coordinates.getDiagonalNumber();
        if (diagonalNumber != -1) {
            weight += getDiagonalWeight(diagonalNumber);
        }

        return weight;
    }

    private int getHorizontalWeight(Coordinates coordinates) {
        int sum = 0;

        for (int value : getHorizontalPositions(coordinates.getY())) {
            sum += value;
        }

        return sum;
    }

    private int getVerticalWeight(Coordinates coordinates) {
        int sum = 0;

        for (int value : getVerticalPositions(coordinates.getX())) {
            sum += value;
        }

        return sum;
    }

    private int getDiagonalWeight(int diagonalNumber) {
        int sum = 0;

        for (int value : getDiagonalPositions(diagonalNumber)) {
            sum += value;
        }

        return sum;
    }

    /**
     * Method to handle the movement logic of a Player
     *
     * @param board             the current Board
     * @param blockingSemaphore a Semaphore to control the state of the game
     */
    public abstract void move(Board board, Player enemy, Semaphore blockingSemaphore);


    public Color getColor() {
        return this.color;
    }

    private int[] getHorizontalPositions(int y) {
        return horizontalPositions[y];
    }

    private int[] getVerticalPositions(int x) {
        return verticalPositions[x];
    }

    private int[] getDiagonalPositions(int diagonalNumber) {
        return diagonalPositions[diagonalNumber];
    }
}
