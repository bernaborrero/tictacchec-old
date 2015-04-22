package com.deltagames.tictacchec.com.deltagames.tictacchec.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.deltagames.tictacchec.TicTacChec;

/**
 * Manages the menu screen
 * Created by Bernabé Borrero on 22/04/15.
 */
public class MainMenuScreen extends BaseScreen {

    private Stage stage;

    private Skin skin;
    private Label titleLabel;
    private TextButton playWithComputerButton, playWithPersonButton, exitButton;

    public MainMenuScreen(TicTacChec game) {
        super(game);
        stage = new Stage();

        skin = new Skin(Gdx.files.internal(""));

        titleLabel = new Label("Tic Tac Chec", skin);
        playWithComputerButton = new TextButton("Play With Computer", skin);
        playWithPersonButton = new TextButton("Play With Another Person", skin);
        exitButton = new TextButton("Exit", skin);

        setUpListeners();
    }

    /**
     * Set up the listeners of the buttons
     */
    private void setUpListeners() {

        playWithComputerButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                getGame().setScreen(new GameScreen(getGame(), GameScreen.GameMode.COMPUTER));
            }
        });

        playWithPersonButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                getGame().setScreen(new GameScreen(getGame(), GameScreen.GameMode.PERSON));
            }
        });

        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
    }

    @Override
    public void render(float delta) {
        super.render(delta);


    }

    @Override
    public void dispose() {
        skin.dispose();
        stage.dispose();
    }
}
