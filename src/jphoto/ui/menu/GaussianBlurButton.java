package jphoto.ui.menu;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JPanel;

import jphoto.MainPanel;
import jphoto.system.CustomImage;
import jphoto.system.filters.blurs.GaussianBlur;
import static jphoto.Constants.KERNEL_SIZE;
import static jphoto.Constants.GAUSSIAN_STANDARD_DEVIATION;
import static jphoto.Constants.MAX_GAUSSIAN_STANDARD_DEVIATION;
import static jphoto.Constants.MIN_GAUSSIAN_STANDARD_DEVIATION;

class GaussianBlurButton extends VMenuItem {
    private MainPanel mainPanel;

    GaussianBlurButton(MainPanel mainPanel) {
        super("Flou gaussien");
        this.mainPanel = mainPanel;
    }

    public void actionPerformed(ActionEvent e) {
        CustomImage image = mainPanel.getImagePanel().getImage();
        Integer[] options = GaussianBlur.getkernelSizePossibilities(image);
        String message = "Un noyau de grande taille produira un flou plus puissant.\n" +
                "Plus le noyau est grand, plus le temps de calcul est important.";

        Integer kernelSize = (Integer)JOptionPane.showInputDialog(
                null,
                message,
                "Choix de la taille du noyau",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                KERNEL_SIZE);

        if(kernelSize == null) {
            return;
        }

        JSlider slider = new JSlider((int)(MIN_GAUSSIAN_STANDARD_DEVIATION*10), (int)(MAX_GAUSSIAN_STANDARD_DEVIATION*10));
        slider.setMajorTickSpacing(1);
        slider.setValue((int)(GAUSSIAN_STANDARD_DEVIATION * 10));

        JPanel panel = new JPanel();
        panel.add(slider);

        javax.swing.JLabel sigmaLabel = new JLabel("Sigma : " + (slider.getValue()/10d));
        panel.add(sigmaLabel);

        slider.addChangeListener(e1 -> {
            sigmaLabel.setText("Sigma : " + (slider.getValue()/10d));
        });

        int sigmaChoice = JOptionPane.showOptionDialog(
                null,
                panel,
                "Choix de l'écart type",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null
        );

        if(sigmaChoice != JOptionPane.OK_OPTION) {
            return;
        }

        if(image != null) {
            try {
                GaussianBlur filter = new GaussianBlur(image, kernelSize, (double)slider.getValue()/10d);
                mainPanel.getImagePanel().applyFilter(filter);
            } catch(IllegalArgumentException ex) {
            }
        }
    }
}