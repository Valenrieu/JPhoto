package jphoto.ui.menu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

abstract class VMenuItem extends JMenuItem implements ActionListener {
    VMenuItem(String text) {
        super(text);
        this.addActionListener(this);
    }

    public abstract void actionPerformed(ActionEvent e);
}
