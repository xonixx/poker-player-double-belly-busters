package com.doublebellybuster.strategy;

import com.doublebellybuster.model.IGameState;

/**
 * Created by sviridenich on 7/9/16.
 */
public class ConstantStrategy implements IStrategy {

    @Override
    public int betRequest(IGameState gameState) {
        return 10;
    }
}
