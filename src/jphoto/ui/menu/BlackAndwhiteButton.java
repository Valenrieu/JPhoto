package jphoto.ui.menu;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import jphoto.MainPanel;
import jphoto.system.CustomImage;
import jphoto.system.filters.BlackAndWhiteFilter;
import static jphoto.Constants.BLACK_AND_WHITE_THRESHOLD;

class BlackAndWhiteButton extends VMenuItem {
    private MainPanel mainPanel;
    private Integer threshold = null;

    BlackAndWhiteButton(MainPanel mainPanel) {
        super("Noir et blanc");
        this.mainPanel = mainPanel;
    }

    void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public void actionPerformed(ActionEvent e) {
        CustomImage image = mainPanel.getImagePanel().getImage();
        Integer[] options = BlackAndWhiteFilter.getThresholdPossibilites();

        try {
            threshold = (Integer)JOptionPane.showInputDialog(null, "Seuil",
                        "Choix du seuil", JOptionPane.QUESTION_MESSAGE, null, options, BLACK_AND_WHITE_THRESHOLD);
        } catch(NumberFormatException ex) {
            return;
        }

        if(image!=null && threshold!=null) {
            BlackAndWhiteFilter filter = new BlackAndWhiteFilter(image, threshold);
            mainPanel.getImagePanel().applyFilter(filter);
        }
    }
}
