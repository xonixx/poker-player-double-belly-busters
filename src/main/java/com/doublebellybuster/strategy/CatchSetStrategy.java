package com.doublebellybuster.strategy;

import com.doublebellybuster.model.IGameState;
import com.doublebellybuster.model.IHoleCards;
import com.doublebellybuster.model.IPlayer;
import com.doublebellybuster.model.Street;
import com.doublebellybuster.model.analytics.PokerCombination;

/**
 * Created by sviridenich on 7/9/16.
 */
public class CatchSetStrategy implements IStrategy {

    @Override
    public int betRequest(IGameState gameState) {
        IPlayer p = gameState.getMyPlayer();
        IHoleCards hole_cards = p.getHoleCards();
        IStrategy strategy = new CheckFoldStrategy();

        if (hole_cards.isPocketPairs()) {
            if (gameState.getStreet() == Street.PREFLOP) {
                strategy = new CheckCallStrategy();
            } else {
                PokerCombination pc = gameState.getCombination();
                if (pc == null) {
                    strategy = new CheckFoldStrategy();
                } else if (pc == PokerCombination.Monster) {
                    strategy = new PushAllInStrategy();
                }
            }
        }

        return strategy.betRequest(gameState);
    }
}
