package com.deltagames.tictacchec.View.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.deltagames.tictacchec.TicTacChec;

/**
 * Manages the main game screen
 * Created by Bernabé Borrero on 22/04/15.
 */
public class GameScreen extends BaseScreen {

    public enum GameMode {
        COMPUTER, PERSON
    }

    private Stage stage;
    private Table table;
    private SpriteBatch spriteBatch;

    private Texture boardTexture;
    private Sprite boardSprite;

    public GameScreen(TicTacChec game, GameMode gameMode) {
        super(game);
        initComponents();

    }

    private void initComponents() {
        stage = new Stage();
        table = new Table();
        spriteBatch = new SpriteBatch();
        loadSprites();
    }


    private void loadSprites() {
        boardTexture= generateTexture("img/awesomeBoard.png");
        boardSprite = new Sprite(boardTexture);
        boardSprite.setSize(Gdx.graphics.getHeight()/3, Gdx.graphics.getHeight()/3);
        boardSprite.setPosition((Gdx.graphics.getWidth()-boardSprite.getX())/2,Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/1.5F);
    }

    private Texture generateTexture(String texture){
        return new Texture(Gdx.files.internal(texture));
    }



    @Override
    public void render(float delta) {
        super.render(delta);

        spriteBatch.begin();
        boardSprite.draw(spriteBatch);
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
