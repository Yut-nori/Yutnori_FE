package swing.gameBoard.leftPanel;

import javax.swing.*;
import java.awt.*;

class YutResult extends JPanel {
    public YutResult() {
        setLayout(null);
        setOpaque(false);

        // 윷 결과 패널 생성
        JLabel resultLabel = new JLabel("도 !");
        resultLabel.setFont(new Font("맑은 고딕", Font.BOLD, 90));
        resultLabel.setForeground(Color.WHITE);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setVerticalAlignment(SwingConstants.CENTER);
        resultLabel.setBounds(70, 85, 170, 85);
        resultLabel.setOpaque(false);

        // Yut Group
        YutGroup yutGroup = new YutGroup();
        yutGroup.setBounds(0, 195, 320, 250);


        add(resultLabel);
        add(yutGroup);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 여기에 그리기 작업을 추가하세요.
    }
}