package com.deltagames.tictacchec.Model;

import com.deltagames.tictacchec.Model.Pieces.Piece;

/**
 * This class helps to handle a single player
 */
    public class Player {

    public enum Color {
        WHITE, BLACK
    }
    private Color color;
    public Player(){

    }

    public boolean hasWon(Piece[][] board, Coordinates cheapMoved){
        if(checkVertically(board, cheapMoved)||checkHorizontal(board, cheapMoved)||checkDiagonal(board, cheapMoved)){
            return true;
        }

        return false;
    }


    private boolean checkVertically(Piece[][] board, Coordinates cheapMoved){
        int i=0;
        boolean valid=true;
        if(board!=null){
            while(i<4&&valid){
                if(board[cheapMoved.getY()][i]==null || ! board[cheapMoved.getY()][i].getColor().equals(this.getColor())){
                    valid =false;
                }
                if(valid){
                    i++;
                }
            }
        }
        return valid;
    }

    private boolean checkHorizontal(Piece[][] board, Coordinates cheapMoved){
        int i=0;
        boolean valid=true;
        if(board!=null){
            while(i<4&&valid){
                if(board[i][cheapMoved.getX()]==null || ! board[i][cheapMoved.getX()].getColor().equals(this.getColor())){
                    valid =false;
                }
                if(valid){
                    i++;
                }
            }
        }
        return valid;
    }


    private boolean checkDiagonal(Piece[][] board, Coordinates cheapMoved){
        boolean valid=true;
        int i=0;

        while(i<4 && valid){
            if(board[i][i]==null || !board[i][i].getColor().equals(this.getColor())){
                valid=false;
            }
            i++;
        }

        if(!valid){
            valid=true;
            i=3;
            while(i>=0 && valid){
                if(board[i][i]==null ||!board[i][i].getColor().equals(this.getColor())){
                    valid=false;
                }
            }
            return valid;
        }else{
            return valid;
        }
    }


    public Color getColor(){return this.color;}
}
