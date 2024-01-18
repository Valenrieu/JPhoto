package jphoto;

import java.util.List;
import java.util.ArrayList;
import java.awt.Image;
import javax.swing.ImageIcon;

class IconManager {
    final List<Image> iconList = new ArrayList<Image>();

    IconManager() {
        loadIcons();
    }

    void loadIcons() {
        iconList.add(new ImageIcon("res/icons/icon_16.png").getImage());
        iconList.add(new ImageIcon("res/icons/icon_32.png").getImage());
        iconList.add(new ImageIcon("res/icons/icon_64.png").getImage());
        iconList.add(new ImageIcon("res/icons/icon_128.png").getImage());
    }
}
