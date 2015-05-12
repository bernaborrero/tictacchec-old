package com.deltagames.tictacchec.View.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.deltagames.tictacchec.Model.Board.Board;
import com.deltagames.tictacchec.Model.Board.Coordinates;
import com.deltagames.tictacchec.Model.Players.Arnold;
import com.deltagames.tictacchec.Model.Players.HumanPlayer;
import com.deltagames.tictacchec.Model.Players.Player;
import com.deltagames.tictacchec.TicTacChec;

/**
 * Manages the main game screen
 * Created by Bernabé Borrero on 22/04/15.
 */
public class GameScreen extends BaseScreen {

    public enum GameMode {
        COMPUTER, PERSON
    }

    //fonts
    BitmapFont normalFont;

    //main components
    private Stage stage;
    private Table table;
    private SpriteBatch spriteBatch;

    // board graphics
    private Texture boardTexture;
    private Sprite boardSprite;

    //players instance
    private Player player1;
    private Player player2;

    //board instance
    private Board board;

    public GameScreen(TicTacChec game, GameMode gameMode, BitmapFont normalFont) {
        super(game);
        this.normalFont = normalFont;
        initComponents();
        //position #0 is for the initial Coordinates
        //position #1 is for the limit Coordinates
        Coordinates[] c = calculateBoardCoordinates();
        board = new Board(c[0],c[1]);
        initPlayers(gameMode);
        //board.print();
    }

    /**
     * initializes main components of the GUI
     */
    private void initComponents() {
        stage = new Stage();
        table = new Table();
        spriteBatch = new SpriteBatch();
        loadSprites();
    }

    private void initPlayers(GameMode gameMode) {
        player1= createPlayer(GameMode.PERSON);
        player2=createPlayer(gameMode);
        player1.createPieces(board);
        player2.createPieces(board);

    }

    /**
     * create's a Person object depending on the game mode
     * @param gameMode kind of Person that will be created
     * @return a Player object
     */
    private Player createPlayer(GameMode gameMode) {
        Player player;
        if(gameMode.equals(GameMode.COMPUTER)){
            player= new Arnold();
        }else{
            player= new HumanPlayer();
        }

        return player;
    }



    /**
     * loads all the Sprites to be used on this Scene
     */
    private void loadSprites() {
        boardTexture= generateTexture("img/awesomeBoard.png");
        boardSprite = new Sprite(boardTexture);
        boardSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getWidth());
        boardSprite.setPosition(0, (Gdx.graphics.getHeight() - Gdx.graphics.getWidth()) / 2);
    }

    /**
     * calculates the position of the board on the screen
     * @return array of Coordinates with the initial ones and the limits
     */
    private Coordinates[] calculateBoardCoordinates() {
        return new Coordinates[]{getInitialCoordinates(),getLimitCoordinates()};

    }

    /**
     * get the Limit coordinates of the board
     * @return Coordinates
     */
    private Coordinates getLimitCoordinates(){
        int finalX, finalY;


        finalX=Gdx.graphics.getWidth();
        finalY=Gdx.graphics.getHeight()-((Gdx.graphics.getHeight()-Gdx.graphics.getWidth())/2);
        Gdx.app.log("limitCoordinates","limit X: "+finalX+", final Y: "+finalY);
        return new Coordinates(finalX, finalY);
    }

    /**
     * calculate the initial Coordinates of the board
     * @return Coordinates
     */
    private Coordinates getInitialCoordinates(){
        int x,y;
        x=0;
        y=(Gdx.graphics.getHeight()-Gdx.graphics.getWidth())/2;
        Gdx.app.log("initCoordinates","init X: "+x+", init Y: "+y);
        return new Coordinates(x,y);
    }

    private Texture generateTexture(String texture){
        return new Texture(Gdx.files.internal(texture));
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        player1.move(board,player1,null);
        spriteBatch.begin();
        boardSprite.draw(spriteBatch);
        player1.draw(spriteBatch,board);
        player2.draw(spriteBatch,board);
        spriteBatch.end();
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
       spriteBatch.dispose();
       boardTexture.dispose();
       stage.dispose();
    }

}
