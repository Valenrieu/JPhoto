package jphoto.ui.menu;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class CustomMenu extends JMenuBar {
    JMenu file, cryptography, encryption, decryption;
    JMenuItem save, saveAs, aes128CBCEncryption, aes128CBCDecryption;

    public CustomMenu() {
        super();
        this.setSubmenus();
    }

    private void setSubmenus() {
        file = new JMenu("Fichier");
        this.add(file);

        cryptography = new JMenu("Cryptographie");
        encryption = new JMenu("Chiffrer");
        decryption = new JMenu("Déchiffrer");
        aes128CBCEncryption = new JMenuItem("AES 128 bits avec CBC");
        aes128CBCDecryption = new JMenuItem("AES 128 bits avec CBC");

        encryption.add(aes128CBCEncryption);
        decryption.add(aes128CBCDecryption);
        cryptography.add(encryption);
        cryptography.add(decryption);
        this.add(cryptography);

        save = new JMenuItem("Enregistrer");
        saveAs = new JMenuItem("Enregistrer sous");
        file.add(save);
        file.add(saveAs);
    }
}
