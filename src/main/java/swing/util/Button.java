package swing.util;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Button {
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
}
