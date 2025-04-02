package swing;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
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
        setLayout(new BorderLayout());

        // 배경 이미지 로딩
        getFileName();
        imageLoading();

        JLabel titleLabel = new JLabel("Start Game?", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel, BorderLayout.CENTER);
    }

    private void getFileName() {
        File folder = new File("/resources/" + screenName);  // 이미지가 위치한 폴더
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".png"));
        if(files != null) {
            for (File file : files) {
                imageNames.add(file.getName());
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

        if (images.get("mascort.png") != null) {
            g.drawImage(images.get("mascort.png"), 100, 100, 80, 80, this);  // 예시 좌표
        }

        if (images.get("yut.png") != null) {
            g.drawImage(images.get("yut.png"), 300, 300, 100, 100, this);  // 예시 좌표
        }

        // etc...
    }

}
