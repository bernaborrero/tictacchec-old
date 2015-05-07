package com.deltagames.tictacchec.View.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.deltagames.tictacchec.TicTacChec;
import com.deltagames.tictacchec.View.Utils.HDButton;

/**
 * Manages the menu screen
 * Created by Bernabé Borrero on 22/04/15.
 */
public class MainMenuScreen extends BaseScreen {

    private SpriteBatch spriteBatch;
    private Texture backgroundTexture;
    private Sprite backgroundSprite;

    private final String MENU_TITLE = "Tic Tac Chec";
    private HDButton menuTitle, playWithComputerButton, playWithPersonButton, exitButton;

    public MainMenuScreen(TicTacChec game) {
        super(game);

        spriteBatch = new SpriteBatch();

        backgroundTexture = new Texture(Gdx.files.internal("img/background.jpg"));
        backgroundSprite = new Sprite(backgroundTexture);
        backgroundSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        float fontY = (Gdx.graphics.getHeight() - getFont("albas").getBounds(MENU_TITLE).height / 2) - (40 * Gdx.graphics.getDensity());
        menuTitle = new HDButton(getFont("albas"), MENU_TITLE, true, fontY);

        playWithComputerButton = new HDButton(getFont("theboldfont"), "Play With Computer", true, fontY - (180 * Gdx.graphics.getDensity()));
        playWithPersonButton = new HDButton(getFont("theboldfont"), "Play Against Person", true, fontY - (280 * Gdx.graphics.getDensity()));
        exitButton = new HDButton(getFont("theboldfont"), "Exit", true, fontY - (380 * Gdx.graphics.getDensity()));
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        spriteBatch.begin();
        backgroundSprite.draw(spriteBatch);

        menuTitle.draw(spriteBatch);

        playWithComputerButton.draw(spriteBatch);
        playWithPersonButton.draw(spriteBatch);
        exitButton.draw(spriteBatch); 

        spriteBatch.end();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                if (playWithComputerButton.isClicked(screenX, screenY)) {
                    getGame().setScreen(new GameScreen(getGame(), GameScreen.GameMode.COMPUTER));
                }
                else if (playWithPersonButton.isClicked(screenX, screenY)) {
                    getGame().setScreen(new GameScreen(getGame(), GameScreen.GameMode.PERSON));
                }
                else if (exitButton.isClicked(screenX, screenY)) {
                    Gdx.app.exit();
                }

                return true;
            }
        });
    }
}
