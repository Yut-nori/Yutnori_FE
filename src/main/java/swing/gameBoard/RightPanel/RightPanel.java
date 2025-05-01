package swing.gameBoard.RightPanel;

import javax.swing.*;

public class RightPanel extends JPanel {
    public RightPanel() {
        setOpaque(false);
        setLayout(null);
        setBounds(970, 0, 310, 720);

        // 플레이어 유닛 트래커 패널 생성
        PlayerUnitTracker playerUnitTracker = new PlayerUnitTracker();
        playerUnitTracker.setBounds(0, 0, 310, 720);

        // 메뉴 패널 생성
        MenuPanel menuPanel = new MenuPanel();
        menuPanel.setBounds(0, 580, 310, 140);


        add(playerUnitTracker);
        add(menuPanel);
    }

}