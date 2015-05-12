package com.deltagames.tictacchec.Listeners;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.deltagames.tictacchec.Model.Board.Board;
import com.deltagames.tictacchec.Model.Board.Coordinates;
import com.deltagames.tictacchec.Model.Board.Moves;
import com.deltagames.tictacchec.Model.Pieces.Piece;
import com.deltagames.tictacchec.Model.Players.Player;

/**
 * Created by Maxi on 27/04/2015.
 */
public class UserInputListener extends InputAdapter {

    private Player player;
    private Board board;
    private Piece previousPiece;
    private Moves possibleMoves;

    public UserInputListener(Player player, Board board){
        this.player=player;
        this.board=board;
    }

    /**
     * control the user interaction with the board
     * @param screenX
     * @param screenY
     * @param pointer
     * @param button
     * @return
     */
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        Piece piece = board.coordinatesToPiece(screenX, screenY);
        if(previousPiece==null){
            checkPreviousPiece(piece);
            if(previousPiece!=null){
                Gdx.app.log("previouspiece","is not null omg, x: "+screenX+", y:"+screenY+". Piece x:"+piece.getCoordinates().getX()+", piece y:"+piece.getCoordinates().getY());
            }else{
                Gdx.app.log("previouspiece","is null omg");
                //Gdx.app.log("previouspiece","Screen x: "+screenX+", Screen y:"+screenY);
            }
        }else{
            if(piece !=null){
                if(piece.getColor()==player.getColor()){
                    checkPreviousPiece(piece);
                }else{
                    Gdx.app.log("moure","peça moguda");
                    Coordinates c = board.screenToCoordinates(screenX, screenY);
                    board.set(previousPiece,  c.getX(),c.getY());
                    previousPiece=null;
                    board.print();
                }

            }else{

                Coordinates c = board.screenToCoordinates(screenX, screenY);
                board.set(previousPiece,  c.getX(),c.getY());
                previousPiece=null;
                Gdx.app.log("moure","peça moguda");
                board.print();
            }

        }

        return false;
    }

    /*
    sets the previous piece with the last piece touched by the user
    and calculates it's possible moves
     */
    private void checkPreviousPiece(Piece piece){
        if(piece==null){
            Gdx.app.log("previouspiece","piece is null");
        }
        if(piece!=null){
            if(piece.getColor()==player.getColor()){
                previousPiece=piece;
                previousPiece.getValidMoves(board);
            }
        }
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
