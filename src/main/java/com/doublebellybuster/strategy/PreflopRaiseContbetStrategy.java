package com.doublebellybuster.strategy;

import com.doublebellybuster.model.IGameState;

/**
 * Created by sviridenich on 7/9/16.
 */

public class PreflopRaiseContbetStrategy implements IStrategy {
    @Override
    public int betRequest(IGameState gameState) {
        IStrategy strategy = new CheckFoldStrategy();

        int last_bet = gameState.getLastAffectiveBet();

        if (last_bet == 2) {
            strategy = new MiniRaiseStrategy();
        }

        return strategy.betRequest(gameState);

    }
}
