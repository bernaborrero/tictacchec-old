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


    public Player() {
        activePieces = 0;
    }

    public void setActivePieces(int activePieces) {
        this.activePieces = activePieces;
    }

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
     * Method to handle the movement logic of a Player
     *
     * @param board             the current Board
     * @param blockingSemaphore a Semaphore to control the state of the game
     */
    public abstract void move(Board board, Player enemy, Semaphore blockingSemaphore);


    public Color getColor() {
        return this.color;
    }
}
