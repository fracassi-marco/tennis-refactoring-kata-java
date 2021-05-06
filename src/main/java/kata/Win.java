package kata;

public class Win implements MatchStage {
    private final Player player1;
    private final Player player2;

    public Win(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public boolean canApply() {
        return player1.winOver(player2) || player2.winOver(player1);
    }

    @Override
    public String score() {
        return player1.winOver(player2) ? win(player1) : win(player2);
    }

    private String win(Player player) {
        return player.appendName("Win for");
    }
}
