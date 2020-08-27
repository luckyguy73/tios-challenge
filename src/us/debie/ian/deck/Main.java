package us.debie.ian.deck;

public class Main {

    // the first card of a new deck is the ACE of CLUBS
    private final static Card TOP_CARD = new Card(Rank.ACE, Suit.CLUBS);
    private final static Card BOTTOM_CARD = new Card(Rank.KING, Suit.SPADES);

    public static void main(String[] args) {
        // display initial position of all cards in a new deck
        System.out.println(new Deck().toString());
        System.out.printf("The first card is in position %d after the 7th shuffle\n\n", positionOfCard(TOP_CARD, 7));

        // How many times must one perform the shuffle so that the top card becomes the bottom card?
        System.out.printf("One must perform the shuffle %d times so top card becomes bottom card\n",
                shuffleUntilCardIsAtBottom());
        // verifies position of first card after 26 shuffles is 52
        System.out.printf("The first card is in position %d after the 26th shuffle\n\n", positionOfCard(TOP_CARD, 26));

        // When do the first and last cards in the deck touch?
        System.out.printf("The first and last cards touch after %d shuffles\n",
                howManyShufflesUntilFirstAndLastCardsTouch());
        System.out.printf("The first card is in position %d after the 25th shuffle\n", positionOfCard(TOP_CARD, 25));
        System.out.printf("The last card is in position %d after the 25th shuffle\n", positionOfCard(BOTTOM_CARD, 25));

    }

    private static int positionOfCard(Card card, int shuffles) {
        Deck deck = new Deck();
        // invoke the inShuffle method the number of times of shuffles value
        for (int i = 0; i < shuffles; ++i) deck.inShuffle();

        // return the card index + 1 to get position
        return deck.findCard(card) + 1;
    }

    private static int shuffleUntilCardIsAtBottom() {
        int count = 0;
        Deck deck = new Deck();
        while (count < deck.getSize()) {
            // the bottom index is deck size - 1
            if (deck.findCard(TOP_CARD) == deck.getSize() - 1) return count;
            deck.inShuffle();
            count++;
        }
        return -1;
    }

    private static int howManyShufflesUntilFirstAndLastCardsTouch() {
        int count = 0;
        Deck deck = new Deck();
        while (count < deck.getSize()) {
            int firstsPosition = deck.findCard(TOP_CARD);
            int lastsPosition = deck.findCard(BOTTOM_CARD);
            // top card and bottom card are next to each other when difference of their positions is 1
            if (Math.abs(firstsPosition - lastsPosition) == 1) return count;
            deck.inShuffle();
            count++;
        }
        return -1;
    }


}
