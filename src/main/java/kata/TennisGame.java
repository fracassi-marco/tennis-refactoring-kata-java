package kata;

import java.util.stream.Stream;

public class TennisGame {

    private final Players players;

    public TennisGame(String player1Name, String player2Name) {
        players = new Players(new Player(player1Name), new Player(player2Name));
    }

    public void wonPoint(String playerName) {
        players.addPointTo(playerName);
    }

    public String getScore() {
        return Stream.of(new Deuce(players), new Advantage(players), new Win(players), new InTheGame(players))
            .filter(MatchStage::canApply)
            .findFirst().get()
            .score();
    }
}
