package kata;

import java.util.HashMap;
import java.util.Map;

public class TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            m_score1++;
        if (playerName.equals(player2Name))
            m_score2++;
    }

    public String getScore() {
        if (m_score1 == m_score2) {
            Map<Integer, String> scores = new HashMap<>();
            scores.put(0, "Love-All");
            scores.put(1, "Fifteen-All");
            scores.put(2, "Thirty-All");
            scores.put(3, "Deuce");
            scores.put(4, "Deuce");
            return scores.get(m_score1);
        }
        if (m_score1 >= 4 || m_score2 >= 4) {
            Map<Integer, String> scores = new HashMap<>();
            scores.put(1, "Advantage " + player1Name);
            scores.put(-1, "Advantage " + player2Name);
            scores.put(2, "Win for " + player1Name);
            scores.put(-2, "Win for " + player2Name);
            scores.put(3, "Win for " + player1Name);
            scores.put(-3, "Win for " + player2Name);
            scores.put(4, "Win for " + player1Name);
            scores.put(-4, "Win for " + player2Name);
            return scores.get(m_score1 - m_score2);
        }

        Map<Integer, String> scores = new HashMap<>();
        scores.put(0, "Love");
        scores.put(1, "Fifteen");
        scores.put(2, "Thirty");
        scores.put(3, "Forty");
        return scores.get(m_score1) + "-" + scores.get(m_score2);
    }
}
