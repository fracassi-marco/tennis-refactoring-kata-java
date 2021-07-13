package kata;

public class TennisGame {

    private final Score score1 = new Score(0);
    private final Score score2 = new Score(0);
    private final Name name1;
    private final Name name2;

    public TennisGame(String player1Name, String player2Name) {
        this.name1 = new Name(player1Name);
        this.name2 = new Name(player2Name);
    }

    public void wonPoint(String playerName) {
        if (name1.is(playerName))
            score1.addPoint();
        if (name2.is(playerName))
            score2.addPoint();
    }

    public String getScore() {
        if (score1.equalTo(score2)) {
            return score1.formatDeuce();
        }
        if (score1.isNearToWin() && score1.isGreaterThan(score2)) {
            return score1.minus(score2).format(name1);
        }
        if (score2.isNearToWin() && score2.isGreaterThan(score1)) {
            return score2.minus(score1).format(name2);
        }

        return score1.format() + "-" + score2.format();
    }
}
