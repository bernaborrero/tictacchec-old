package com.deltagames.tictacchec.Model.Players;

import com.badlogic.gdx.Gdx;
import com.deltagames.tictacchec.Model.Board;
import com.deltagames.tictacchec.Model.Move;
import com.deltagames.tictacchec.Model.Moves;

import java.util.concurrent.Semaphore;

/**
 * Artificial Intelligence of the Tic Tac Chec.
 * This is Arnold, and he has returned.
 * Created by Bernabé Borrero on 27/04/15.
 */
public class Arnold extends Player {

    private final String ARNOLD_TAG = "Arnold";
    private final int EXHAUSTIVE_LEVELS = 8;

    @Override
    public void move(Board board, Player enemy, Semaphore blockingSemaphore) {

        new ThinkingThread(board, this, enemy, blockingSemaphore).run();

    }

    private class ThinkingThread extends Thread {

        private Board board;
        private Arnold arnold;
        private Player enemy;
        private Semaphore blockingSemaphore;

        public ThinkingThread(Board board, Arnold arnold, Player enemy, Semaphore blockingSemaphore) {
            this.board = board;
            this.arnold = arnold;
            this.enemy = enemy;
            this.blockingSemaphore = blockingSemaphore;
        }

        @Override
        public void run() {
            try {
                blockingSemaphore.acquire();

                // calculations
                Move minInfinite = new Move();
                Move maxInfinite = new Move();

                Move move = alphabeta(board, arnold, enemy, null, EXHAUSTIVE_LEVELS, minInfinite, maxInfinite, true);


                blockingSemaphore.release();
            } catch (InterruptedException e) {
                Gdx.app.log(ARNOLD_TAG, "Whoops! I can't block the UI!");
            }
        }

        private Move alphabeta(Board board, Player arnold, Player human, Move node, int depth, Move alpha, Move beta, boolean maximizingPlayer) {

            Player currentPlayer = maximizingPlayer ? arnold : human;

            Board virtualBoard = board.copy();
            virtualBoard.set(piece, node); // TODO: change the sumatory values of the piece for that player

            if (virtualBoard.hasWon(currentPlayer) || depth == 0) {
                return coordinates;
            }

            Moves moves = currentPlayer.getWeighedMoves(virtualBoard); // TODO: this method returns a collection containing all the valid moves of all the pieces of the player, with their weight set

            if (maximizingPlayer) {
                for (Move move : moves) {
                    alpha = max(alpha, alphabeta(virtualBoard, arnold, human, move, depth - 1, alpha, beta, false));
                    if (beta <= alpha) {
                        break;
                    }
                }
                return alpha;
            }
            else {

                for (Move move : moves) {
                    beta = min(beta, alphabeta(virtualBoard, arnold, human, move, depth - 1, alpha, beta, true));
                    if (beta <= alpha) {
                        break;
                    }
                }
                return beta;
            }
        }

    }
}
