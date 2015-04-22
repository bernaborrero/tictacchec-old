package com.deltagames.tictacchec.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.deltagames.tictacchec.TicTacChec;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.title = "Tic Tac Chec";
        config.width = 600;
        config.height = 900;

		new LwjglApplication(new TicTacChec(), config);
	}
}
