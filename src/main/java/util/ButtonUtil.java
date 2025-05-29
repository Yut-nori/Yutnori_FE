package util;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ButtonUtil {
    public static JButton createImageButton(ImageIcon icon, ActionListener action) {
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

    public static JButton createButtonIfExists(java.util.List<String> imageNames, String imageName,
                                               String folderName, int x, int y, ActionListener listener) {
        if (!imageNames.contains(imageName)) return null;

        ImageIcon icon = new ImageIcon(ButtonUtil.class.getResource("/" + folderName + "/" + imageName));
        JButton button = createImageButton(icon, listener);
        button.setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());
        return button;
    }
}
