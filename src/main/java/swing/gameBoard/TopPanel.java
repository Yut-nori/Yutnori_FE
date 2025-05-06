package swing.gameBoard;


import swing.GameManager;

import javax.swing.*;
import java.awt.*;

class TopPanel extends JPanel {
    /**
     * 이후 추가 이벤트에 따른 값들을 넣고 싶다면
     * switch문을 만들던가 혹은 다른 방향으로 변환 필요
     */
    public TopPanel(GameManager gm) {
        setLayout(null);
        setBounds(310, 0, 660, 60);

        // Create TextLabel
        JLabel turnLabel = new JLabel();
        String player = "Player ";
        switch(gm.getGameState().getCurrentPlayer()) {
            case 1 -> turnLabel.setText(player + 1);
            case 2 -> turnLabel.setText(player + 2);
            case 3 -> turnLabel.setText(player + 3);
            case 4 -> turnLabel.setText(player + 4);
        };
        turnLabel.setFont(new Font("Arial", Font.BOLD, 30));
        turnLabel.setForeground(Color.WHITE);

        // Locate label to center
        turnLabel.setHorizontalAlignment(SwingConstants.CENTER);
        turnLabel.setVerticalAlignment(SwingConstants.CENTER);
        turnLabel.setBounds(0, 0, 660, 60);

        // Set panel and label to transparent
        setOpaque(false);

        add(turnLabel);
    }
}