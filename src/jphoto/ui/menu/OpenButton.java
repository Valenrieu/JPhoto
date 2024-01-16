package jphoto.ui.menu;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import jphoto.MainPanel;
import jphoto.system.CustomImage;

class OpenButton extends VMenuItem {
    private File selectedFile = null;
    private JFileChooser fileChooser = new JFileChooser();
    private MainPanel mainPanel;

    OpenButton(MainPanel mainPanel) {
        super("Ouvrir");
        this.mainPanel = mainPanel;
        this.setValues();
    }

    private void setValues() {
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Images", "jpg", "jpeg", "png"));
        fileChooser.setApproveButtonText("Ouvrir");
        fileChooser.setDialogTitle("Choisir une image");
    }

    public File getSelectedFile() {
        return selectedFile;
    }

    public void actionPerformed(ActionEvent e) {
        fileChooser.showOpenDialog(null);

        if(fileChooser.getSelectedFile()!=null) {
            selectedFile = fileChooser.getSelectedFile();

            try {
                mainPanel.getImagePanel().setImage(new CustomImage(ImageIO.read(selectedFile)));
                mainPanel.getSidePanel().getInvertButton().setSelected(false);
            } catch(IOException ex) {

            }
        }
    }
}
