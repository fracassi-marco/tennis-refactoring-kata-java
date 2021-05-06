package kata;

import static java.util.Arrays.asList;

public class Deuce implements MatchStage {
    private final Players players;

    public Deuce(Players players) {
        this.players = players;
    }

    @Override
    public boolean canApply() {
        return players.areDeuce();
    }

    @Override
    public String score() {
        return players.formatScoresOnDeuce(asList("Love-All", "Fifteen-All", "Thirty-All", "Deuce", "Deuce"));
    }
}
