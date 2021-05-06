package kata;

import java.util.List;
import java.util.stream.Stream;

public class Players {
    private final Player player1;
    private final Player player2;

    public Players(Player player1, Player player2) {
        this.player1 =player1;
        this.player2 =player2;
    }

    public void addPointTo(String playerName) {
        Stream.of(player1, player2).filter(p -> p.is(playerName)).findFirst().get().addPoint();
    }

    public boolean areDeuce() {
        return player1.hasSameScore(player2);
    }

    public boolean areCloseToWin() {
        return Stream.of(player1, player2).anyMatch(Player::isCloseToWin);
    }

    public String formatScores(List<String> scores) {
        return player1.actualScore(scores) + "-" + player2.actualScore(scores);
    }

    public String formatScoresOnDeuce(List<String> scores) {
        return player1.actualScore(scores);
    }

    public int scoreGap() {
        return player1.scoreGap(player2);
    }
}
