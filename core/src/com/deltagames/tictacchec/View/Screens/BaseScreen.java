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
        Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void hide() {
        dispose();
    }

    public TicTacChec getGame() {
        return game;
    }

}
