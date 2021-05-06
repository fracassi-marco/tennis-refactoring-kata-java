package kata;

import static java.lang.Math.abs;

public class Win implements MatchStage {
    private final Player player1;
    private final Player player2;

    public Win(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public boolean canApply() {
        return (player1.isCloseToWin() || player2.isCloseToWin()) && abs(scoreGap()) > 1;
    }

    @Override
    public String score() {
        return scoreGap() > 1 ? win(player1) : win(player2);
    }

    private String win(Player player) {
        return player.appendName("Win for");
    }

    private int scoreGap() {
        return player1.scoreGap(player2);
    }
}
