package kata;

public class Advantage implements MatchStage {
    private final Player player1;
    private final Player player2;

    public Advantage(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public boolean canApply() {
        return player1.advantageOver(player2) || player2.advantageOver(player1);
    }

    @Override
    public String score() {
        return player1.advantageOver(player2) ? advantage(player1) : advantage(player2);
    }

    private String advantage(Player player) {
        return player.appendName("Advantage");
    }
}
