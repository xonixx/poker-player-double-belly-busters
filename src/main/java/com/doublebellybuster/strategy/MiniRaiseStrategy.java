package com.doublebellybuster.strategy;

import com.doublebellybuster.model.IGameState;

/**
 * Created by sviridenich on 7/9/16.
 */
public class MiniRaiseStrategy implements IStrategy {

    @Override
    public int betRequest(IGameState gameState) {
        int last_bet = gameState.getLastBet();
        int max_bet = gameState.getMyPlayer().getAbsoluteStack();

        int mini_bet = 2 * last_bet;
        if (mini_bet > max_bet) {
            return max_bet;
        } else {
            return mini_bet;
        }
    }
}
