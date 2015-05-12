package com.deltagames.tictacchec.Model.Board;

import com.deltagames.tictacchec.Model.Pieces.Piece;

/**
 * Class to store a single Move
 * Created by Bernabé Borrero on 28/04/15.
 */
public class Move implements Comparable{

    private Piece piece;
    private Coordinates coordinates;
    private int weight;


    public Move(Piece piece, Coordinates coordinates, int weight) {
        this.piece = piece;
        this.coordinates = coordinates;
        this.weight = weight;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    @Override
    public int compareTo(Object o) {
        //- petit
        // + superior
        // = 0
        Move other = (Move)o;
        if(piece.compareTo(other.getPiece())>0&&coordinates.compareTo(other.getCoordinates())>0){
            return 1;
        }else if(piece.compareTo(other.getPiece())==0&&coordinates.compareTo(other.getCoordinates())==0){
            return 0;
        }else{
            return -1;
        }

    }
}
