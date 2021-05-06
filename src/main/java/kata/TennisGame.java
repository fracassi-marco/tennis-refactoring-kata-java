package kata;

import java.util.List;

import static java.util.Arrays.asList;

public class TennisGame {

    private final Players players;

    public TennisGame(String player1Name, String player2Name) {
        players = new Players(new Player(player1Name), new Player(player2Name));
    }

    public void wonPoint(String playerName) {
        players.addPointTo(playerName);
    }

    public String getScore() {
        if (players.areDeuce()) {
            return deuce();
        }
        if (players.areCloseToWin()) {
            return closeToWin();
        }
        return inTheGame();
    }

    private String inTheGame() {
        List<String> scores = asList("Love", "Fifteen", "Thirty", "Forty");
        return players.formatScores(scores);
    }

    private String closeToWin() {
        int minusResult =  players.scoreGap();
        if (minusResult == 1) return "Advantage player1";
        if (minusResult == -1) return "Advantage player2";
        if (minusResult >= 2) return "Win for player1";
        return "Win for player2";
    }

    private String deuce() {
        return players.formatScoresOnDeuce(asList("Love-All", "Fifteen-All", "Thirty-All", "Deuce", "Deuce"));
    }
}
