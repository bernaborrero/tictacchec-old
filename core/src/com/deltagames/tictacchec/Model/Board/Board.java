package com.deltagames.tictacchec.Model.Board;

import com.badlogic.gdx.Gdx;
import com.deltagames.tictacchec.Model.Pieces.Piece;

/**
 * Class to manage the board
 * Created by Bernabé Borrero on 24/04/15.
 */
public class Board {

    /**
     * Number of rows and columns of the board
     */
    public static final int ROWS = 4;
    public static final int COLS = 4;
    public static final int DIAGONAL_CELLS = 4; // This value is needed for Arnold, and added here for awareness (ROWS & COLS must be equal)

    /**
     * Convenience method for deciding in which diagonal a Piece is
     */
    public enum Diagonal {
        MAIN_DIAGONAL, REVERSED_DIAGONAL, NO_DIAGONAL
    }

    /**
     * The actual board array
     */
    private Piece[][] board;

    /**
     * position of the board in the screen
     */

    private Coordinates initialCoordinates;
    private Coordinates limitCoordinates;

    /**
     * size of each cell in the board
     */
    private int cellWidth;
    private int cellHeight;

    /**
     * Basic constructor
     */
    public Board() {
        board = new Piece[COLS][ROWS];
    }

    public void print(){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(board[i]!=null&&board[i][j]!=null){
                    Gdx.app.log("board info","x: "+i+", y: "+j+", piece: "+board[i][j].getClass().getName());
                }
            }
        }
    }

    public Board(Coordinates initialCoordinates, Coordinates limitCoordinates) {
        this();
        this.initialCoordinates=initialCoordinates;
        this.limitCoordinates=limitCoordinates;
        this.cellWidth = (limitCoordinates.getX() - initialCoordinates.getX()) / 4;
        this.cellHeight = (limitCoordinates.getY() - initialCoordinates.getY()) / 4;
    }

    public int getCellWidth(){
        return cellWidth;
    }

    public int getCellHeight(){
        return cellHeight;
    }

    /**
     * Returns a piece given its x and y position
     *
     * @param x the position in the x axis
     * @param y the position in the y axis
     * @return the Piece in the specified position, or null if the position is empty
     */
    public Piece get(int x, int y) {
        return board[x][y];
    }

    /**
     * Returns a piece given its coordinates
     *
     * @param coordinates the coordinates of the piece to retrieve
     * @return the Piece in the specified coordinates, or null if position is empty
     */
    public Piece get(Coordinates coordinates) {
        return board[coordinates.getX()][coordinates.getY()];
    }

    /**
     * Changes the position of the piece in the board
     *
     * @param piece the Piece to move
     * @param x     the new position in the x axis
     * @param y     the new position in the y axis
     */
    public void set(Piece piece, int x, int y) {
        set(piece, new Coordinates(x, y));
    }


    public void initSet(Piece piece){
        board[piece.getCoordinates().getX()][piece.getCoordinates().getY()] = piece;
    }
    /**
     * Changes the position of the piece in the board
     *
     * @param piece       the Piece to move
     * @param coordinates the new Coordinates of the piece in the board
     */
    public void set(Piece piece, Coordinates coordinates) {
        board[coordinates.getX()][coordinates.getY()] = piece;
        board[piece.getCoordinates().getX()][piece.getCoordinates().getY()] = null;
        piece.setCoordinates(coordinates);
        piece.getPlayer().emptyMoves();
    }

    /**
     * Checks if a pair of Coordinates are in the bounds of the board
     *
     * @param coordinates the Coordinates to check
     * @return true if the Coordinates are in bounds of the board, false otherwise
     */
    public boolean hasInBounds(Coordinates coordinates) {
        return (coordinates.getX() >= 0 && coordinates.getX() < Board.COLS &&
                coordinates.getY() >= 0 && coordinates.getY() < Board.ROWS);
    }

    public Coordinates screenToCoordinates(int screenX, int screenY){
        return new Coordinates(((screenX-initialCoordinates.getX()) / cellWidth), ((screenY-initialCoordinates.getY()) / cellHeight));
    }

    /**
     * get the equivalent screen coordinate of a position in the board
     *
     * @param screenX
     * @param screenY
     * @return The content of the cell in the board
     */
    public Piece coordinatesToPiece(int screenX, int screenY) {
        Gdx.app.log("coordinates To piece","Screen x: "+screenX+", Screen y:"+screenY);
        Gdx.app.log("coordinates To piece","initial y:"+ initialCoordinates.getY());
        Gdx.app.log("coordinates To piece","height: "+cellHeight);

        if (boardIsTouched(screenX, screenY)) {
            Gdx.app.log("boardTouched","true");

            int aux=((screenY-initialCoordinates.getY()) / cellHeight);
            Gdx.app.log("convert",String.valueOf(aux));

            if(aux==0){
                aux=3;
            }else if(aux==1){
                aux=2;
            }else if(aux==2){
                aux=1;
            }else{
                aux=0;
            }
            Gdx.app.log("converted",String.valueOf(aux));
            //Coordinates c =new Coordinates(((screenX-initialCoordinates.getX()) / cellWidth), ((screenY-initialCoordinates.getY()) / cellHeight));
            //Gdx.app.log("board Coordinates","x: "+c.getX()+", y:"+c.getY());
            return get(new Coordinates(((screenX-initialCoordinates.getX()) / cellWidth), aux));
        } else {
            Gdx.app.log("boardTouched","false");
            return null;
        }

    }

    /**
     * Converts a position in the board into Screen coordinate
     * @param boardPosition
     * @return
     */
    public Coordinates convertCoordinatesToScreen(Coordinates boardPosition){
        //Gdx.app.log("result1","x: "+initialCoordinates.getX()+" y: "+initialCoordinates.getY()+" Board: "+ boardPosition.getX() + ", "+boardPosition.getY());
        //Gdx.app.log("result2", "height: "+cellHeight+" width: "+ cellWidth);
        //Gdx.app.log("result3", "height: "+(boardPosition.getX()*cellWidth)+initialCoordinates.getX()+" width: "+ (boardPosition.getY())*cellHeight+initialCoordinates.getY());
        return new Coordinates((boardPosition.getX()*cellWidth)+initialCoordinates.getX(),(boardPosition.getY())*cellHeight+initialCoordinates.getY());
    }

    /**
     * check if the user has touched inside the board limits
     *
     * @param screenX
     * @param screenY
     * @return true if the screen coordinates are between the board coordinates
     */
    private boolean boardIsTouched(int screenX, int screenY) {
        if ((screenX >= initialCoordinates.getX() && screenX <= limitCoordinates.getX()) && (screenY >= initialCoordinates.getY() && screenY <= limitCoordinates.getY())) {
            return true;
        }

        return false;
    }
}
