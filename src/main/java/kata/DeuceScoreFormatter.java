package kata;

import java.util.HashMap;
import java.util.Map;

public class DeuceScoreFormatter implements ScoreFormatter {
    @Override
    public String format(Score score, Score other) {
        Map<Integer, String> scores = new HashMap<>();
        scores.put(0, "Love-All");
        scores.put(1, "Fifteen-All");
        scores.put(2, "Thirty-All");
        scores.put(3, "Deuce");
        scores.put(4, "Deuce");
        return score.format(scores);
    }
}