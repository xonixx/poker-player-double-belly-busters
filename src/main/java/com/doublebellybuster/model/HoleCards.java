package com.doublebellybuster.model;

import java.util.List;
import java.util.Objects;

/**
 * Created by sviridenich on 7/9/16.
 */
public class HoleCards implements IHoleCards {

    private Card first_card;
    private Card second_card;

    public HoleCards(List<Card> cardList) {
        this.first_card = cardList.get(0);
        this.second_card = cardList.get(1);
    }

    @Override
    public boolean isPocketPairs() {
        return Objects.equals(this.first_card.getRank(), this.second_card.getRank());
    }

    @Override
    public boolean hasBigCard() {
        if (this.first_card.getRank().equals("J")) return true;
        if (this.first_card.getRank().equals("Q")) return true;
        if (this.first_card.getRank().equals("K")) return true;
        if (this.first_card.getRank().equals("A")) return true;

        return false;
    }

    @Override
    public boolean hasMediumCard() {
        if (this.first_card.getRank().equals("10")) return true;
        if (this.first_card.getRank().equals("9")) return true;
        if (this.first_card.getRank().equals("8")) return true;
        if (this.first_card.getRank().equals("7")) return true;
        return false;
    }
}
