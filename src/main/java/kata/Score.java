package kata;

import java.util.Map;

public class Score {
    private int score;

    public Score(int score) {
        this.score = score;
    }

    public void addPoint() {
        score++;
    }

    public boolean equalTo(Score other) {
        return score == other.score;
    }

    public boolean isNearToWin() {
        return score >= 4;
    }

    public Score minus(Score other) {
        return new Score(score - other.score);
    }

    public boolean isGreaterThan(Score other) {
        return score > other.score;
    }

    public String format(Map<Integer, String> scores) {
        return scores.get(score);
    }
}
