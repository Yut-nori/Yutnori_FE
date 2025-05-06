package swing.gameBoard.RightPanel;

import javax.swing.*;
import java.awt.*;

class PlayerUnitPanel extends JPanel {

    /**
     * 이후에 수정이 필요한 부분
     * 1. unitNumber의 경우 말판 위에 나가있는 개수만큼 빼줘야함
     */
    public PlayerUnitPanel(String playerName, Color unitColor, int unitNumber) {
        setLayout(new BorderLayout());
        setOpaque(false);

        JLabel nameLabel = new JLabel(playerName);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        nameLabel.setPreferredSize(new Dimension(70, 40));
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel circlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        circlePanel.setOpaque(false);

        for (int i = 0; i < unitNumber; i++) {
            circlePanel.add(new UnitIcon(unitColor));
        }

        add(nameLabel, BorderLayout.NORTH);
        add(circlePanel, BorderLayout.CENTER);
    }
}