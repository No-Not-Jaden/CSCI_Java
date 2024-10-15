package student;

import java.util.Random;

public class Deck {
    /**
     * A pseudo random number generated to randomly shuffle the cards.
     */
    private static final Random RANDOM = new Random();

    /**
     * The number of cards remaining in the deck.
     */
    private int cardsRemaining;
    /**
     * The current cards in the deck.
     */
    private final Card[] cards = new Card[52];

    /**
     * Instantiates a new, shuffled deck of cards.
     */
    public Deck() {
        // initialize the deck like in the same order you would open a new deck of cards
        for (int i = 0; i < cards.length; i++) {
            cards[i] = new Card(i % 13 + 1, i / 13 + 1);
        }
        // shuffle the deck
        shuffle();
    }

    /**
     * Shuffles the deck of cards in a random order.
     */
    public void shuffle() {
        for (int i = cards.length - 1; i > 0; i--) {
            int j = RANDOM.nextInt(0, i + 1);
            Card tempCard = cards[i];
            cards[i] = cards[j];
            cards[j] = tempCard;
        }
        cardsRemaining = cards.length;
    }

    /**
     * Draws a card from the deck. If no cards are present, the deck will be shuffled.
     * @return The top card on the deck.
     */
    public Card draw() {
        if (cardsRemaining == 0) {
            shuffle();
        }

        cardsRemaining--;
        return cards[cardsRemaining];
    }

    /**
     * Get the number of cards remaining in the deck before another shuffle must happen.
     * @return The number of cards remaining in the deck.
     */
    public int cardsRemaining() {
        return cardsRemaining;
    }

    /**
     * Check if the draw pile is empty.
     * @return True if the next call to {@link #draw()} will shuffle the deck.
     */
    public boolean isEmpty() {
        return cardsRemaining == 0;
    }
}
