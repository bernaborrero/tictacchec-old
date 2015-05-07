package com.deltagames.tictacchec.View.Screens;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.deltagames.tictacchec.TicTacChec;
import com.deltagames.tictacchec.View.Utils.HDButton;
import com.deltagames.tictacchec.View.Utils.HDFont;

/**
 * Manages the menu screen
 * Created by Bernabé Borrero on 22/04/15.
 */
public class MainMenuScreen extends BaseScreen {

    BitmapFont titleFont, normalFont;

    private SpriteBatch spriteBatch;

    private final String MENU_TITLE = "Tic Tac Chec";
    private HDButton menuTitle, playWithComputerButton, playWithPersonButton, exitButton;

    public MainMenuScreen(TicTacChec game) {
        super(game);

        setUpFonts();

        spriteBatch = new SpriteBatch();

        float fontY = (Gdx.graphics.getHeight() - titleFont.getBounds(MENU_TITLE).height / 2) - (40 * Gdx.graphics.getDensity());
        menuTitle = new HDButton(titleFont, MENU_TITLE, true, fontY);

        playWithComputerButton = new HDButton(normalFont, "Play With Computer", true, fontY - (180 * Gdx.graphics.getDensity()));
        playWithPersonButton = new HDButton(normalFont, "Play Against Person", true, fontY - (280 * Gdx.graphics.getDensity()));
        exitButton = new HDButton(normalFont, "Exit", true, fontY - (380 * Gdx.graphics.getDensity()));
    }

    /**
     * Set up the fonts for this screen
     */
    private void setUpFonts() {
        int titleFontSize, normalFontSize;

        if (Gdx.app.getType() == Application.ApplicationType.Android) {
            titleFontSize = 180;
            normalFontSize = 90;
        } else {
            titleFontSize = 100;
            normalFontSize = 40;
        }

        FreeTypeFontGenerator titleFontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/birdsOfParadise.ttf"));
        FreeTypeFontGenerator normalFontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/theBoldFont.ttf"));

        titleFont = HDFont.getFont(titleFontGenerator, titleFontSize, new Color(112.0f / 255, 171.0f / 255, 143.0f / 255, 1.0f));
        normalFont = HDFont.getFont(normalFontGenerator, normalFontSize, new Color(220.0f / 255, 91.0f / 255, 33.0f / 255, 1.0f));

        titleFontGenerator.dispose();
        normalFontGenerator.dispose();
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        spriteBatch.begin();

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
                    getGame().setScreen(new GameScreen(getGame(), GameScreen.GameMode.COMPUTER, normalFont));
                }
                else if (playWithPersonButton.isClicked(screenX, screenY)) {
                    getGame().setScreen(new GameScreen(getGame(), GameScreen.GameMode.PERSON, normalFont));
                }
                else if (exitButton.isClicked(screenX, screenY)) {
                    Gdx.app.exit();
                }

                return true;
            }
        });
    }

    @Override
    public void dispose() {
        titleFont.dispose();
    }
}
