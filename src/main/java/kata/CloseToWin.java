package kata;

import java.util.function.Function;

import static java.lang.Math.abs;

public class CloseToWin implements MatchStage {
    private final Player player1;
    private final Player player2;
    private final String prefix;
    private final Function<Integer, Boolean> condition;

    public CloseToWin(Player player1, Player player2, String prefix, Function<Integer, Boolean> condition) {
        this.player1 = player1;
        this.player2 = player2;
        this.prefix = prefix;
        this.condition = condition;
    }

    @Override
    public boolean canApply() {
        return (player1.isCloseToWin() || player2.isCloseToWin()) && condition.apply(abs(scoreGap()));
    }

    @Override
    public String score() {
        return condition.apply(scoreGap()) ? player1.appendName(prefix) : player2.appendName(prefix);
    }

    private int scoreGap() {
        return player1.scoreGap(player2);
    }
}
