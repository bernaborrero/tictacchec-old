package com.deltagames.tictacchec.View.Screens;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
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

    BitmapFont albasFont, theBoldFont;

    private SpriteBatch spriteBatch;
    private Texture backgroundTexture;
    private Sprite backgroundSprite;

    private final String MENU_TITLE = "Tic Tac Chec";
    private HDButton menuTitle, playWithComputerButton, playWithPersonButton, exitButton;

    public MainMenuScreen(TicTacChec game) {
        super(game);

        setUpFonts();

        spriteBatch = new SpriteBatch();

        backgroundTexture = new Texture(Gdx.files.internal("img/background.jpg"));
        backgroundSprite = new Sprite(backgroundTexture);
        backgroundSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        float fontY = (Gdx.graphics.getHeight() - albasFont.getBounds(MENU_TITLE).height / 2) - (40 * Gdx.graphics.getDensity());
        menuTitle = new HDButton(albasFont, MENU_TITLE, true, fontY);

        playWithComputerButton = new HDButton(theBoldFont, "Play With Computer", true, fontY - (180 * Gdx.graphics.getDensity()));
        playWithPersonButton = new HDButton(theBoldFont, "Play Against Person", true, fontY - (280 * Gdx.graphics.getDensity()));
        exitButton = new HDButton(theBoldFont, "Exit", true, fontY - (380 * Gdx.graphics.getDensity()));
    }

    /**
     * Set up the fonts for this screen
     */
    private void setUpFonts() {
        int albasFontSize, theBoldFontSize;

        if (Gdx.app.getType() == Application.ApplicationType.Android) {
            albasFontSize = 150;
            theBoldFontSize = 90;
        } else {
            albasFontSize = 75;
            theBoldFontSize = 40;
        }

        FreeTypeFontGenerator albasGenerator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/albas.ttf"));
        FreeTypeFontGenerator theBoldFontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/theboldfont.ttf"));

        albasFont = HDFont.getFont(albasGenerator, albasFontSize, new Color(0.0f / 255, 119.0f / 255, 6.0f / 255, 1.0f));
        theBoldFont = HDFont.getFont(theBoldFontGenerator, theBoldFontSize, new Color(216.0f / 255, 1.0f, 207.0f / 255, 1.0f));
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
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                if (playWithComputerButton.isClicked(screenX, screenY)) {
                    getGame().setScreen(new GameScreen(getGame(), GameScreen.GameMode.COMPUTER, theBoldFont));
                }
                else if (playWithPersonButton.isClicked(screenX, screenY)) {
                    getGame().setScreen(new GameScreen(getGame(), GameScreen.GameMode.PERSON, theBoldFont));
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
        albasFont.dispose();
        backgroundTexture.dispose();
    }
}
