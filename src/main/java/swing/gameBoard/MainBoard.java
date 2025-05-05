package swing.gameBoard;

import swing.gameBoard.RightPanel.UnitIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static swing.util.File.getFileName;
import static swing.util.File.imageLoading;

class MainBoard extends JPanel {
    private final String screenName = "GameBoard";
    private Map<String, BufferedImage> images = new HashMap<>();
    private final int shape;
    public MainBoard(int shape) {
        setLayout(null);
        setBounds(310, 60, 660, 640);
        this.shape = shape;

        List<String> imageNames = getFileName(screenName);
        images = imageLoading(imageNames, screenName);


    }

    private void addUnit(int x, int y, Color color) {
        UnitIcon unit = new UnitIcon(color);
        unit.setBounds(x, y, 30, 30);
        this.add(unit);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(shape == 4)
            g.drawImage(images.get("rectangle.png"), 0, 0, getWidth(), getHeight(), this);
    }
}