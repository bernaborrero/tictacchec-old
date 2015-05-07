package com.deltagames.tictacchec.View.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.deltagames.tictacchec.TicTacChec;

/**
 * Wrapper for the Screen class, implements base behavior
 * Created by Bernabé Borrero on 22/04/15.
 */
public abstract class BaseScreen implements Screen {

    private TicTacChec game;

    public BaseScreen(TicTacChec game) {
        this.game = game;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(228.0f / 255, 219.0f / 255, 191.0f / 255, 1.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    public TicTacChec getGame() {
        return game;
    }


    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
