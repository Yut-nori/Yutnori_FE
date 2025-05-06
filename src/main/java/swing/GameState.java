package swing;

import java.util.*;

public class GameState {
    private int totalPlayerNumber = 4;
    private int unitNumberPerPlayer = 4;

    private Map<Integer, Integer> yutResults;



    private int currentPlayerId = 1;
    private int[][] unitPosition;

    private EnumSet<Phase> currentPhase;

    //만약 yutResults보다 커지게 되면 button 동작 안하게
    private int buttonClickRemaining = 0;

    /**
     * 어떤 YutResult를 클릭했는지 setting /
     * UnitIcon을 클릭할 때 이 값을 기준으로 back에 정보 전달
     */
    private int clickedYutResult = 0;


    public GameState() {
        yutResults = new HashMap<>();
        currentPhase = EnumSet.noneOf(Phase.class);
    }

    /**
     * 재시작 혹은 시작할 때
     * initiate_state를 사용함으로써 game_state를 초기화
     */
    public void initiate_state(int playerNum, int UnitNum) {
        totalPlayerNumber = playerNum;
        unitNumberPerPlayer = UnitNum;
        yutResults.clear();
        currentPlayerId = 1;
        unitPosition = new int[playerNum][UnitNum];
        currentPhase = EnumSet.noneOf(Phase.class);
        buttonClickRemaining = 0;
        clickedYutResult = 0;
    }

    public int getTotalPlayerNumber() {
        return totalPlayerNumber;
    }

    public int getUnitNumberPerPlayer() {
        return unitNumberPerPlayer;
    }

    public void setClickedYutResult(int clickedYutResult) {
        this.clickedYutResult = clickedYutResult;
    }

    public int getClickedYutResult() {
        return clickedYutResult;
    }

    public void setYutResults(Map<Integer, Integer> results) {
        this.yutResults = new HashMap<>(results);
    }

    public Map<Integer, Integer> getYutResults() {
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
