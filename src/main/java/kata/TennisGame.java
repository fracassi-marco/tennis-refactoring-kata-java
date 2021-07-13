package kata;

public class TennisGame {

    private final Score m_score1 = new Score(0);
    private final Score m_score2 = new Score(0);
    private final Name name1;
    private final Name name2;

    public TennisGame(String player1Name, String player2Name) {
        this.name1 = new Name(player1Name);
        this.name2 = new Name(player2Name);
    }

    public void wonPoint(String playerName) {
        if (name1.is(playerName))
            m_score1.addPoint();
        if (name2.is(playerName))
            m_score2.addPoint();
    }

    public String getScore() {
        if (m_score1.equalTo(m_score2)) {
            return m_score1.formatDeuce();
        }
        if (m_score1.isNearToWin() || m_score2.isNearToWin()) {
            Score diff = m_score1.minus(m_score2);
            return diff.format(name1, name2);
        }

        return m_score1.format() + "-" + m_score2.format();
    }
}
