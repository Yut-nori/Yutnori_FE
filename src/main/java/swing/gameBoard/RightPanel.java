package swing.gameBoard;

import javax.swing.*;
import java.awt.*;

class RightPanel extends JPanel {
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

class PlayerUnitTracker extends JPanel {
    public PlayerUnitTracker() {

        setLayout(null);
        setOpaque(false);

        // Title Label
        JLabel titleLabel = new JLabel("Player Unit Tracker");
        titleLabel.setFont(new Font("돋움", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);

        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setVerticalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0, 0, 310, 140);

        // Player Unit Tracker
        TrackerPanel trackerPanel = new TrackerPanel(4);
        trackerPanel.setBounds(0, 140, 310, 440);

        add(titleLabel);
        add(trackerPanel);

    }
}

class TrackerPanel extends JPanel {
    public TrackerPanel(int playerNumber) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);

        PlayerUnitPanel player1Panel = new PlayerUnitPanel("Player 1", Color.RED);
        PlayerUnitPanel player2Panel = new PlayerUnitPanel("Player 2", Color.BLUE);
        PlayerUnitPanel player3Panel = new PlayerUnitPanel("Player 3", Color.GREEN);
        PlayerUnitPanel player4Panel = new PlayerUnitPanel("Player 4", Color.YELLOW);


        for (PlayerUnitPanel p : new PlayerUnitPanel[]{player1Panel, player2Panel, player3Panel, player4Panel}) {
            p.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(p);
        }


    }
}

class UnitIcon extends JComponent {
    private final Color color;
    private final int diameter;
    private final int thickness;

    public UnitIcon(Color color, int diameter) {
        this.color = color;
        this.diameter = diameter;
        this.thickness = 2;

        int fullSize = diameter + thickness;
        setPreferredSize(new Dimension(fullSize, fullSize));
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 말 채우기
        int offset = thickness / 2;
        g2.setColor(color);
        g2.fillOval(offset, offset, diameter, diameter);

        // 테두리
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(thickness));
        g2.drawOval(offset, offset, diameter, diameter);
    }
}

class PlayerUnitPanel extends JPanel {

    public PlayerUnitPanel(String playerName, Color unitColor) {
        setLayout(new BorderLayout());
        setOpaque(false);

        JLabel nameLabel = new JLabel(playerName);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        nameLabel.setPreferredSize(new Dimension(70, 40));
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel circlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        circlePanel.setOpaque(false);

        for (int i = 0; i < 4; i++) {
            circlePanel.add(new UnitIcon(unitColor, 30));
        }

        add(nameLabel, BorderLayout.NORTH);
        add(circlePanel, BorderLayout.CENTER);
    }
}


class MenuPanel extends JPanel {
    public MenuPanel() {
        setLayout(null);
        setOpaque(false);

        // Exit Button
        JButton exitButton = new JButton("게임 종료");
        exitButton.setFont(new Font("굴림", Font.BOLD, 20));
        exitButton.setBounds(30, 35, 250, 85);
        exitButton.setBackground(Color.LIGHT_GRAY);
        exitButton.setForeground(Color.BLACK);
        exitButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        add(exitButton);

    }
}