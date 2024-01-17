package jphoto.ui.menu;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import jphoto.MainPanel;
import jphoto.system.CustomImage;
import jphoto.system.filters.blurs.GaussianBlur;
import static jphoto.Constants.KERNEL_SIZE;

class GaussianBlurButton extends VMenuItem {
    private MainPanel mainPanel;
    private Integer kernelSize = null;

    GaussianBlurButton(MainPanel mainPanel) {
        super("Flou gaussien");
        this.mainPanel = mainPanel;
    }

    public void actionPerformed(ActionEvent e) {
        CustomImage image = mainPanel.getImagePanel().getImage();
        Integer[] options = GaussianBlur.getkernelSizePossibilities(image);
        String message = "Un noyau de grande taille produira un flou plus puissant. Un noyau de taille 1 "
                         +"n'aura aucun effet.\nPlus le noyau est grand, plus le temps de calcul est important.";

        kernelSize = (Integer)JOptionPane.showInputDialog(null, message, "Choix de la taille du noyau",
                     JOptionPane.QUESTION_MESSAGE, null, options, KERNEL_SIZE);

        if(image!=null && kernelSize!=null) {
            try {
                GaussianBlur filter = new GaussianBlur(image, kernelSize);
                mainPanel.getImagePanel().applyFilter(filter);
            } catch(IllegalArgumentException ex) {
            }
        }
    }
}
