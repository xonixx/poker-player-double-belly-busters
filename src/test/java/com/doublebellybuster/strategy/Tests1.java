package com.doublebellybuster.strategy;

import com.doublebellybuster.PokerLogic;
import com.doublebellybuster.model.Card;
import com.doublebellybuster.model.CardSuit;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Tests1 {
    @Test
    public void test1() {
        List<Card> l1 = Arrays.asList(
                new Card("10", CardSuit.diamonds),
                new Card("K", CardSuit.clubs),
                new Card("7", CardSuit.spades),
                new Card("J", CardSuit.hearts)
        );

        System.out.println(PokerLogic.top(l1));
    }
    @Test
    public void test2() {
        List<Card> l1 = Arrays.asList(
                new Card("10", CardSuit.diamonds),
                new Card("K", CardSuit.clubs),
                new Card("7", CardSuit.spades),
                new Card("J", CardSuit.hearts)
        );
        List<Card> l2 = Arrays.asList(
                new Card("10d"),
                new Card("Kc"),
                new Card("7s"),
                new Card("Jh")
        );
        System.out.println(l1);
        System.out.println(l2);
    }
}
