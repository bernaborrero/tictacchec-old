package com.deltagames.tictacchec.Model.Pieces;

import com.deltagames.tictacchec.Model.Board;
import com.deltagames.tictacchec.Model.Coordinates;
import com.deltagames.tictacchec.Model.Moves;

/**
 * Class to manage a rook
 * Created by Bernabé Borrero on 23/04/15.
 */
public class Rook extends Piece {

    /**
     * Basic constructor
     *
     *
     * @param coordinates the initial coordinates of the piece
     * @param color
     */
    public Rook(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }

    @Override
    public Moves getValidMoves(Board board) {
        Moves validMoves = super.getValidMoves(board);
        if (validMoves.isEmpty()) {
            // calculate moves
            boolean horizontal=true;
            boolean vertical = true;

            for(int i=this.getCoordinates().getX();i<4;i++){

                if(horizontal){
                    //check if the cheap is of the same player

                    if(board.get(i,this.getCoordinates().getY())!=null){
                        horizontal=false;
                    }else{
                        validMoves.add(new Coordinates(i,this.getCoordinates().getY()));
                    }
                }

            }
            horizontal=true;

            for(int i=this.getCoordinates().getX();i>=0;i--){

                if(horizontal){
                    //check if the cheap is of the same player
                    if(board.get(i,this.getCoordinates().getY())!=null){
                        horizontal=false;
                    }else{
                        validMoves.add(new Coordinates(i,this.getCoordinates().getY()));
                    }
                }

            }

            for(int i=this.getCoordinates().getY();i<4;i++){

                if(vertical){
                    //check if the cheap is of the same player
                    if(board.get(this.getCoordinates().getX(),i)!=null){
                        vertical=false;
                    }else{
                        validMoves.add(new Coordinates(this.getCoordinates().getX(),i));
                    }
                }

            }

            vertical = true;
            for(int i=this.getCoordinates().getY();i>=0;i--){

                if(vertical){
                    //check if the cheap is of the same player
                    if(board.get(this.getCoordinates().getX(),i)!=null){
                        vertical=false;
                    }else{
                        validMoves.add(new Coordinates(this.getCoordinates().getX(),i));
                    }
                }

            }

            setPossibleMoves(validMoves);
        }

        return getPossibleMoves();
    }

}
