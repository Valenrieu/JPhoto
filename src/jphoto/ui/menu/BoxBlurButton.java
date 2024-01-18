package jphoto.ui.menu;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import jphoto.MainPanel;
import jphoto.system.CustomImage;
import jphoto.system.filters.blurs.BoxBlur;
import static jphoto.Constants.KERNEL_SIZE;

class BoxBlurButton extends VMenuItem {
    private MainPanel mainPanel;
    private Integer kernelSize = null;

    BoxBlurButton(MainPanel mainPanel) {
        super("Flou par moyennes");
        this.mainPanel = mainPanel;
    }

    public void actionPerformed(ActionEvent e) {
        CustomImage image = mainPanel.getImagePanel().getImage();
        Integer[] options = BoxBlur.getkernelSizePossibilities(image);
        String message = "Un noyau de grande taille produira un flou plus puissant."+
                         "\nPlus le noyau est grand, plus le temps de calcul est important.";

        kernelSize = (Integer)JOptionPane.showInputDialog(null, message, "Choix de la taille du noyau",
                     JOptionPane.QUESTION_MESSAGE, null, options, KERNEL_SIZE);

        if(image!=null && kernelSize!=null) {
            try {
                BoxBlur filter = new BoxBlur(image, kernelSize);
                mainPanel.getImagePanel().applyFilter(filter);
            } catch(IllegalArgumentException ex) {
            }
        }
    }
}
