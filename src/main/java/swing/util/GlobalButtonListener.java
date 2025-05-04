package swing.util;

import swing.GameManager;
import swing.ScreenManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GlobalButtonListener implements ActionListener {
    private ScreenManager screenManager;
    private GameManager gameManager;
    private final String actionName;

    public GlobalButtonListener(ScreenManager screenManager, String actionName) {
        this.screenManager = screenManager;
        this.actionName = actionName;
    }

    public GlobalButtonListener(GameManager gameManager, String actionName) {
        this.gameManager = gameManager;
        this.actionName = actionName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (actionName) {
            //종료 - by self
            case "exit":
                System.exit(0);
                break;

            //화면 전환 3개 - with screenManager
            case "settingPage":
                screenManager.setting();
                break;
            case "boardPage":
                screenManager.gameBoard();
                break;
            case "exitPage":
                screenManager.end();
                break;

            //board의 동작 - with gameManager
            case "randomThrow":
                System.out.println("랜덤 윷 던지기 버튼 클릭됨");
                //gameManager.randomThrow();
                break;
            case "designatedThrow":
                System.out.println("지정 윷 던지기 버튼 클릭됨");
                //gameManager.designatedThrow();
                break;
            case "clickMoveResult":
                //움직일 윷의 결과 클릭
                //이 때 화살표를 통해(?) 그 팀의 unit이 갈 수 있는 위치 표시
                break;
            case "clickMoveUnit":
                //위에 윷의 결과가 클릭되었을 때만 동작해야함.
                //윷의 결과를 통해 움직일 Unit 클릭했을 때 결과
                break;
            default:
                System.out.println("알 수 없는 액션: " + actionName);

        }
    }
}