package kata;

import java.util.stream.Stream;

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
        Stream<MatchStage> stages = Stream.of(
                new Deuce(player1, player2),
                new Advantage(player1, player2),
                new Win(player1, player2),
                new InTheGame(player1, player2)
        );

        return stages.filter(MatchStage::canApply).findFirst().get().score();
    }
}
