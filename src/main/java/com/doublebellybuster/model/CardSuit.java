package com.doublebellybuster.model;

/**
 * https://en.wikipedia.org/wiki/Playing_cards_in_Unicode
 */
public enum CardSuit {
    spades("♠", 's'),
    hearts("♥", 'h'),
    clubs("♣", 'c'),
    diamonds("♦", 'd');

    public final String symbol;
    public final char aChar;

    CardSuit(String symbol, char aChar) {
        this.symbol = symbol;
        this.aChar = aChar;
    }

    static CardSuit byChar(char aChar) {
        for (CardSuit suit : values()) {
            if (suit.aChar == aChar)
                return suit;
        }
        return null;//TODO
    }

    @Override
    public String toString() {
        return symbol;
    }
}
