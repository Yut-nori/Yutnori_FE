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
        setOpaque(false);
        switch (shape) {
            case 4:
                setBounds(310, 60, 660, 640);
                break;
            case 5:
                setBounds(315, 70, 690, 690);
                break;
            case 6:
                setBounds(320, 60, 660, 660);
                break;
        }
        this.shape = shape;

        List<String> imageNames = getFileName(screenName);
        images = imageLoading(imageNames, screenName);

        //ㅎㅎ 선물
        for(int i = 0; i < shape * 7 + 1; i++) {
            addUnit(UnitPosition.pentagonUnitPositions[i][0],
                    UnitPosition.pentagonUnitPositions[i][1],
                    Color.BLUE);
        }
    }

    private void addUnit(int x, int y, Color color) {
        UnitIcon unit = new UnitIcon(color);
        unit.setBounds(x, y, 30, 30);
        this.add(unit);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        switch(shape) {
            case 4:
                g.drawImage(images.get("rectangle.png"), 0, 0, getWidth(), getHeight(), this);
                break;
            case 5:
                g.drawImage(images.get("pentagon.png"), 0, 0, getWidth(), getHeight(), this);
                break;
            case 6:
                g.drawImage(images.get("hexagon.png"), 0, 0, getWidth(), getHeight(), this);
                break;
            default:
                break;
        }

    }
}