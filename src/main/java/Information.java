import java.util.HashMap;
import java.util.Map;

public class Information {
    private Map<String, Integer> unitInfo;
    private Map<Integer, Integer> onUnitInfo;

    private int[] yutResult;
    private int result;

    private int turnInfo;

    public Information() {
        unitInfo = new HashMap<String, Integer>();
        onUnitInfo = new HashMap<Integer, Integer>();

        yutResult = new int[6];
    }

    public Map<String, Integer> getUnitInfo() {
        return unitInfo;
    }

    public void setUnitInfo(Map<String, Integer> unitInfo) {
        this.unitInfo = unitInfo;
    }

    public Map<Integer, Integer> getOnUnitInfo() {
        return onUnitInfo;
    }

    public void setOnUnitInfo(Map<Integer, Integer> onUnitInfo) {
        this.onUnitInfo = onUnitInfo;
    }

    public int[] getYutResult() {
        return yutResult;
    }

    public void setYutResult(int[] yutResult) {
        this.yutResult = yutResult;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getTurnInfo() {
        return turnInfo;
    }

    public void setTurnInfo(int turnInfo) {
        this.turnInfo = turnInfo;
    }



}
