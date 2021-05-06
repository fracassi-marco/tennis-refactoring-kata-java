package kata;

import java.util.List;

import static java.util.Arrays.asList;

public class InTheGame implements MatchStage {
    private Players players;

    public InTheGame(Players players) {
        this.players = players;
    }

    @Override
    public boolean canApply() {
        return true;
    }

    @Override
    public String score() {
        List<String> scores = asList("Love", "Fifteen", "Thirty", "Forty");
        return players.formatScores(scores);
    }
}
