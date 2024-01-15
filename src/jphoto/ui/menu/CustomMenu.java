package jphoto.ui.menu;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class CustomMenu extends JMenuBar {
    JMenu file, cryptography, encryption, decryption, filter, blur;
    JMenuItem save, saveAs, aes128CBCEncryption, aes128CBCDecryption;
    JMenuItem gaussianBlur, meanBlur;

    public CustomMenu() {
        super();
        this.setSubmenus();
    }

    private void setSubmenus() {
        file = new JMenu("Fichier");
        this.add(file);

        save = new JMenuItem("Enregistrer");
        saveAs = new JMenuItem("Enregistrer sous");
        file.add(save);
        file.add(saveAs);

        filter = new JMenu("Filtres");
        blur = new JMenu("Flous");
        gaussianBlur = new JMenuItem("Flou gaussien");
        meanBlur = new JMenuItem("Flou par moyenne");

        blur.add(gaussianBlur);
        blur.add(meanBlur);
        filter.add(blur);
        this.add(filter);

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
    }
}
