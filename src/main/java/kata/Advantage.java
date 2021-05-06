package kata;

public class Advantage implements MatchStage {
    private final Players players;

    public Advantage(Players players) {
        this.players = players;
    }

    @Override
    public boolean canApply() {
        return players.areCloseToWin() && Math.abs(players.scoreGap()) == 1;
    }

    @Override
    public String score() {
        int minusResult =  players.scoreGap();
        if (minusResult == 1) return "Advantage player1";
        return "Advantage player2";
    }
}
