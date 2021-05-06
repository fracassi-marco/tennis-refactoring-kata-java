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

    public String actualScore(List<String> scores) {
        return scores.get(score);
    }

    public String appendName(String prefix) {
        return prefix + " " + name;
    }

    public boolean winOver(Player other) {
        return isCloseToWin() && scoreGap(other) > 1;
    }

    public boolean advantageOver(Player other) {
        return isCloseToWin() && scoreGap(other) == 1;
    }

    private boolean isCloseToWin() {
        return score >= 4;
    }

    private int scoreGap(Player other) {
        return score - other.score;
    }
}
