package com.deltagames.tictacchec.Model;

import java.util.TreeMap;

/**
 * Class to store a collection of Coordinates
 * Created by Bernabé Borrero on 24/04/15.
 */
public class Moves {

    private TreeMap<Coordinates, Boolean> moves;

    public Moves() {
        moves = new TreeMap<>();
    }

    public void add(Coordinates coordinates) {
        moves.put(coordinates, true);
    }



}
