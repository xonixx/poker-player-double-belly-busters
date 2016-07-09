package com.doublebellybuster.model;

/**
 * https://en.wikipedia.org/wiki/Playing_cards_in_Unicode
 */
public enum CardSuit {
    spades("♠"),
    hearts("♥"),
    clubs("♣"),
    diams("♦");

    public final String symbol;

    CardSuit(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
