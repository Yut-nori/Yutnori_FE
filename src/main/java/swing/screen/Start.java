package swing.screen;

import swing.MainFrame;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;

import static swing.util.File.getFileName;
import static swing.util.File.imageLoading;

public class Start extends JPanel {
    private final String screenName = "start";

    private Map<String, BufferedImage> images = new HashMap<>();

    public Start(MainFrame mainFrame) {
        setLayout(null);

        // 배경 이미지 로딩
        List<String> imageNames = getFileName(screenName);
        images = imageLoading(imageNames, screenName);

        JButton startButton = null;
        JButton exitButton = null;
        if (imageNames.contains("startButton.png")) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/start/startButton.png"));
            startButton = createImageButton(icon, e -> {
                mainFrame.showCard("setting");
            });
            startButton.setBounds(820, 280, icon.getIconWidth(), icon.getIconHeight());
        }

        if (imageNames.contains("exitButton.png")) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/start/exitButton.png"));
            exitButton = createImageButton(icon, e -> {
                System.out.println("게임 종료!");
                System.exit(0);  // 콘솔 프로그램 종료
            });
            exitButton.setBounds(850, 460, icon.getIconWidth(), icon.getIconHeight());
        }


        add(startButton);
        add(exitButton);
    }

    private JButton createImageButton(ImageIcon icon, ActionListener action) {
        JButton button = new JButton(icon);

        // 버튼을 이미지처럼 보이게 설정
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);

        // 이벤트 추가
        button.addActionListener(action);

        return button;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (images.get("background.png") != null) {
            g.drawImage(images.get("background.png"), 0, 0, getWidth(), getHeight(), this);
        }

        if (images.get("gameBoard.png") != null) {
            Image img = images.get("gameBoard.png");
            int imgWidth = img.getWidth(this);
            int imgHeight = img.getHeight(this);
            g.drawImage(img, 50, 170, imgWidth, imgHeight, this);
        }

        if (images.get("yut.png") != null) {
            Image img = images.get("yut.png");
            int imgWidth = img.getWidth(this);
            int imgHeight = img.getHeight(this);
            g.drawImage(img, 100, 40, imgWidth, imgHeight, this);
        }

        if (images.get("mascort.png") != null) {
            Image img = images.get("mascort.png");
            int imgWidth = img.getWidth(this);
            int imgHeight = img.getHeight(this);
            g.drawImage(img, 520, 300, imgWidth, imgHeight, this);
        }

        if (images.get("mascortAdd.png") != null) {
            Image img = images.get("mascortAdd.png");
            int imgWidth = img.getWidth(this);
            int imgHeight = img.getHeight(this);
            g.drawImage(img, 1040, 60, imgWidth, imgHeight, this);
        }

        if (images.get("gameName.png") != null) {
            Image img = images.get("gameName.png");
            int imgWidth = img.getWidth(this);
            int imgHeight = img.getHeight(this);
            g.drawImage(img, 700, 60, imgWidth, imgHeight, this);
        }
    }

}
