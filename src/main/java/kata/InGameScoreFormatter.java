package kata;

import java.util.HashMap;
import java.util.Map;

public class InGameScoreFormatter implements ScoreFormatter {
    @Override
    public String format(Score score, Score other) {
        Map<Integer, String> scores = new HashMap<>();
        scores.put(0, "Love");
        scores.put(1, "Fifteen");
        scores.put(2, "Thirty");
        scores.put(3, "Forty");
        return score.format(scores);
    }
}
