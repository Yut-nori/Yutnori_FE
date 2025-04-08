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

public class Setting extends JPanel {
    private final String screenName = "setting";

    private Map<String, BufferedImage> images = new HashMap<>();

    public Setting(MainFrame mainFrame) {
        setLayout(null);

        // 배경 이미지 로딩
        List<String> imageNames = getFileName(screenName);
        images = imageLoading(imageNames, screenName);

        // 🎯 인원 수 콤보박스 (2 ~ 4)
        JComboBox<String> playerComboBox = new JComboBox<>(new String[]{"2명", "3명", "4명"});
        playerComboBox.setBounds(500, 215, 300, 70); // 대략 회색 네모 위치에 맞게 조정
        styleComboBox(playerComboBox);
        add(playerComboBox);

        // 🎯 말 개수 콤보박스 (2 ~ 5)
        JComboBox<String> unitComboBox = new JComboBox<>(new String[]{"2개", "3개", "4개", "5개"});
        unitComboBox.setBounds(500, 330, 300, 70);
        styleComboBox(unitComboBox);
        add(unitComboBox);

        JButton startButton = null;
        JButton exitButton = null;
        if (imageNames.contains("startButton.png")) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/setting/startButton.png"));
            startButton = createImageButton(icon, e -> {
                System.out.println("게임 시작!");

                // 데이터를 넘겨서 repaint from backend
                // gb.repaint();

                /*

                    data = {
                        playerNum: comboBox.playerNum,
                        unitNum: comboBox.unitNum,
                        boardShape: comboBox.boardShape
                    }
                    controller.setGameSetting(data);

                    GameBoard gb = new GameBoard(data.playerNum, data.unitNum, data.boardShape);
                    frame.add(gb);
                 */

                // 소공 -> 클래스 생성 ~ 소멸 -> 효율적으로 사용

                // 1. showcard를 이용해서 swtich
                // 2. panel을 뗐다 붙였다 (frame 고정)

                mainFrame.showCard("gameBoard");
            });
            startButton.setBounds(500, 580, icon.getIconWidth(), icon.getIconHeight());
        }

        if (imageNames.contains("exitButton.png")) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/setting/exitButton.png"));
            exitButton = createImageButton(icon, e -> {
                System.out.println("게임 종료!");
                System.exit(0);
            });
            exitButton.setBounds(1030, 570, icon.getIconWidth(), icon.getIconHeight());
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

        if (images.get("screenName.png") != null) {
            Image img = images.get("screenName.png");
            int imgWidth = img.getWidth(this);
            int imgHeight = img.getHeight(this);
            g.drawImage(img, 250, 30, imgWidth, imgHeight, this);
        }

        if (images.get("playerNum.png") != null) {
            Image img = images.get("playerNum.png");
            int imgWidth = img.getWidth(this);
            int imgHeight = img.getHeight(this);
            g.drawImage(img, 150, 210, imgWidth, imgHeight, this);
        }

        if (images.get("unitNum.png") != null) {
            Image img = images.get("unitNum.png");
            int imgWidth = img.getWidth(this);
            int imgHeight = img.getHeight(this);
            g.drawImage(img, 150, 330, imgWidth, imgHeight, this);
        }

        if (images.get("boardShape.png") != null) {
            Image img = images.get("boardShape.png");
            int imgWidth = img.getWidth(this);
            int imgHeight = img.getHeight(this);
            g.drawImage(img, 130, 500, imgWidth, imgHeight, this);
        }
    }

    private void styleComboBox(JComboBox<String> comboBox) {
        comboBox.setFont(new Font("나눔손글씨 붓", Font.PLAIN, 30)); // 글씨를 부드럽게
        comboBox.setBackground(new Color(193, 144, 94)); // 따뜻한 나무 계열 배경
        comboBox.setForeground(Color.WHITE); // 글자 흰색
        comboBox.setFocusable(false);
        comboBox.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // 내부 여백

        // 드롭다운 항목 색도 같이 조정
        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                c.setBackground(isSelected ? new Color(160, 120, 80) : new Color(193, 144, 94));
                c.setForeground(Color.WHITE);
                setFont(new Font("나눔손글씨 붓", Font.PLAIN, 18));
                return c;
            }
        });
    }

}
