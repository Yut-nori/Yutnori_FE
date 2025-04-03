package swing.gameboard;

import javax.swing.*;
import java.awt.*;

class RightPanel extends JPanel {
    public RightPanel() {
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        setBounds(970, 0, 310, 720);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 여기에 그리기 작업을 추가하세요.
    }

    class PlayerUnitTracker extends JPanel {

    }
}