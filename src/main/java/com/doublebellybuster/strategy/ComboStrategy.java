package com.doublebellybuster.strategy;

import com.doublebellybuster.model.IGameState;

/**
 * Created by sviridenich on 7/9/16.
 */
public class ComboStrategy implements IStrategy{
    @Override
    public int betRequest(IGameState gameState) {
        IStrategy strategy = new CheckFoldStrategy();

        if (gameState.getAffectiveStack() > 50) {
            strategy = new PreflopRaiseContbetStrategy();
        }
        if (gameState.getAffectiveStack() <= 12) {
            strategy = new AdvancedShortStackStrategy();
        }

        return strategy.betRequest(gameState);
    }
}
