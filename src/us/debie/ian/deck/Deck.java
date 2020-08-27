package us.debie.ian.deck;

import java.util.*;

public class Deck {

    private List<Card> cards = new ArrayList<>();

    Deck() {
        // add all 52 cards, (4 suits * 13 ranks), to the deck by order of rank for each suit
        for (Suit suit : Suit.values())
            for (Rank rank : Rank.values())
                cards.add(new Card(rank, suit));
    }

    void inShuffle() {
        /*
            create 2 subLists to mimic splitting the deck in half
            iterate through cards list and if i is even add next card from second subList
            otherwise i is odd so grab next card from first subList. increment the
            appropriate subList index in order to add the next card in the list.
         */
        int n = cards.size(), firstIdx = 0, secondIdx = 0;
        List<Card> first = cards.subList(0, n / 2);
        List<Card> second = cards.subList(n / 2, n);
        List<Card> out = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) out.add(second.get(secondIdx++));
            else out.add(first.get(firstIdx++));
        }
        cards = out;
    }

    // show each card in the deck and its current position in the deck
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards)
            sb.append(card.toString()).append(" position: ").append(cards.indexOf(card) + 1).append("\n");
        return sb.toString();
    }

    public int getSize() {
        return cards.size();
    }

    public int findCard(Card card) {
        // return index of the found card else -1 if not found
        for (int i = 0; i < getSize(); ++i)
            if (cards.get(i).equals(card)) return i;
        return -1;
    }
}
