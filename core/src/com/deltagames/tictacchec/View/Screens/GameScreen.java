package com.deltagames.tictacchec.View.Screens;

import com.deltagames.tictacchec.TicTacChec;
import com.deltagames.tictacchec.View.Screens.BaseScreen;

/**
 * Manages the main game screen
 * Created by Bernabé Borrero on 22/04/15.
 */
public class GameScreen extends BaseScreen {

    public enum GameMode {
        COMPUTER, PERSON
    }

    public GameScreen(TicTacChec game, GameMode gameMode) {
        super(game);
    }


}