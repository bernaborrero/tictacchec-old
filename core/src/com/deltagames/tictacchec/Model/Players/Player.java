package com.deltagames.tictacchec.Model.Players;


import com.deltagames.tictacchec.Model.Board;
import com.deltagames.tictacchec.Model.Color;
import com.deltagames.tictacchec.Model.Coordinates;

/**
 * This class helps to handle a single player
 */
    public class Player {

    private Color color;
    private int activeCheaps;


    public Player(){
        activeCheaps=0;
    }

    public void setActiveCheaps(int  activeCheaps){
        this.activeCheaps=activeCheaps;
    }

    public boolean hasWon(Board board, Coordinates cheapMoved){
        if(checkVertically(board, cheapMoved)||checkHorizontal(board, cheapMoved)||checkDiagonal(board, cheapMoved)){
            return true;
        }

        return false;
    }


    private boolean checkVertically(Board board, Coordinates cheapMoved){
        int i=0;
        boolean valid=true;
        if(board!=null){
            while(i<4&&valid){
                if(board.get(new Coordinates(cheapMoved.getY(),i))==null || board.get(new Coordinates(cheapMoved.getY(),i)).getColor()!=this.getColor()){
                    valid =false;
                }
                if(valid){
                    i++;
                }
            }
        }
        return valid;
    }

    private boolean checkHorizontal(Board board, Coordinates cheapMoved){
        int i=0;
        boolean valid=true;
        if(board!=null){
            while(i<4&&valid){
                if(board.get(new Coordinates(i,cheapMoved.getX()))==null || board.get(new Coordinates(i,cheapMoved.getX())).getColor()!=this.getColor()){
                    valid =false;
                }
                if(valid){
                    i++;
                }
            }
        }
        return valid;
    }


    private boolean checkDiagonal(Board board, Coordinates cheapMoved){
        boolean valid=true;
        int i=0;

        while(i<4 && valid){
            if(board.get(i,i)==null || board.get(i,i).getColor()!=this.getColor()){
                valid=false;
            }
            i++;
        }

        if(!valid){
            valid=true;
            i=3;
            while(i>=0 && valid){
                if(board.get(i,i)==null ||board.get(i,i).getColor()!=this.getColor()){
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
