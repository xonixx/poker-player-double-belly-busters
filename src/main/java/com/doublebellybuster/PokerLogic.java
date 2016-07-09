package com.doublebellybuster;

import com.doublebellybuster.model.Card;
import com.doublebellybuster.model.analytics.PokerCombination;

import java.util.*;

public class PokerLogic {
    public static PokerCombination determineCombination(List<Card> myCards, List<Card> commonCards) {
        Card topCommon = top(commonCards);
        Card my0 = myCards.get(0);
        Card my1 = myCards.get(1);

        int pairs = 0;
        for (Card my : myCards) {
            for (Card common : commonCards) {
                if (my.isSameRank(common))
                    pairs++;
            }
        }

        if (pairs == 2)
            return PokerCombination.TwoDoubles;

        if (topCommon.isSameRank(my0) || topCommon.isSameRank(my1))
            return PokerCombination.TopDouble;
        if (my0.isSameRank(my1) && my0.compareTo(topCommon) > 0)
            return PokerCombination.OverDouble;

        List<Card> allCards = new ArrayList<>();
        allCards.addAll(myCards);
        allCards.addAll(commonCards);

        if (allCards.size() == 5) {
            List<Card> sorted = sorted(allCards);
            Card c1 = sorted.get(0);
            Card c2 = sorted.get(1);
            Card c3 = sorted.get(2);
            Card c4 = sorted.get(3);
            Card c5 = sorted.get(4);
            HashSet suites = new HashSet();
            suites.addAll(Arrays.asList(c1.getSuit(), c2.getSuit(), c3.getSuit(), c4.getSuit(), c5.getSuit()));
            if (suites.size() == 1)
                return PokerCombination.Monster;
        }

        Map<String, Integer> setsOfSameRank = setsOfSameRank(allCards);

        List<Integer> values = new ArrayList<>(setsOfSameRank.values());
        Collections.sort(values, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        if (values.get(0) == 3 ||
                values.size() >= 2 && (values.get(0) == 2 || values.get(0) == 2) && values.get(1) == 2)
            return PokerCombination.Monster;

        if (my0.sameSuit(my1)) {
            int mySuitesCnt = 0;
            for (Card commonCard : commonCards) {
                if (my0.sameSuit(commonCard))
                    mySuitesCnt++;
            }
            if (mySuitesCnt >= 2)
                return PokerCombination.ForceFlashDro2;
        }

        for (Card myCard : myCards) {
            if (Card.Ace.equals(myCard.getRank()) || Card.King.equals(myCard.getRank())) {
                int cnt = 0;
                for (Card commonCard : commonCards) {
                    if (myCard.sameSuit(commonCard))
                        cnt++;
                }
                if (cnt >= 3)
                    return PokerCombination.ForceFlashDro1;
            }
        }

        // TODO ForceStreightDro

        return null;
    }

    public static Card top(Collection<Card> cards) {
        return Collections.max(cards);
    }

    public static List<Card> sorted(Collection<Card> cards) {
        List<Card> sorted = new ArrayList<>(cards);
        Collections.sort(sorted);
        return sorted;
    }

    public static Map<String, Integer> setsOfSameRank(Collection<Card> cards) {
        Map<String, Integer> res = new HashMap<>();
        for (Card card : cards) {
            String rank = card.getRank();
            Integer count = res.get(rank);
            if (count == null)
                res.put(rank, 1);
            else
                res.put(rank, count + 1);
        }
        return res;
    }
}
