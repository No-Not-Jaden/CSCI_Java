package student;

public class Hand {
    /**
     * The deck to draw cards from.
     */
    private final Deck deck;
    /**
     * The number of cards contained in the hand.
     */
    private final int size;
    /**
     * The cards contained in the hand.
     */
    private final Card[] cards;

    /**
     * Instantiate a hand of cards.
     * @param deck The deck to draw cards from.
     * @param size The number of cards in the hand.
     */
    public Hand(Deck deck, int size) {
        this.deck = deck;
        this.size = size;

        cards = new Card[size];
        for (int i = 0; i < size; i++) {
            cards[i] = deck.draw();
        }
    }

    /**
     * Get the size of the hand.
     * @return The size of the hand.
     */
    public int getSize() {
        return size;
    }

    /**
     * Get a card from the hand.
     * @param i The index of the card in the hand.
     * @return The requested card, or the first card if the index was invalid.
     */
    public Card get(int i) {
        if (i < 0 || i >= size) {
            System.out.println("Invalid hand index!");
            return cards[0];
        }
        return cards[i];
    }

    /**
     * Removes a card from the hand.
     * @param card Nullable card to remove.
     * @return True if the card was removed.
     */
    public boolean remove(Card card) {
        if (card == null) {
            return false;
        }

        for (int i = 0; i < cards.length; i++) {
            if (cards[i].equals(card)) {
                cards[i] = deck.draw();
                return true;
            }
        }
        return false;
    }
}
