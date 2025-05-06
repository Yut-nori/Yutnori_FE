package swing;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class GameState {
    private List<Integer> yutResults = new ArrayList<>();
    private int currentPlayerId;
    private int[][] unitPosition;

    private EnumSet<Phase> currentPhase;
    //만약 yutResults보다 커지게 되면 button 동작 안하게
    private int buttonClickRemaining = 0;


    public void setYutResults(List<Integer> results) {
        this.yutResults = new ArrayList<>(results);
    }

    public List<Integer> getYutResults() {
        return yutResults;
    }

    public void consumeYutResult(int clicked) {
        if (!yutResults.isEmpty()) yutResults.remove(clicked);
    }

    public void setCurrentPlayer(int playerId) {
        this.currentPlayerId = playerId;
    }

    public int getCurrentPlayer() {
        return currentPlayerId;
    }
}
