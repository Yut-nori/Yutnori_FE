package swing.gameBoard.leftPanel;

import javax.swing.*;
import java.awt.*;

class YutGroup extends JPanel {

    public YutGroup() {

        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        setOpaque(false);

        // 윷 이미지 로드
        ImageIcon headImg = new ImageIcon(getClass().getResource("/GameBoard/head.png"));
        ImageIcon tailImg = new ImageIcon(getClass().getResource("/GameBoard/tail.png"));
        ImageIcon backImg = new ImageIcon(getClass().getResource("/GameBoard/back.png"));

        Image scaledHeadImg = headImg.getImage().getScaledInstance(80, 240, Image.SCALE_SMOOTH);
        Image scaledTailImg = tailImg.getImage().getScaledInstance(80, 240, Image.SCALE_SMOOTH);
        Image scaledBackImg = backImg.getImage().getScaledInstance(80, 240, Image.SCALE_SMOOTH);

        ImageIcon headImgIcon = new ImageIcon(scaledHeadImg);
        ImageIcon tailImgIcon = new ImageIcon(scaledTailImg);
        ImageIcon backImgIcon = new ImageIcon(scaledBackImg);

        // TEST
        int[] testResult = {0, 1, 1, 2}; // 0: head, 1: tail, 2: back

        for (int j : testResult) {
            JLabel label = new JLabel();

            switch (j) {
                case 0:
                    label.setIcon(headImgIcon);
                    break;
                case 1:
                    label.setIcon(tailImgIcon);
                    break;
                case 2:
                    label.setIcon(backImgIcon);
                    break;
            }
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            label.setOpaque(false);

            add(label);
        }
    }
}
