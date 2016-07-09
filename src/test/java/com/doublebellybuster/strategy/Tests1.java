package com.doublebellybuster.strategy;

import com.doublebellybuster.PokerLogic;
import com.doublebellybuster.model.Card;
import com.doublebellybuster.model.CardSuit;
import com.doublebellybuster.model.analytics.PokerCombination;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
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

    private static PokerCombination determine(List<String> mine, List<String> common) {
        List<Card> mineCards = new ArrayList<>(mine.size());
        List<Card> commonCards = new ArrayList<>(common.size());
        for (String m : mine) {
            mineCards.add(new Card(m));
        }
        for (String c : common) {
            commonCards.add(new Card(c));
        }
        return PokerLogic.determineCombination(mineCards, commonCards);
    }

    @Test
    public void test3() {
        Assert.assertEquals(PokerCombination.TopDouble,
                determine(
                        Arrays.asList("5s","6s"),
                        Arrays.asList("5h", "2c", "3s")));
        Assert.assertEquals(null,
                determine(
                        Arrays.asList("5s","6s"),
                        Arrays.asList("Qh", "2c", "3s")));
        Assert.assertEquals(PokerCombination.OverDouble,
                determine(
                        Arrays.asList("9s","9s"),
                        Arrays.asList("5h", "2c", "3s")));
        Assert.assertEquals(null,
                determine(
                        Arrays.asList("9s","9s"),
                        Arrays.asList("5h", "Kc", "3s")));
    }

}
