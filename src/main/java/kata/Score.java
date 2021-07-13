package kata;

import java.util.HashMap;
import java.util.Map;

public class Score {
    private int score;

    public Score(int score) {
        this.score = score;
    }

    public void addPoint() {
        score++;
    }

    public String formatDeuce() {
        Map<Integer, String> scores = new HashMap<>();
        scores.put(0, "Love-All");
        scores.put(1, "Fifteen-All");
        scores.put(2, "Thirty-All");
        scores.put(3, "Deuce");
        scores.put(4, "Deuce");
        return scores.get(score);
    }

    public boolean equalTo(Score other) {
        return score == other.score;
    }

    public boolean isNearToWin() {
        return score >= 4;
    }

    public String format() {
        Map<Integer, String> scores = new HashMap<>();
        scores.put(0, "Love");
        scores.put(1, "Fifteen");
        scores.put(2, "Thirty");
        scores.put(3, "Forty");
        return scores.get(score);
    }

    public Score minus(Score other) {
        return new Score(score - other.score);
    }

    public String format(Name name) {
        Map<Integer, String> scores = new HashMap<>();
        scores.put(1, "Advantage " + name);
        scores.put(2, "Win for " + name);
        scores.put(3, "Win for " + name);
        scores.put(4, "Win for " + name);
        return scores.get(score);
    }

    public boolean isGreaterThan(Score other) {
        return score > other.score;
    }
}
