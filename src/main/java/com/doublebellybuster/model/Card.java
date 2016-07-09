package com.doublebellybuster.model;

public class Card implements Comparable<Card> {
    public static final String Ace = "A";
    public static final String King = "K";
    private String rank;
    private CardSuit suit;

    public Card() {
    }

    public Card(String val) {
        val = val.toLowerCase();
        rank = val.substring(0, val.length() - 1);
        suit = CardSuit.byChar(val.charAt(val.length() - 1));
    }

    public Card(String rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public boolean isSameRank(Card card) {
        return rank.equals(card.rank);
    }

    public String getRank() {
        return rank;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public boolean sameSuit(Card card) {
        return getSuit() == card.getSuit();
    }

    @Override
    public String toString() {
        return rank + suit;
    }

    public static final String POS = "1|2|3|4|5|6|7|8|9|10|J|Q|K|A";

    public int getValue() {
        return POS.indexOf(rank);
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(getValue(), o.getValue());
    }
}
