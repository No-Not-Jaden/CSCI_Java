package student;

public class UnoWarMatch {

    /**
     * The first AI playing the game.
     */
    private final AI ai1;
    /**
     * The second AI playing the game.
     */
    private final AI ai2;

    /**
     * Instantiates a match between 2 AI.
     * @param ai1 The AI that starts first.
     * @param ai2 The AI that starts second.
     */
    public UnoWarMatch(AI ai1, AI ai2) {
        this.ai1 = ai1;
        this.ai2 = ai2;
    }

    /**
     * Play a single game of UnoWarMatch between the 2 AI.
     * @return True if AI 1 wins, or false if AI 2 wins.
     */
    public boolean playGame() {
        Deck deck = new Deck();
        Hand hand1 = new Hand(deck, 5);
        Hand hand2 = new Hand(deck, 5);
        int ai1Points = 0;
        int ai2Points = 0;
        boolean oneWonLast = true;
        while (ai1Points < 10 && ai2Points < 10) {
            oneWonLast = playRound(hand1, hand2, deck, oneWonLast);
            if (oneWonLast) {
                ai1Points++;
            } else {
                ai2Points++;
            }
        }
        return ai1Points == 10;
    }

    /**
     * Plays a round of UnoWarMatch.
     * @param hand1 Hand of the first AI.
     * @param hand2 Hand of the second AI.
     * @param deck Deck of cards for the round.
     * @param turn1 Set to True if AI 1 should start first.
     * @return True if AI 1 won the round, false if AI 2 won the round.
     */
    private boolean playRound(Hand hand1, Hand hand2, Deck deck, boolean turn1) {
        CardPile cardPile = new CardPile(deck.draw());
        Card lastPlay = null;
        // loop for the round
        do {
            // don't play a card on the first iteration
            if (lastPlay != null) {
                cardPile.play(lastPlay);
            }
            // select a card to play from one of the AI
            if (turn1) {
                lastPlay = ai1.getPlay(hand1, cardPile);
                hand1.remove(lastPlay);
            } else {
                lastPlay = ai2.getPlay(hand2, cardPile);
                hand2.remove(lastPlay);
            }
            // flip the turn
            turn1 = !turn1;
        } while (lastPlay != null);
        // the last AI (!turn1) couldn't play a card
        return turn1;
    }

    /**
     * Test the winrate of the AI against each other.
     * @param nTrials Number of games to play.
     * @return The percent of times AI1 beat AI2.
     */
    public double winRate(int nTrials) {
        if (nTrials == 0) {
            // this will stop division by 0 in the return statement
            return 0.5;
        }
        int numAI1Wins = 0;
        int numAI2Wins = 0;
        for (int i = 0; i < nTrials; i++) {
            if (playGame()) {
                numAI1Wins++;
            } else {
                numAI2Wins++;
            }
        }
        return (double) numAI1Wins / (numAI1Wins + numAI2Wins);
    }

    @Override
    public String toString() {
        return ai1.toString() + " vs. " + ai2.toString();
    }
}
