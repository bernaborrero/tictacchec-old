package com.deltagames.tictacchec.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.deltagames.tictacchec.TicTacChec;

/**
 * Manages the menu screen
 * Created by Bernabé Borrero on 22/04/15.
 */
public class MainMenuScreen extends BaseScreen {

    private Stage stage;
    private Table table;

    private Skin skin;
    private Label titleLabel;
    private TextButton playWithComputerButton, playWithPersonButton, exitButton;

    public MainMenuScreen(TicTacChec game) {
        super(game);
        stage = new Stage();
        table = new Table();

        skin = new Skin(Gdx.files.internal("skins/default.json"));

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

        stage.act();
        stage.draw();
    }

    @Override
    public void show() {
        table.add(titleLabel).padBottom(40).row();
        table.add(playWithComputerButton).size(150, 60).padBottom(20).row();
        table.add(playWithPersonButton).size(150, 60).padBottom(20).row();
        table.add(exitButton).size(150, 60).padBottom(20).row();

        table.setFillParent(true);
        stage.addActor(table);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void dispose() {
        skin.dispose();
        stage.dispose();
    }
}
