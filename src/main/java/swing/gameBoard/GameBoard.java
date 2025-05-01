package swing.gameBoard;

import swing.MainFrame;
import swing.ScreenManager;
import swing.gameBoard.leftPanel.LeftPanel;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.awt.*;
import java.util.Map;

import static swing.util.File.getFileName;
import static swing.util.File.imageLoading;

public class GameBoard extends JPanel {
    private final String screenName = "GameBoard";

    private Map<String, BufferedImage> images = new HashMap<>();

    public GameBoard(ScreenManager sm) {
        setLayout(null);

        // 배경 이미지 로딩
        List<String> imageNames = getFileName(screenName);
        images = imageLoading(imageNames, screenName);


        // 패널 생성
        MainBoard mainBoard = new MainBoard();
        LeftPanel leftPanel = new LeftPanel();
        RightPanel rightPanel = new RightPanel();
        TopPanel topPanel = new TopPanel();

        // 패널 추가
        add(mainBoard);
        add(leftPanel);
        add(rightPanel);
        add(topPanel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 배경 이미지 그리기
        if (images.get("background.png") != null) {
            g.drawImage(images.get("background.png"), 0, 0, getWidth(), getHeight(), this);
        }
    }

    @Override
    public void repaint() {
        // 백엔드한테 데이터를 받아서
        // Controller controller = new Controller();
        // controller.getData();
    }

}







