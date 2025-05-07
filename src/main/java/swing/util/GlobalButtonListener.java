package swing.util;

import swing.GameManager;
import swing.GameState;
import swing.Phase;
import swing.ScreenManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GlobalButtonListener implements ActionListener {
    private ScreenManager screenManager;
    private GameManager gameManager;
    private GameState gameState;
    private final String actionName;

    public GlobalButtonListener(ScreenManager screenManager, String actionName) {
        this.screenManager = screenManager;
        this.actionName = actionName;
    }

    public GlobalButtonListener(GameManager gameManager, String actionName) {
        this.gameManager = gameManager;
        this.actionName = actionName;
    }

    public GlobalButtonListener(GameManager gameManager, GameState gameState, String actionName) {
        this.gameManager = gameManager;
        this.gameState = gameState;
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
            case "exitPage":
                screenManager.end();
                break;

            //board의 동작 - with gameManager
            case "randomThrow":
                System.out.println("랜덤 윷 던지기 버튼 클릭됨");
                //gameManager.randomThrow();
//                if(gameState.contains(Phase.BUTTON_CLICK)
//                    gm.throwYut();
                break;
            case "designatedThrow":
                System.out.println("지정 윷 던지기 버튼 클릭됨");
                //gameManager.designatedThrow();
                break;
            default:
                System.out.println("알 수 없는 액션: " + actionName);

        }
    }
}