package swing.gameBoard.RightPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UnitIcon extends JComponent {
    private final Color color;
    private final int diameter;
    private final int thickness;

    public UnitIcon(Color color) {
        this.color = color;
        this.diameter = 28;
        this.thickness = 2;

        int fullSize = diameter + thickness;
        setPreferredSize(new Dimension(fullSize, fullSize));
        setOpaque(false);

        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setToolTipText("말 클릭");

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("말 클릭됨!");
                // 여기에 콜백 또는 게임 로직 호출
            }
        });
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