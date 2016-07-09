package com.doublebellybuster.model;

public class Card {
    private String rank;
    private CardSuit suit;

    public String getRank() {
        return rank;
    }

    public CardSuit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank + suit;
    }
}
