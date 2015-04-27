package com.deltagames.tictacchec.Model;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class to store a collection of Coordinates
 * Created by Bernabé Borrero on 24/04/15.
 */
public class Moves implements Iterable {

    /**
     * The actual collection
     */
    private TreeMap<Coordinates, Boolean> moves;

    /**
     * Basic constructor
     */
    public Moves() {
        moves = new TreeMap<Coordinates, Boolean>();
    }

    /**
     * Add a new value to the collection
     * @param coordinates the new coordinates to store
     */
    public void add(Coordinates coordinates) {
        moves.put(coordinates, true);
    }

    /**
     * Checks if the collection contains a pair of coordinates
     * @param coordinates the coordinates to check
     * @return true if the collection contains the coordinates, false otherwise
     */
    public boolean hasMove(Coordinates coordinates) {
        return moves.containsKey(coordinates);
    }

    /**
     * Get the size of the collection
     * @return the size of the collection
     */
    public int size() {
        return moves.size();
    }

    /**
     * Checks if the collection is empty
     * @return true if the collection is empty, false otherwise
     */
    public boolean isEmpty() {
        return moves.isEmpty();
    }

    /**
     * Empties the collection
     */
    public void empty() {
        moves.clear();
    }

    @Override
    public Iterator iterator() {
        return new MovesIterator();
    }

    /**
     * Class to wrap the iterations over the actual collection
     */
    public class MovesIterator implements Iterator {

        private Iterator iterator;

        public MovesIterator() {
            iterator = moves.entrySet().iterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Object next() {
            return ((Map.Entry<Coordinates, Boolean>) iterator.next()).getKey();
        }
    }

}
