package com.doublebellybuster.strategy;

import com.doublebellybuster.model.IGameState;
import com.doublebellybuster.model.IHoleCards;
import com.doublebellybuster.model.analytics.PokerCombination;

/**
 * Created by sviridenich on 7/9/16.
 */
public class AdvancedShortStackStrategy implements IStrategy {

    public AdvancedShortStackStrategy() {
    }

    @Override
    public int betRequest(IGameState gameState) {
        IHoleCards hole_cards = gameState.getMyPlayer().getHoleCards();
        IStrategy strategy = new CheckFoldStrategy();
        int affective_stack = gameState.getAffectiveStack();

        if (affective_stack < 5 || gameState.getCombination() == PokerCombination.Monster) {
            strategy = new PushAllInStrategy();
        }

        if (hole_cards.isPocketPairs()) {
            strategy = new CatchSetStrategy();
        }

        if (affective_stack > 12){
            return 0;
        }

        if (hole_cards.isPocketPairs()) {
            if (affective_stack < 10) {
                strategy = new PushAllInStrategy();
            } else {
                if ((hole_cards.hasBigCard() || hole_cards.hasMediumCard())) {
                    strategy = new PushAllInStrategy();
                }
            }
        }

        if (hole_cards.hasBigCard() && affective_stack < 10) {
            strategy = new PushAllInStrategy();
        }

        return strategy.betRequest(gameState);

    }
}
