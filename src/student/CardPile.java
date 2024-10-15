package student;

public class CardPile {

    private Card topCard;
    private int numCards = 1;

    public CardPile(Card topCard) {
        this.topCard = topCard;
    }

    public boolean canPlay(Card card) {
        return card != null
                && (card.getRankNum() >= topCard.getRankNum()
                || card.getSuitName().equals(topCard.getSuitName()));
    }

    public void play(Card card) {
        if (!canPlay(card)) {
            System.out.println("Illegal move detected!");
            return;
        }

        numCards++;
        topCard = card;
    }

    public int getNumCards() {
        return numCards;
    }

    public Card getTopCard() {
        return topCard;
    }
}
