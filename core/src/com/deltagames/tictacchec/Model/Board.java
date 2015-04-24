package com.deltagames.tictacchec.Model;

import com.deltagames.tictacchec.Model.Pieces.Piece;

/**
 * Class to manage the board
 * Created by Bernabé Borrero on 24/04/15.
 */
public class Board {

    public static final int ROWS = 4;
    public static final int COLS = 4;

    private Piece[][] board;

    public Board() {
        board = new Piece[ROWS][COLS];
    }

    public Piece get(int x, int y) {
        return board[x][y];
    }

    public void set(Piece piece, int x, int y) {
        board[x][y] = piece;
    }

}
