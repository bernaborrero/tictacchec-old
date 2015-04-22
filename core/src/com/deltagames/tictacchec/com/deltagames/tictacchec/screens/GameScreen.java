package com.deltagames.tictacchec.com.deltagames.tictacchec.screens;

import com.deltagames.tictacchec.TicTacChec;

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
