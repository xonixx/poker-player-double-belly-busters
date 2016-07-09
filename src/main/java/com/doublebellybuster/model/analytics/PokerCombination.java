package com.doublebellybuster.model.analytics;

import static com.doublebellybuster.model.analytics.PokerCombinationCategory.ForceDraw;
import static com.doublebellybuster.model.analytics.PokerCombinationCategory.TopDoubleOrBetter;

public enum PokerCombination {
    TopDouble(TopDoubleOrBetter),
    OverDouble(TopDoubleOrBetter),
    TwoDoubles(TopDoubleOrBetter),
    Monster(TopDoubleOrBetter),
    ForceFlashDro2(ForceDraw),
    ForceFlashDro1(ForceDraw),
    ForceStreightDro(ForceDraw)
    ;
    PokerCombinationCategory category;

    PokerCombination(PokerCombinationCategory category) {
        this.category = category;
    }
}
