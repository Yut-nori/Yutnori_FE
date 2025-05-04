package swing.util;

import swing.ScreenManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GlobalButtonListener implements ActionListener {
    private final ScreenManager screenManager;
    private final String actionName;

    public GlobalButtonListener(ScreenManager sm, String actionName) {
        this.screenManager = sm;
        this.actionName = actionName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (actionName) {
            //종료
            case "exit":
                System.exit(0);
                break;
            //화면 전환 3개
            case "settingPage":
                screenManager.setting();
                break;
            case "boardPage":
                screenManager.gameBoard();
                break;
            case "exitPage":
                screenManager.end();
                break;
            //board의 동작
            case "randomThrow":
                System.out.println("랜덤 윷 던지기 버튼 클릭됨");
                break;
            case "designatedThrow":
                System.out.println("지정 윷 던지기 버튼 클릭됨");
                break;
            default:
                System.out.println("알 수 없는 액션: " + actionName);

        }
    }
}