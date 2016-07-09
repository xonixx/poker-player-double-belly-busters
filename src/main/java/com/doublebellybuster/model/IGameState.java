package com.doublebellybuster.model;

import com.doublebellybuster.model.IPlayer;

/**
 * Created by sviridenich on 7/7/16.
 */
public interface IGameState {
    int getLastBet();
    IPlayer getMyPlayer();
    int getAffectiveStack();
}
