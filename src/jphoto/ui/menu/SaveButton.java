package jphoto.ui.menu;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;

import jphoto.system.CustomImage;

class SaveButton extends VMenuItem {
    private CustomMenu menu;

    SaveButton(CustomMenu menu) {
        super("Enregistrer");
        this.menu = menu;
    }

    public void actionPerformed(ActionEvent e) {
        OpenButton openButton = (OpenButton)menu.open;
        File outputFile = openButton.getSelectedFile();
        CustomImage image = menu.mainPanel.getImagePanel().getImage();
        String extension;

        if(!outputFile.exists()) {
            try {
                outputFile.createNewFile();
            } catch(IOException ex) {
            }
        }

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
