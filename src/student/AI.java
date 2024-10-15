package student;

public class AI {

    /**
     * Get the card that the AI will play.
     * @param hand The AI's current hand.
     * @param cardPile The current pile of cards.
     * @return The card that the AI will play from its hand, or null if it has no valid moves.
     */
    public Card getPlay(Hand hand, CardPile cardPile) {
        for (int i = 0; i < hand.getSize(); i++) {
            if (cardPile.canPlay(hand.get(i))) {
                return hand.get(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Random Card AI";
    }
}
