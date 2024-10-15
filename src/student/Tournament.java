package student;

public class Tournament {
    /**
     * Test the win rate of uno war games between multiple combinations of AI.
     * @param args Unused arguments.
     */
    public static void main(String[] args) {
        UnoWarMatch[] testGames = new UnoWarMatch[] {
                new UnoWarMatch(new AI(), new AI()),
                new UnoWarMatch(new AI(), new SmallestCardAI()),
                new UnoWarMatch(new AI(), new BiggestCardAI()),
                new UnoWarMatch(new SmallestCardAI(), new AI()),
                new UnoWarMatch(new SmallestCardAI(), new SmallestCardAI()),
                new UnoWarMatch(new SmallestCardAI(), new BiggestCardAI()),
                new UnoWarMatch(new BiggestCardAI(), new AI()),
                new UnoWarMatch(new BiggestCardAI(), new SmallestCardAI()),
                new UnoWarMatch(new BiggestCardAI(), new BiggestCardAI())
        };

        for (UnoWarMatch match : testGames) {
            System.out.println(match + " winRate: " + match.winRate(2000));
        }
    }
}
