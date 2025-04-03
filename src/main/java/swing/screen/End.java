package swing.screen;

import swing.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static swing.util.Button.createImageButton;
import static swing.util.File.getFileName;
import static swing.util.File.imageLoading;

public class End extends JPanel {
    private final String screenName = "end";

    private Map<String, BufferedImage> images = new HashMap<>();

    public End(MainFrame mainFrame) {
        setLayout(null);

        // 배경 이미지 로딩
        List<String> imageNames = getFileName(screenName);
        images = imageLoading(imageNames, screenName);

        JButton startButton = null;
        JButton exitButton = null;
        if (imageNames.contains("startButton.png")) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/end/startButton.png"));
            startButton = createImageButton(icon, e -> {
                mainFrame.showCard("setting");
            });
            startButton.setBounds(400, 280, icon.getIconWidth(), icon.getIconHeight());
        }

        if (imageNames.contains("exitButton.png")) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/end/exitButton.png"));
            exitButton = createImageButton(icon, e -> {
                System.out.println("게임 종료!");
                System.exit(0);  // 콘솔 프로그램 종료
            });
            exitButton.setBounds(470, 460, icon.getIconWidth(), icon.getIconHeight());
        }


        add(startButton);
        add(exitButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (images.get("background.png") != null) {
            g.drawImage(images.get("background.png"), 0, 0, getWidth(), getHeight(), this);
        }

        if (images.get("man.png") != null) {
            Image img = images.get("man.png");
            int imgWidth = img.getWidth(this);
            int imgHeight = img.getHeight(this);
            g.drawImage(img, 50, 100, imgWidth, imgHeight, this);
        }

        if (images.get("woman.png") != null) {
            Image img = images.get("woman.png");
            int imgWidth = img.getWidth(this);
            int imgHeight = img.getHeight(this);
            g.drawImage(img, 850, 100, imgWidth, imgHeight, this);
        }

        if (images.get("title.png") != null) {
            Image img = images.get("title.png");
            int imgWidth = img.getWidth(this);
            int imgHeight = img.getHeight(this);
            g.drawImage(img, 480, 30, imgWidth, imgHeight, this);
        }

        if (images.get("winner.png") != null) {
            Image img = images.get("winner.png");
            int imgWidth = img.getWidth(this);
            int imgHeight = img.getHeight(this);
            g.drawImage(img, 450, 180, imgWidth, imgHeight, this);
        }
    }
}
