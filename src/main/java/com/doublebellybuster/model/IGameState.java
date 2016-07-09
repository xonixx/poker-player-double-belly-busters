package com.doublebellybuster.model;

/**
 * Created by sviridenich on 7/7/16.
 */
public interface IGameState {
    int getLastBet();
    int getLastAffectiveBet();
    IPlayer getMyPlayer();
    int getAffectiveStack();
    Position getPosition();
}
