package kata;

import java.util.HashMap;
import java.util.Map;

public class NearToWinScoreFormatter implements ScoreFormatter {
    private final Player player;

    public NearToWinScoreFormatter(Player player) {
        this.player = player;
    }

    @Override
    public String format(Score score, Score other) {
        Map<Integer, String> scores = new HashMap<>();
        scores.put(1, player.prependToName("Advantage "));
        scores.put(2, player.prependToName("Win for "));
        scores.put(3, player.prependToName("Win for "));
        scores.put(4, player.prependToName("Win for "));
        return score.minus(other).format(scores);
    }
}
