package swing;

import java.awt.event.ActionListener;
import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class Start extends JPanel {

    private MainFrame mainFrame;
    private final Map<String, BufferedImage> images = new HashMap<>();

    private final String screenName = "start";
    private final List<String> imageNames = new ArrayList<>();

    public Start(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(null);

        // 배경 이미지 로딩
        getFileName();
        imageLoading();

        JButton startButton = null;
        JButton exitButton = null;
        if (imageNames.contains("startButton.png")) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/start/startButton.png"));
            startButton = createImageButton(icon, e -> {
                System.out.println("게임 시작!");
            });
            startButton.setBounds(820, 280, icon.getIconWidth(), icon.getIconHeight());
        }

        if (imageNames.contains("exitButton.png")) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/start/exitButton.png"));
            exitButton = createImageButton(icon, e -> {
                System.out.println("게임 종료!");
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

    private void getFileName() {
        URL resource = getClass().getResource("/" + screenName);
        if(resource != null) {
            File folder = new File(resource.getPath());  // 이미지가 위치한 폴더
            File[] files = folder.listFiles((dir, name) -> name.endsWith(".png"));
            if(files != null) {
                for (File file : files) {
                    imageNames.add(file.getName());
                }
            } else {
                System.out.println("File not found");
            }
        }

    }

    private void imageLoading() {
        try {
            for (String imageName : imageNames) {
                String imagePath = screenName + "/" + imageName;
                URL imageUrl = getClass().getClassLoader().getResource(imagePath);
                if (imageUrl != null) {
                    BufferedImage img = ImageIO.read(imageUrl);
                    images.put(imageName, img); // 이미지 이름으로 저장
                } else {
                    System.err.println("이미지를 찾을 수 없습니다: " + imagePath);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
