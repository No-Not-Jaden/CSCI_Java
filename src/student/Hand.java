package student;

public class Hand {
    private final Deck deck;
    private final int size;
    private final Card[] cards;

    public Hand(Deck deck, int size) {
        this.deck = deck;
        this.size = size;

        cards = new Card[size];
        for (int i = 0; i < size; i++) {
            cards[i] = deck.draw();
        }
    }

    public int getSize() {
        return size;
    }

    public Card get(int i) {
        if (i < 0 || i >= size) {
            System.out.println("Invalid hand index!");
            return cards[0];
        }
        return cards[i];
    }

    public boolean remove(Card card) {
        if (card == null)
            return false;

        for (int i = 0; i < cards.length; i++) {
            if (cards[i].equals(card)) {
                cards[i] = deck.draw();
                return true;
            }
        }
        return false;
    }
}
