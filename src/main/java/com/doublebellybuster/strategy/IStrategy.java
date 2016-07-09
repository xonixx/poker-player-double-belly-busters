package com.doublebellybuster.strategy;

import com.doublebellybuster.model.IGameState;

/**
 * Created by sviridenich on 7/7/16.
 */
public interface IStrategy {
    int betRequest(IGameState gameState);
}
