package kata;

import java.util.HashMap;

public class CloseToWin implements MatchStage {
    private final Player player1;
    private final Player player2;

    public CloseToWin(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public boolean canApply() {
        return player1.isCloseToWin() || player2.isCloseToWin();
    }

    @Override
    public String score() {
        return new HashMap<Integer, String>() {
            { put(1, advantage(player1));}
            { put(2, win(player1));}
            { put(3, win(player1));}
            { put(4, win(player1));}
            { put(-1, advantage(player2));}
            { put(-2, win(player2));}
            { put(-3, win(player2));}
            { put(-4, win(player2));}
        }.get(scoreGap());
    }

    private String win(Player player) {
        return player.appendName("Win for");
    }

    private String advantage(Player player) {
        return player.appendName("Advantage");
    }

    private int scoreGap() {
        return player1.scoreGap(player2);
    }
}
