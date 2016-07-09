package com.doublebellybuster.model;

import com.doublebellybuster.model.analytics.PokerCombination;

import java.util.List;

/**
 * Created by sviridenich on 7/7/16.
 */
public interface IGameState {
    int getLastBet();
    IPlayer getMyPlayer();
    int getAffectiveStack();
    Position getPosition();

    PokerCombination getCombination(List<Card> mine, List<Card> common);
}
