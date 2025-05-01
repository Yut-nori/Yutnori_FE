package swing.gameBoard.RightPanel;

import javax.swing.*;
import java.awt.*;

class TrackerPanel extends JPanel {
    public TrackerPanel(int playerNumber) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);

        PlayerUnitPanel player1Panel = new PlayerUnitPanel("Player 1", Color.RED);
        PlayerUnitPanel player2Panel = new PlayerUnitPanel("Player 2", Color.BLUE);
        PlayerUnitPanel player3Panel = new PlayerUnitPanel("Player 3", Color.GREEN);
        PlayerUnitPanel player4Panel = new PlayerUnitPanel("Player 4", Color.YELLOW);


        for (PlayerUnitPanel p : new PlayerUnitPanel[]{player1Panel, player2Panel, player3Panel, player4Panel}) {
            p.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(p);
        }


    }
}