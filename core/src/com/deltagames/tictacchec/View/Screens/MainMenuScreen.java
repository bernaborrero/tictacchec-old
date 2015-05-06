package com.deltagames.tictacchec.View.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.deltagames.tictacchec.TicTacChec;
import com.deltagames.tictacchec.View.Utils.HDButton;

/**
 * Manages the menu screen
 * Created by Bernabé Borrero on 22/04/15.
 */
public class MainMenuScreen extends BaseScreen {

    private Stage stage;
    private Table table;

    private SpriteBatch spriteBatch;
    private Texture backgroundTexture;
    private Sprite backgroundSprite;

    private final String MENU_TITLE = "Tic Tac Chec";
    HDButton menuTitle;

    private TextButton playWithComputerButton, playWithPersonButton, exitButton;

    public MainMenuScreen(TicTacChec game) {
        super(game);
        stage = new Stage();
        table = new Table();

        spriteBatch = new SpriteBatch();

        playWithComputerButton = new TextButton("Play With Computer", getSkin());
        playWithPersonButton = new TextButton("Play With Another Person", getSkin());
        exitButton = new TextButton("Exit", getSkin());

        setUpListeners();

        backgroundTexture = new Texture(Gdx.files.internal("img/background.jpg"));
        backgroundSprite = new Sprite(backgroundTexture);
        backgroundSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        float fontY = (Gdx.graphics.getHeight() - getFont("albas").getBounds(MENU_TITLE).height / 2) - (40 * Gdx.graphics.getDensity());
        menuTitle = new HDButton(getFont("albas"), MENU_TITLE, true, fontY);
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

        spriteBatch.begin();
        backgroundSprite.draw(spriteBatch);

        menuTitle.draw(spriteBatch);

        // TODO: change menu items like the title, add listener support, etc.

        spriteBatch.end();

        stage.act();
        stage.draw();
    }

    @Override
    public void show() {

        table.add(playWithComputerButton).size(150 * Gdx.graphics.getDensity(), 60 * Gdx.graphics.getDensity()).padBottom(20 * Gdx.graphics.getDensity()).row();
        table.add(playWithPersonButton).size(150 * Gdx.graphics.getDensity(), 60 * Gdx.graphics.getDensity()).padBottom(20 * Gdx.graphics.getDensity()).row();
        table.add(exitButton).size(150 * Gdx.graphics.getDensity(), 60 * Gdx.graphics.getDensity()).padBottom(20 * Gdx.graphics.getDensity()).row();

        table.setFillParent(true);
        stage.addActor(table);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
