package swing.gameboard;

import javax.swing.*;
import java.awt.*;

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

class YutRecord extends JPanel {

    private String resultText;
    private boolean isEmpty;

    public YutRecord() {
        this.resultText = "";
        this.isEmpty = true;
        setPreferredSize(new Dimension(80, 80)); // 원 사이즈
        setOpaque(false); // 투명 배경
    }

    public YutRecord(String resultText) {
        this.resultText = resultText;
        this.isEmpty = false;
        setPreferredSize(new Dimension(80, 80)); // 원 사이즈
        setOpaque(false); // 투명 배경
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 그래픽 설정
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 원 그리기 (조금 padding 넣어 중심 정렬)
        int padding = 5;
        int diameter = 70; // 80 - padding*2
        g2.setColor(isEmpty? Color.LIGHT_GRAY : Color.WHITE);
        g2.fillOval(padding, padding, diameter, diameter);

        // 테두리
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));
        g2.drawOval(padding, padding, diameter, diameter);

        // 글씨 그리기 (중앙 정렬)
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("맑은 고딕", Font.BOLD, 20)); // 사이즈 조정
        FontMetrics fm = g2.getFontMetrics();
        int textWidth = fm.stringWidth(resultText);
        int textHeight = fm.getAscent();

        int centerX = padding + diameter / 2 - textWidth / 2;
        int centerY = padding + diameter / 2 + textHeight / 2 - 4;

        g2.drawString(resultText, centerX, centerY);
    }
}