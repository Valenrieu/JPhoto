package jphoto.ui.menu;

import java.awt.event.ActionEvent;

import jphoto.MainPanel;
import jphoto.ui.PasswordDialog;
import jphoto.system.CustomImage;
import jphoto.system.cryptography.AES128CBC;
import jphoto.system.cryptography.CipherException;

class AES128CBCEncryptionButton extends VMenuItem {
    private MainPanel mainPanel;
    private PasswordDialog dialog;

    AES128CBCEncryptionButton(MainPanel mainPanel) {
        super("AES 128 bits avec CBC");
        this.mainPanel = mainPanel;
    }

    public void actionPerformed(ActionEvent e) {
        dialog = new PasswordDialog();
        String password = dialog.getPassword();
        CustomImage image = mainPanel.getImagePanel().getImage();

        if(image!=null && password!=null) {
            AES128CBC cipher = new AES128CBC(image.getBytes(), password);

            try {
                mainPanel.getImagePanel().setImage(CustomImage.getImageFromBytes(cipher.encrypt(), image.width, image.height));
            } catch(CipherException ex) {
                return;
            }
        }
    }
}
