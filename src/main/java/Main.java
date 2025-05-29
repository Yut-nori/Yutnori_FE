import javax.swing.*;

import controller.BoardManager;
import screen.MainFrame;
import view.GameView;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
        GameView gameView = new GameView();
        gameView.displayWelcome(1,2,2);
    }
}
