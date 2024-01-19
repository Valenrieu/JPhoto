package jphoto.ui.menu;

import java.awt.event.ActionEvent;

import jphoto.MainPanel;
import jphoto.system.CustomImage;
import jphoto.system.filters.NeonFilter;

class NeonButton extends VMenuItem {
    private MainPanel mainPanel;

    NeonButton(MainPanel mainPanel) {
        super("Filtre néon");
        this.mainPanel = mainPanel;
    }

    public void actionPerformed(ActionEvent e) {
        CustomImage image = mainPanel.getImagePanel().getImage();

        if(image!=null) {
            NeonFilter filter = new NeonFilter(image);
            mainPanel.getImagePanel().applyFilter(filter);
        }
    }
}
