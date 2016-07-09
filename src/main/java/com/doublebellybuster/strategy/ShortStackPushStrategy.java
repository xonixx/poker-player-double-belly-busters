package com.doublebellybuster.strategy;

import com.doublebellybuster.model.IGameState;
import com.doublebellybuster.model.IPlayer;

/**
 * Created by sviridenich on 7/9/16.
 */
public class ShortStackPushStrategy implements IStrategy{

    private int threshold;
    private static int default_threshold = 12;

    public ShortStackPushStrategy() {
        this(default_threshold);
    }

    public ShortStackPushStrategy(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public int betRequest(IGameState gameState) {

        if (gameState.getAffectiveStack() > this.threshold){
            return 0;
        }
        IStrategy s = new PushAllInStrategy();

        return s.betRequest(gameState);
    }
}
