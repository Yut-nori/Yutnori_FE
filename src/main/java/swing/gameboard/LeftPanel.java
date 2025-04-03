package swing.gameboard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Set;

class LeftPanel extends JPanel {
    public LeftPanel() {
        setLayout(null);
        setOpaque(false);
        setBounds(0, 0, 310, 720);

        // 윷 결과 패널 생성
        YutResult yutResult = new YutResult();
        yutResult.setBounds(0, 0, 310, 470);

        // 던지기 패널 생성
        ThrowControl throwControl = new ThrowControl();
        throwControl.setBounds(0, 470, 310, 250);




        add(yutResult);
        add(throwControl);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 여기에 그리기 작업을 추가하세요.
    }
}

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



class ThrowControl extends JPanel {
    public ThrowControl() {
        setLayout(null);
        setOpaque(false);

        // 윷 던지기 버튼 생성
        JButton throwButton = new JButton("윷 던지기");
        throwButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        throwButton.setBounds(30, 140, 250, 90);

        // 버튼 클릭 이벤트 처리
        throwButton.addActionListener(e -> {
            // 윷 던지기 로직을 여기에 추가하세요.
            System.out.println("윷 던지기 버튼 클릭됨");
        });

        // 버튼을 패널에 추가
        add(throwButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 여기에 그리기 작업을 추가하세요.
    }
}
