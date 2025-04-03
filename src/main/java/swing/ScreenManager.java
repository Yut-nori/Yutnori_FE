package swing;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ScreenManager {
    public static Map<String, JPanel> getScreens(MainFrame mainFrame) {
        Map<String, JPanel> screens = new LinkedHashMap<>();

        // 여기에 화면을 추가
        screens.put("start", new Start(mainFrame));
        screens.put("setting", new Setting(mainFrame));

        return screens;
    }
}
