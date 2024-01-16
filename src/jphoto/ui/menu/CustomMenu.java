package jphoto.ui.menu;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import jphoto.MainPanel;

public class CustomMenu extends JMenuBar {
    JMenu file, cryptography, encryption, decryption, filter, blur;
    JMenuItem open, save, saveAs, aes128CBCEncryption, aes128CBCDecryption;
    JMenuItem gaussianBlur, meanBlur, grayScale, blackAndWhite;
    MainPanel mainPanel;

    public CustomMenu(MainPanel mainPanel) {
        super();
        this.mainPanel = mainPanel;
        this.setSubmenus();
    }

    private void setSubmenus() {
        file = new JMenu("Fichier");
        this.add(file);

        open = new OpenButton(mainPanel);
        save = new JMenuItem("Enregistrer");
        saveAs = new JMenuItem("Enregistrer sous");
        file.add(open);
        file.add(save);
        file.add(saveAs);

        filter = new JMenu("Filtres");
        blur = new JMenu("Flous");
        gaussianBlur = new JMenuItem("Flou gaussien");
        meanBlur = new JMenuItem("Flou par moyenne");
        grayScale = new GrayScaleButton(mainPanel);
        blackAndWhite = new BlackAndWhiteButton(mainPanel);

        blur.add(gaussianBlur);
        blur.add(meanBlur);
        filter.add(blur);
        filter.add(grayScale);
        filter.add(blackAndWhite);
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
