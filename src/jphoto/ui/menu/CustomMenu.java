package jphoto.ui.menu;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class CustomMenu extends JMenuBar {
    JMenu file;
    JMenuItem save, saveAs;

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
    }
}
