package swing;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;

    public MainFrame() {
        setTitle("YutNori");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 화면 중앙 정렬

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // 패널 생성
        Start startPanel = new Start(this);

        // 나중에 다른 게임 화면도 여기에 추가 가능

        // 패널 등록
        cardPanel.add(startPanel, "start");

        add(cardPanel);
        cardLayout.show(cardPanel, "start");
    }

    public void showCard(String name) {
        cardLayout.show(cardPanel, name);
    }

}
