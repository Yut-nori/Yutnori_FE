package swing.gameBoard.RightPanel;

import javax.swing.*;
import java.awt.*;

class UnitIcon extends JComponent {
    private final Color color;
    private final int diameter;
    private final int thickness;

    public UnitIcon(Color color, int diameter) {
        this.color = color;
        this.diameter = diameter;
        this.thickness = 2;

        int fullSize = diameter + thickness;
        setPreferredSize(new Dimension(fullSize, fullSize));
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 말 채우기
        int offset = thickness / 2;
        g2.setColor(color);
        g2.fillOval(offset, offset, diameter, diameter);

        // 테두리
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(thickness));
        g2.drawOval(offset, offset, diameter, diameter);
    }
}