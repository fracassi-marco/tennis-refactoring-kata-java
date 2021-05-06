package kata;

import java.util.List;

import static java.util.Arrays.asList;

public class InTheGame implements MatchStage {
    private final Player player1;
    private final Player player2;

    public InTheGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public boolean canApply() {
        return true;
    }

    @Override
    public String score() {
        List<String> scores = asList("Love", "Fifteen", "Thirty", "Forty");
        return player1.actualScore(scores) + "-" + player2.actualScore(scores);
    }
}
