package kata;

public class TennisGame {

    private final Player player1;
    private final Player player2;

    public TennisGame(String player1Name, String player2Name) {
        this.player1 = new Player(new Name(player1Name), new Score(0));
        this.player2 = new Player(new Name(player2Name), new Score(0));
    }

    public void wonPoint(String playerName) {
        if (player1.is(playerName))
            player1.addPoint();
        if (player2.is(playerName))
            player2.addPoint();
    }

    public String getScore() {
        if (player1.hasSameScore(player2)) {
            return player1.format(new DeuceScoreFormatter(), player2);
        }
        if (player1.isNearToWin(player2)) {
            return player1.format(new NearToWinScoreFormatter(player1), player2);
        }
        if (player2.isNearToWin(player1)) {
            return player2.format(new NearToWinScoreFormatter(player2), player1);
        }

        return player1.format(new InGameScoreFormatter(), player2) + "-" + player2.format(new InGameScoreFormatter(), player1);
    }
}
