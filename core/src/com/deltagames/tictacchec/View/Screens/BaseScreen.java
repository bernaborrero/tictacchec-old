package com.deltagames.tictacchec.View.Screens;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.deltagames.tictacchec.TicTacChec;
import com.deltagames.tictacchec.View.Utils.HDFont;

import java.util.TreeMap;

/**
 * Wrapper for the Screen class, implements base behavior
 * Created by Bernabé Borrero on 22/04/15.
 */
public abstract class BaseScreen implements Screen {

    private TicTacChec game;

    private Skin skin;
    private TreeMap<String, BitmapFont> fonts;

    public BaseScreen(TicTacChec game) {
        this.game = game;
        skin = new Skin(Gdx.files.internal("skins/default.json"));
        fonts = new TreeMap<String, BitmapFont>();

        int albasFontSize, theBoldFontSize;

        if (Gdx.app.getType() == Application.ApplicationType.Android) {
            skin.getFont("default-font").setScale(Gdx.graphics.getDensity(), Gdx.graphics.getDensity());
            albasFontSize = 150;
            theBoldFontSize = 90;
        } else {
            albasFontSize = 75;
            theBoldFontSize = 40;
        }

        FreeTypeFontGenerator albasGenerator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/albas.ttf"));
        FreeTypeFontGenerator theBoldFontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/theboldfont.ttf"));

        fonts.put("albas", HDFont.getFont(albasGenerator, albasFontSize, new Color(0.0f / 255, 119.0f / 255, 6.0f / 255, 1.0f)));
        fonts.put("theboldfont", HDFont.getFont(theBoldFontGenerator, theBoldFontSize, new Color(216.0f / 255, 1.0f, 207.0f / 255, 1.0f)));

        albasGenerator.dispose();
        theBoldFontGenerator.dispose();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        skin.dispose();
    }

    public TicTacChec getGame() {
        return game;
    }

    public Skin getSkin() {
        return skin;
    }

    public BitmapFont getFont(String name) {
        return fonts.get(name);
    }
}
