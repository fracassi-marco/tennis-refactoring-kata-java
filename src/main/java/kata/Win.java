package kata;

public class Win implements MatchStage {
    private Players players;

    public Win(Players players) {
        this.players = players;
    }

    @Override
    public boolean canApply() {
        return players.areCloseToWin() && Math.abs(players.scoreGap()) > 1;
    }

    @Override
    public String score() {
        int minusResult =  players.scoreGap();
        if (minusResult >= 2) return "Win for player1";
        return "Win for player2";
    }
}
