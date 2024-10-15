package student;

public class SmallestCardAI extends AI {

    @Override
    public Card getPlay(Hand hand, CardPile cardPile) {
        // search for the smallest playable card.
        Card smallest = null;
        for (int i = 1; i < hand.getSize(); i++) {
            if (cardPile.canPlay(hand.get(i))
                    && (smallest == null || hand.get(i).getRankNum() < smallest.getRankNum())) {
                smallest = hand.get(i);
            }
        }
        return smallest;
    }

    @Override
    public String toString() {
        return "Smallest Card AI";
    }
}
