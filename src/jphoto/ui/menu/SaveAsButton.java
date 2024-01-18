package jphoto.ui.menu;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;

import jphoto.system.CustomImage;

class SaveAsButton extends VMenuItem {
    private CustomMenu menu;
    private JFileChooser fileChooser;
    private OpenButton openButton;

    SaveAsButton(CustomMenu menu) {
        super("Enregistrer sous");
        this.menu = menu;
        openButton = (OpenButton)menu.open;
        fileChooser = openButton.getFileChooser();
    }

    public void actionPerformed(ActionEvent e) {
        fileChooser.showOpenDialog(null);
        String extension;
        File outputFile = fileChooser.getSelectedFile();
        CustomImage image = menu.mainPanel.getImagePanel().getImage();

        if(outputFile!=null) {
            if(!outputFile.exists()) {
                try {
                    outputFile.createNewFile();
                } catch(IOException ex) {
                }
            }

            openButton.setSelectedFile(outputFile);

            if(outputFile.getName().endsWith(".jpg")) {
                extension = "jpeg";
            } else if(outputFile.getName().endsWith(".jpeg")) {
                extension = "jpeg";
            } else {
                extension = "png";
            }

            try {
                ImageIO.write(image, extension, outputFile);
            } catch(IOException ex) {
            }
        }
    }
}
