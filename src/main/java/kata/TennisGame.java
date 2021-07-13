package kata;

import java.util.HashMap;
import java.util.Map;

public class TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private final Name name1;
    private final Name name2;

    public TennisGame(String player1Name, String player2Name) {
        this.name1 = new Name(player1Name);
        this.name2 = new Name(player2Name);
    }

    public void wonPoint(String playerName) {
        if (name1.is(playerName))
            m_score1++;
        if (name2.is(playerName))
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
            scores.put(1, "Advantage " + name1);
            scores.put(-1, "Advantage " + name2);
            scores.put(2, "Win for " + name1);
            scores.put(-2, "Win for " + name2);
            scores.put(3, "Win for " + name1);
            scores.put(-3, "Win for " + name2);
            scores.put(4, "Win for " + name1);
            scores.put(-4, "Win for " + name2);
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
