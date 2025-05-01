package swing;

import swing.gameBoard.GameBoard;
import swing.screen.End;
import swing.screen.Setting;
import swing.screen.Start;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ScreenManager {
    private MainFrame frame;
    private GameManager gm;
    private Container container;

    public ScreenManager(MainFrame frame) {
        this.frame = frame;
        this.container = frame.getContentPane();
        start();
    }

    private void switchPanel(JPanel newPanel) {
        container.removeAll();
        container.add(newPanel);
        container.revalidate();
        container.repaint();
    }

    public void start() {
        switchPanel(new Start(this));
    }

    public void setting() {
        switchPanel(new Setting(this));
    }

    public void gameBoard() {
        switchPanel(new GameBoard(this));
    }

    public void end() {
        switchPanel(new End(this));
    }
}
