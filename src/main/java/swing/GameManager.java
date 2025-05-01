package swing;

import swing.screen.Start;

import javax.swing.*;
import java.awt.*;

public class GameManager {
    JPanel container;

    public GameManager(JPanel panel) {
        this.container = panel;
    }

    public void throwRepaint() {

    }

    public void moveUnitRepaint() {

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
