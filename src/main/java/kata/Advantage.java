package kata;

public class Advantage implements MatchStage {
    private final Player player1;
    private final Player player2;

    public Advantage(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public boolean canApply() {
        return (player1.isCloseToWin() || player2.isCloseToWin()) && Math.abs(scoreGap()) == 1;
    }

    @Override
    public String score() {
        String prefix = "Advantage";
        return scoreGap() == 1 ? player1.appendName(prefix) : player2.appendName(prefix);
    }

    private int scoreGap() {
        return player1.scoreGap(player2);
    }
}
