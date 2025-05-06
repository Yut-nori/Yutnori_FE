package swing;

import swing.screen.Start;

import javax.swing.*;
import java.awt.*;

public class GameManager {
    private JPanel container;
    private final GameState gameState;

    public GameManager(GameState gameState) {
        this.gameState = gameState;
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
        //throwRepaint 부르고
    }

    public void moveUnit(int teamNum, int unitNum) {
        //back의 함수 호출 with (teamNum, unitNum, state의 click된 yut result);
        //gameState update
        //moveUnitRepaint()
    }
    public void throwRepaint() {
        //left panel에 위치한 것들 update(repaint)
        //
    }

    public void moveUnitRepaint() {
        throwRepaint();
        //나머지 unit들 repaint(right panel)
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
