package student;

public class CardPile {

    /**
     * The top card on the pile.
     */
    private Card topCard;
    /**
     * The number of cards in the pile.
     */
    private int numCards = 1;

    /**
     * Instantiate a card pile.
     * @param topCard The card at the top of the card pile.
     */
    public CardPile(Card topCard) {
        this.topCard = topCard;
    }

    /**
     * Check if a card is a valid play according to the UnoWarMatch rules.
     * @param card Card to play.
     * @return True if this card can be played.
     */
    public boolean canPlay(Card card) {
        return card != null
                && (card.getRankNum() >= topCard.getRankNum()
                || card.getSuitName().equals(topCard.getSuitName()));
    }

    /**
     * Plays a card onto the pile.
     * @param card Card to play.
     */
    public void play(Card card) {
        if (!canPlay(card)) {
            System.out.println("Illegal move detected!");
            return;
        }

        numCards++;
        topCard = card;
    }

    /**
     * Get the number of cards that are in this pile.
     * @return The number of cards in the pile.
     */
    public int getNumCards() {
        return numCards;
    }

    /**
     * Get the top card on the pile.
     * @return The top card on the pile.
     */
    public Card getTopCard() {
        return topCard;
    }
}
