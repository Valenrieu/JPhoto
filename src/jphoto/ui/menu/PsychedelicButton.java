package jphoto.ui.menu;

import java.awt.event.ActionEvent;

import jphoto.MainPanel;
import jphoto.system.CustomImage;
import jphoto.system.filters.PsychedelicFilter;

class PsychedelicButton extends VMenuItem {
    private MainPanel mainPanel;

    PsychedelicButton(MainPanel mainPanel) {
        super("Filtre psychédélique");
        this.mainPanel = mainPanel;
    }

    public void actionPerformed(ActionEvent e) {
        CustomImage image = mainPanel.getImagePanel().getImage();

        if(image!=null) {
            PsychedelicFilter filter = new PsychedelicFilter(image);
            mainPanel.getImagePanel().applyFilter(filter);
        }
    }
}
