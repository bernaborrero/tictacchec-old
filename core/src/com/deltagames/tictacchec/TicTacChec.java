package com.deltagames.tictacchec;

import com.badlogic.gdx.Game;
import com.deltagames.tictacchec.com.deltagames.tictacchec.screens.MainMenuScreen;

public class TicTacChec extends Game {
	
	@Override
	public void create () {
        this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
        super.render();
	}

}
