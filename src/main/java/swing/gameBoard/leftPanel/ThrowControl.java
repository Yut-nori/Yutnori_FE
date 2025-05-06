package swing.gameBoard.leftPanel;

import swing.GameManager;
import swing.gameBoard.GameBoard;
import swing.util.GlobalButtonListener;

import javax.swing.*;
import java.awt.*;

class ThrowControl extends JPanel {
    public ThrowControl(GameManager gm) {
        setLayout(null);
        setOpaque(false);

        // 윷 던지기 버튼 생성
        JButton designatedYutThrowBtn = createYutButton("지정 윷", 20, 140);
        JButton randomYutThrowBtn = createYutButton("랜덤 윷", 170, 140);

        // 버튼 클릭 이벤트 처리
        designatedYutThrowBtn.addActionListener(new GlobalButtonListener(gm, "designatedThrow"));
        randomYutThrowBtn.addActionListener(new GlobalButtonListener(gm, "randomThrow"));

        // 버튼을 패널에 추가
        add(designatedYutThrowBtn);
        add(randomYutThrowBtn);

        // 윷 결과 패널 생성
        int recordSpace = 20;
        int recordRadius = 80;
        YutRecord yutRecord1 = new YutRecord(gm, 5);
        yutRecord1.setBounds(16, 30, recordRadius, recordRadius);

        YutRecord yutRecord2 = new YutRecord(gm, 2);
        yutRecord2.setBounds(16 + recordRadius + recordSpace, 30, recordRadius, recordRadius);

        YutRecord yutRecord3 = new YutRecord();
        yutRecord3.setBounds(16 + 2 * recordRadius + 2 * recordSpace, 30, recordRadius, recordRadius);

        // 패널에 추가
        add(yutRecord1);
        add(yutRecord2);
        add(yutRecord3);

    }

    private JButton createYutButton(String label, int x, int y) {
        JButton button = new JButton("<html>" + label + "<br>던지기</html>");
        button.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        button.setBackground(Color.CYAN);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        button.setBounds(x, y, 120, 90);
        return button;
    }
}
