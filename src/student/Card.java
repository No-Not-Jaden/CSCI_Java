package student;

import java.util.Objects;

public class Card {
    /**
     * Rank of the card.
     * 1 = Ace, 2 = Two, ... 11 = Jack, 12 = Queen, 13 = King
     */
    private final int rank;
    /**
     * Suit of the card.
     * 1 = Spades, 2 = Hearts, 3 = Clubs, 4 = Diamonds
     */
    private final int suit;

    /**
     * Initialize a card with a rank and suit.
     * If the rank and suit of the card is out of bounds (1-13 & 1-4),
     * then an Ace of Spades is initialized.
     * @param rank Rank of the card.
     * @param suit Suit of the card.
     */
    public Card(int rank, int suit) {
        if (rank < 1 || rank > 13 || suit < 1 || suit > 4) {
            // rank is out of bounds
            System.out.println("Invalid Card");
            this.rank = 1;
            this.suit = 1;
        } else {
            this.rank = rank;
            this.suit = suit;
        }
    }

    /**
     * Get the rank number of the card.
     * @return The rank number of the card.
     */
    public int getRankNum() {
        return rank;
    }

    /**
     * Get the rank name of the card.
     * @return A string representation of the rank.
     */
    public String getRankName() {
        switch (rank) {
            case 2 -> {
                return "Two";
            }
            case 3 -> {
                return "Three";
            }
            case 4 -> {
                return "Four";
            }
            case 5 -> {
                return "Five";
            }
            case 6 -> {
                return "Six";
            }
            case 7 -> {
                return "Seven";
            }
            case 8 -> {
                return "Eight";
            }
            case 9 -> {
                return "Nine";
            }
            case 10 -> {
                return "Ten";
            }
            case 11 -> {
                return "Jack";
            }
            case 12 -> {
                return "Queen";
            }
            case 13 -> {
                return "King";
            }
            default -> {
                return "Ace";
            }
        }
    }

    /**
     * Get the suit name for the card.
     * @return A string representation of the suit.
     */
    public String getSuitName() {
        switch (suit) {
            case 2 -> {
                return "Hearts";
            }
            case 3 -> {
                return "Clubs";
            }
            case 4 -> {
                return "Diamonds";
            }
            default -> {
                return "Spades";
            }
        }
    }

    @Override
    public String toString() {
        return getRankName() + " of " + getSuitName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Card card)) {
            return false;
        }
        return rank == card.rank && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}
