package com.deltagames.tictacchec.Model.Players;

import com.badlogic.gdx.Gdx;
import com.deltagames.tictacchec.Model.Board;

import java.util.concurrent.Semaphore;

/**
 * Artificial Intelligence of the Tic Tac Chec.
 * This is Arnold, and he has returned.
 * Created by Bernabé Borrero on 27/04/15.
 */
public class Arnold extends Player {

    private final String ARNOLD_TAG = "Arnold";

    @Override
    public void move(Board board, Semaphore blockingSemaphore) {

        new ThinkingThread(blockingSemaphore).run();

    }

    private class ThinkingThread extends Thread {

        private Semaphore blockingSemaphore;

        public ThinkingThread(Semaphore blockingSemaphore) {
            this.blockingSemaphore = blockingSemaphore;
        }

        @Override
        public void run() {
            try {
                blockingSemaphore.acquire();

                // calculations


                blockingSemaphore.release();
            } catch (InterruptedException e) {
                Gdx.app.log(ARNOLD_TAG, "Whoops! I can't block the UI!");
            }
        }

    }
}
