package kata;

import java.util.List;

import static java.util.Arrays.asList;

public class TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;

    public TennisGame(String player1Name, String player2Name) {
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        if (m_score1 == m_score2) {
            return deuce();
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            return closeToWin();
        } else {
            return inTheGame();
        }
    }

    private String inTheGame() {
        List<String> scores = asList("Love", "Fifteen", "Thirty", "Forty");
        return scores.get(m_score1) + "-" + scores.get(m_score2);
    }

    private String closeToWin() {
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) return "Advantage player1";
        if (minusResult == -1) return "Advantage player2";
        if (minusResult >= 2) return "Win for player1";
        return "Win for player2";
    }

    private String deuce() {
        return asList("Love-All", "Fifteen-All", "Thirty-All", "Deuce", "Deuce").get(m_score1);
    }
}
