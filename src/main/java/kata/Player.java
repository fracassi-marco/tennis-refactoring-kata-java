package kata;

public class Player {
    private final Name name;
    private final Score score;

    public Player(Name name, Score score) {
        this.name = name;
        this.score = score;
    }

    public boolean is(String playerName) {
        return name.is(playerName);
    }

    public void addPoint() {
        score.addPoint();
    }

    public boolean hasSameScore(Player other) {
        return score.equalTo(other.score);
    }

    public boolean isNearToWin(Player other) {
        return score.isNearToWin() && score.isGreaterThan(other.score);
    }

    public String format(ScoreFormatter formatter, Player other) {
        return formatter.format(score, other.score);
    }

    public String prependToName(String text) {
        return name.prepend(text);
    }
}
