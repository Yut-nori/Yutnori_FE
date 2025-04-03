package swing.gameboard;


import javax.swing.*;
import java.awt.*;

class TopPanel extends JPanel {
    public TopPanel() {
        setLayout(null);
        setBounds(310, 0, 660, 60);

        // Create TextLabel
        JLabel turnLabel = new JLabel("Turn: Player 1");
        turnLabel.setFont(new Font("Arial", Font.BOLD, 30));
        turnLabel.setForeground(Color.WHITE);

        // Locate label to center
        turnLabel.setHorizontalAlignment(SwingConstants.CENTER);
        turnLabel.setVerticalAlignment(SwingConstants.CENTER);
        turnLabel.setBounds(0, 0, 660, 60);

        // Set panel and label to transparent
        turnLabel.setOpaque(false);
        setOpaque(false);

        add(turnLabel);
    }
}