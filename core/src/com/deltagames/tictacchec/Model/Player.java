package com.deltagames.tictacchec.Model;

/**
 * This class helps to handle a single player
 */
    public class Player {

    private String color;
    public Player(){

    }

    public boolean hasWon(Cheap[][] board, Coordinates cheapMoved){
        if(cheapMoved.getX()==0){

        }

        return false;
    }


    private boolean checkVertically(Cheap[][] board, Coordinates cheapMoved){
        int i=0;
        boolean valid=true;
        while(i<4&&valid){
            if(board[cheapMoved.getY()][i].get)
                if(valid){
                    i++;
                }
        }
    }
}
