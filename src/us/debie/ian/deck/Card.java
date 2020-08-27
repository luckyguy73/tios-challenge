package us.debie.ian.deck;

public class Card {

    // value of card from 1 to 13 (Ace to King)
    private final Rank rank;

    // suit of card (Clubs, Diamonds, Hearts, Spades)
    private final Suit suit;

    // used enums so easy to create Card and not have to check for invalid arguments
    Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // getters come for free in intellij
    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    // override equals method to allow for searching for card in deck
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return getRank() == card.getRank() && getSuit() == card.getSuit();
    }

    // hashCode comes for free in intellij :)
    @Override
    public int hashCode() {
        int result = getRank().hashCode();
        result = 31 * result + getSuit().hashCode();
        return result;
    }

    // display cards rank, suit i.e. "ACE of CLUBS"
    @Override
    public String toString() {
        return String.format("%s of %s", rank, suit);
    }

}
