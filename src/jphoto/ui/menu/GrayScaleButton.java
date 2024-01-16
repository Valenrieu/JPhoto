package jphoto.ui.menu;

import java.awt.event.ActionEvent;

import jphoto.MainPanel;
import jphoto.system.CustomImage;
import jphoto.system.filters.GrayScaleFilter;

class GrayScaleButton extends VMenuItem {
    private MainPanel mainPanel;

    GrayScaleButton(MainPanel mainPanel) {
        super("Niveau de gris");
        this.mainPanel = mainPanel;
    }

    public void actionPerformed(ActionEvent e) {
        CustomImage image = mainPanel.getImagePanel().getImage();

        if(image!=null) {
            GrayScaleFilter filter = new GrayScaleFilter(image);
            mainPanel.getImagePanel().applyFilter(filter);
        }
    }
}