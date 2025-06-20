package screen.gameBoard.leftPanel;

import gameControl.GameManager;
import gameControl.GlobalButtonListener;

import javax.swing.*;
import java.awt.*;

import static util.ComboBoxUtil.createStyledComboBox;

class ThrowControl extends JPanel {

    // ** 생성자 **
    public ThrowControl(GameManager gm) {

        // [1] 패널 기본 설정
        setLayout(null);
        setOpaque(false);

        // [2] case에 따라 윷 던지기 버튼을 만들어야 함
        // case1: 지정 윷 던지기
        if(gm.getGameState().isTest()) {

            // [2.1] 지정할 윷을 선택하는 콤보박스 생성
            JComboBox<String> yutComboBox = createStyledComboBox(
                    new String[]{"빽도", "도", "개", "걸", "윷", "모"}, 20, 240, 120, 70
            );

            // [2.2] 윷 던지기 버튼 생성 및 이벤트 리스너 추가
            JButton designatedYutThrowBtn = createYutButton("지정 윷", 150, 240, 150);
            designatedYutThrowBtn.addActionListener(e -> {

                // [2.2.1] 콤보박스에서 선택한 윷 결과를 가져옴
                int yutResult = yutComboBox.getSelectedIndex();
                if(yutResult == 0) yutResult = -1; // 빽도는 -1로 설정

                // 버튼 클릭이 가능한 phase일 때만 버튼 동작
                System.out.println("지정 윷 던지기 버튼 + " + yutResult);

                // 윷 던지기 메서드 호출(인자: 지정한 윷 결과 / -1: 빽도, 1: 도, 2: 개, 3: 걸, 4: 윷, 5: 모)
                gm.throwYut(yutResult);
            });

            // [2.3] 패널에 추가
            add(yutComboBox);
            add(designatedYutThrowBtn);
        }
        // case2: 랜덤 윷 던지기
        else {
            JButton randomYutThrowBtn = createYutButton("랜덤 윷", 20, 240, 270);
            randomYutThrowBtn.addActionListener(new GlobalButtonListener(gm, "randomThrow"));

            add(randomYutThrowBtn);
        }

        // [3] 윷 결과 패널 생성
        /**
         * 이제 이 Record를 버튼을 누를 때마다 클릭했을 때 보이는게 달라지도록 만들어져야함!
         * gm을 통해서 만들 수 있을듯!
         */
        int recordSpace = 20;
        int recordRadius = 80;
        int showResults = gm.getGameState().getCountClickedButton();
        YutRecord[] yutRecords = new YutRecord[6];
        int[] countYutResults = new int[6];
        for(int i = 0; i < showResults; i++) {
            int result = gm.getGameState().getYutResults().get(i);
            if(result == -1)
                result = 0;
            countYutResults[result]++;
        }
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
