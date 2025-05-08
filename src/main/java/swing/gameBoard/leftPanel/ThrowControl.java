package swing.gameBoard.leftPanel;

import swing.GameManager;
import swing.Phase;
import swing.gameBoard.GameBoard;
import swing.util.GlobalButtonListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static swing.util.ComboBox.createStyledComboBox;

class ThrowControl extends JPanel {
    public ThrowControl(GameManager gm) {
        setLayout(null);
        setOpaque(false);

        if(gm.getGameState().isTest()) {
            JComboBox<String> yutComboBox = createStyledComboBox(
                    new String[]{"빽도", "도", "개", "걸", "윷", "모"}, 20, 240, 120, 70
            );
            add(yutComboBox);
            JButton designatedYutThrowBtn = createYutButton("지정 윷", 150, 240, 150);
            designatedYutThrowBtn.addActionListener(e -> {
                int yutResult = yutComboBox.getSelectedIndex();
                if(yutResult == 0) yutResult = -1;
                if(gm.getGameState().getCurrentPhase().contains(Phase.BUTTON_CLICK)) {
                    System.out.println("지정 윷 던지기 버튼 + " + yutResult);
                    gm.throwDesignatedYut(yutResult);
                }
            });
            add(designatedYutThrowBtn);
        }
        else {
            JButton randomYutThrowBtn = createYutButton("랜덤 윷", 20, 240, 270);
            randomYutThrowBtn.addActionListener(new GlobalButtonListener(gm, "randomThrow"));
            add(randomYutThrowBtn);
        }

        // 윷 결과 패널 생성
        /**
         * 이제 이 Record를 버튼을 누를 때마다 클릭했을 때 보이는게 달라지도록 만들어져야함!
         * gm을 통해서 만들 수 있을듯!
         */
        int recordSpace = 20;
        int recordRadius = 80;
        int showResults = gm.getGameState().getYutResults().size() - gm.getGameState().getButtonClickRemaining();
        YutRecord[] yutRecords = new YutRecord[6];
        int[] countYutResults = new int[6];
        for(int i = 0; i < showResults; i++)
            countYutResults[gm.getGameState().getYutResults().get(i)]++;
        for(int i = 0; i < 6; i++) {
            int yutResult = i;
            if(i == 0)
                yutResult = -1;
            if(countYutResults[i] == 0)
                yutRecords[i] = new YutRecord();
            else
                yutRecords[i] = new YutRecord(gm, yutResult, countYutResults[i]);
            yutRecords[i].setBounds(16 + recordRadius * (i % 3) + recordSpace * (i % 3), 30 + 100 * (i / 3), recordRadius, recordRadius);
            add(yutRecords[i]);
        }

    }

    private JButton createYutButton(String label, int x, int y, int width) {
        JButton button = new JButton("<html>" + label + "<br>던지기</html>");
        button.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        button.setBackground(Color.CYAN);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        button.setBounds(x, y, width, 90);
        return button;
    }
}
