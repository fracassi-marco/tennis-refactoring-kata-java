package kata;

import java.util.HashMap;

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
        String score = "";
        int tempScore = 0;
        if (m_score1 == m_score2) {
            return deuce();
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            score = closeToWin();
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = m_score1;
                else {
                    score += "-";
                    tempScore = m_score2;
                }
                switch (tempScore) {
                    case 0:
                        score += "Love";
                        break;
                    case 1:
                        score += "Fifteen";
                        break;
                    case 2:
                        score += "Thirty";
                        break;
                    case 3:
                        score += "Forty";
                        break;
                }
            }
        }
        return score;
    }

    private String closeToWin() {
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) return "Advantage player1";
        if (minusResult == -1) return "Advantage player2";
        if (minusResult >= 2) return "Win for player1";
        return "Win for player2";
    }

    private String deuce() {
        return asList(
                "Love-All",
                "Fifteen-All",
                "Thirty-All",
                "Deuce",
                "Deuce"
        ).get(m_score1);
    }
}
