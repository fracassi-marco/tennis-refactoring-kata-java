package kata;

import java.util.List;

public class Player {
    private final String name;
    private int score = 0;

    public Player(String name) {
        this.name = name;
    }

    public boolean is(String name) {
        return this.name.equals(name);
    }

    public void addPoint() {
        score++;
    }

    public boolean hasSameScore(Player other) {
        return other.score == score;
    }

    public boolean isCloseToWin() {
        return score >= 4;
    }

    public String actualScore(List<String> scores) {
        return scores.get(score);
    }

    public int scoreGap(Player other) {
        return score - other.score;
    }
}
