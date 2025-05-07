package swing;

import swing.gameBoard.RightPanel.RightPanel;
import swing.gameBoard.leftPanel.LeftPanel;
import swing.screen.Start;

import javax.swing.*;
import java.awt.*;

public class GameManager {
    private JPanel container;
    private final GameState gameState;
//    private final back객체

    public GameManager(GameState gameState) {
        this.gameState = gameState;
    }

    public void initiate_back(int playerNum, int unitNum, int shape) {
//        this.back = back();
    }

    public void setContainer(JPanel container) {
        this.container = container;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void throwYut() {
        //back에서 호출하고
        //gameState 업데이트하고
        leftRepaint();
    }

    public void throwDesignatedYut() {
        //back에서 호출하고
        //gameState 업데이트하고
        leftRepaint();
    }

    public void moveUnit(int teamNum, int unitNum) {
        //back의 함수 호출 with (teamNum, unitNum, state의 click된 yut result);
        //gameState update
        moveUnitRepaint();
    }

    public void leftRepaint() {
        switchPanel(new LeftPanel(this));

    }

    public void rightRepaint() {
        switchPanel(new RightPanel(this));
    }

    public void moveUnitRepaint() {
        leftRepaint();
        rightRepaint();
    }

    public void switchPanel(JPanel panel) {
        Component[] components = container.getComponents();
        for (Component comp : components) {
            if (comp.getClass().equals(panel.getClass())) {
                container.remove(comp);
                break;
            }
        }
//        container.add(new MainPanel());
        container.revalidate();
        container.repaint();
    }


}
