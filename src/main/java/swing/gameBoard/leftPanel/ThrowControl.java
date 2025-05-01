package swing.gameBoard.leftPanel;

import javax.swing.*;
import java.awt.*;

class ThrowControl extends JPanel {
    public ThrowControl() {
        setLayout(null);
        setOpaque(false);

        // 윷 던지기 버튼 생성
        JButton designatedYutThrowBtn = new JButton("<html>지정 윷<br>던지기</html>");
        designatedYutThrowBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        designatedYutThrowBtn.setBackground(Color.CYAN);
        designatedYutThrowBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        designatedYutThrowBtn.setBounds(20, 140, 120, 90);

        JButton randomYutThrowBtn = new JButton("<html>랜덤 윷<br>던지기</html>");
        randomYutThrowBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        randomYutThrowBtn.setBackground(Color.CYAN);
        randomYutThrowBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        randomYutThrowBtn.setBounds(170, 140, 120, 90);

        // 버튼 클릭 이벤트 처리
        designatedYutThrowBtn.addActionListener(e -> {
            // 윷 던지기 로직을 여기에 추가하세요.
            System.out.println("지정 윷 던지기 버튼 클릭됨");
        });
        randomYutThrowBtn.addActionListener(e -> {
            // 윷 던지기 로직을 여기에 추가하세요.
            System.out.println("랜덤 윷 던지기 버튼 클릭됨");
        });

        // 버튼을 패널에 추가
        add(designatedYutThrowBtn);
        add(randomYutThrowBtn);

        // 윷 결과 패널 생성
        int recordSpace = 20;
        int recordRadius = 80;
        YutRecord yutRecord1 = new YutRecord("모");
        yutRecord1.setBounds(16, 30, recordRadius, recordRadius);

        YutRecord yutRecord2 = new YutRecord("개");
        yutRecord2.setBounds(16 + recordRadius + recordSpace, 30, recordRadius, recordRadius);

        YutRecord yutRecord3 = new YutRecord();
        yutRecord3.setBounds(16 + 2 * recordRadius + 2 * recordSpace, 30, recordRadius, recordRadius);

        // 패널에 추가
        add(yutRecord1);
        add(yutRecord2);
        add(yutRecord3);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 여기에 그리기 작업을 추가하세요.
    }
}
