package swing.gameBoard.leftPanel;

import swing.GameManager;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel {
    public LeftPanel(GameManager gm) {
        setLayout(null);
        setOpaque(false);
        setBounds(0, 0, 310, 720);

        // 윷 결과 패널 생성
        YutResult yutResult = new YutResult();
        yutResult.setBounds(0, 0, 310, 470);

        // 던지기 패널 생성
        ThrowControl throwControl = new ThrowControl(gm);
        throwControl.setBounds(0, 470, 310, 250);



        add(yutResult);
        add(throwControl);
    }
}

