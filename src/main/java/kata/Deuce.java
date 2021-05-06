package kata;

import static java.util.Arrays.asList;

public class Deuce implements MatchStage {
    private final Player player1;
    private final Player player2;

    public Deuce(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public boolean canApply() {
        return player1.hasSameScore(player2);
    }

    @Override
    public String score() {
        return player1.actualScore(asList("Love-All", "Fifteen-All", "Thirty-All", "Deuce", "Deuce"));
    }
}
