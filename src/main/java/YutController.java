import java.util.HashMap;
import java.util.Map;

public class YutController {
    /**
     * 처음 시작할 때 back에서 player, unit의 수와 모양을 받아옴.
     */
    public Map<String, Integer> setStart(int playerNum, int unitNum, int shape) {
        Map<String, Integer> initValues = new HashMap<>();
        initValues.put("playerNum", playerNum);
        initValues.put("unitNum", unitNum);
        initValues.put("shape", shape);

        //playManger.set(playerNum, unitNum, shape);

        return initValues;
    }

    /**
     * 매 이동마다 player 중 이긴 사람이 있는지 검사
     * 0일 경우 계속 play
     * 양수 값일 경우 마지막 페이지로 넘어가야 함.
     */
    public int isEnd() {
        int winPlayer = 0;
        boolean isEnd = false;
        if(isEnd == false)
            return 0;

        return winPlayer;
    }

    public int[] throwYut() {
        int[] yutResult = new int[6];
        // back에서 yut던지고 결과 줌

        return yutResult;
    }

    public Information throwDesignatedYut(int[] yutresult) {
        Information information = new Information();
        //yutresult back에 넘겨주기
        //playManger.setresult(yutresult);

        return information;
    }


}
