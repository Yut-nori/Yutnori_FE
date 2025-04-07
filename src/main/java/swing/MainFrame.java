package swing;

import swing.gameboard.GameBoard;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;

    public MainFrame() {


        setTitle("YutNori");
        setSize(1280, 720 + 30); // 30은 제목 표시줄 높이
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 화면 중앙 정렬

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);



        // 패널 생성 및 등록
        Map<String, JPanel> screens = ScreenManager.getScreens(this);
        for (Map.Entry<String, JPanel> entry : screens.entrySet()) {
            cardPanel.add(entry.getValue(), entry.getKey());
        }

        // GameBoard 패널 등록
        GameBoard gameBoardPanel = new GameBoard(this);
        cardPanel.add(gameBoardPanel, "gameBoard");

        add(cardPanel);
        cardLayout.show(cardPanel, "start");
    }

    public void showCard(String name) {
        cardLayout.show(cardPanel, name);
    }

}
