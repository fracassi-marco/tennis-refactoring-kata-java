package kata;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class TennisGame {

    private final Player player1;
    private final Player player2;

    public TennisGame(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        Stream.of(player1, player2).filter(p -> p.is(playerName)).findFirst().get().addPoint();
    }

    public String getScore() {
        if (player1.hasSameScore(player2)) {
            return deuce();
        } else if (player1.isCloseToWin() || player2.isCloseToWin()) {
            return closeToWin();
        } else {
            return inTheGame();
        }
    }

    private String inTheGame() {
        List<String> scores = asList("Love", "Fifteen", "Thirty", "Forty");
        return player1.printScore(scores) + "-" + player2.printScore(scores);
    }

    private String closeToWin() {
        int minusResult = player1.scoreGap(player2);
        if (minusResult == 1) return "Advantage player1";
        if (minusResult == -1) return "Advantage player2";
        if (minusResult >= 2) return "Win for player1";
        return "Win for player2";
    }

    private String deuce() {
        return player1.printScore(asList("Love-All", "Fifteen-All", "Thirty-All", "Deuce", "Deuce"));
    }
}
