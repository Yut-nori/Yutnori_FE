package swing.gameboard;

import javax.swing.*;
import java.awt.*;

class MainBoard extends JPanel {
    public MainBoard() {
        setLayout(null);
        setBackground(Color.WHITE);
        setBounds(310, 60, 660, 640);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 여기에 그리기 작업을 추가하세요.
    }
}