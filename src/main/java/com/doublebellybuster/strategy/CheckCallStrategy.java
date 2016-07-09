package com.doublebellybuster.strategy;

import com.doublebellybuster.model.IGameState;

/**
 * Created by sviridenich on 7/7/16.
 */
public class CheckCallStrategy implements IStrategy {
    @Override
    public int betRequest(IGameState gameState) {
        return gameState.getLastBet();
    }
}
