package student;

public class BiggestCardAI extends AI {

    @Override
    public Card getPlay(Hand hand, CardPile cardPile) {
        // find the biggest card in the deck
        Card biggest = null;
        for (int i = 1; i < hand.getSize(); i++) {
            if (cardPile.canPlay(hand.get(i))
                    && (biggest == null || hand.get(i).getRankNum() > biggest.getRankNum())) {
                biggest = hand.get(i);
            }
        }
        return biggest;
    }

    @Override
    public String toString() {
        return "Biggest Card AI";
    }
}
