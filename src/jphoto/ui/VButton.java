package jphoto.ui;

import javax.swing.JButton;
import javax.swing.Icon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/* Classe abstraite dont tous les boutons vont heriter
 * pour etre sur qu'ils aient un ActionListener.
 */

public abstract class VButton extends JButton implements ActionListener {
    public VButton(Icon icon) {
        super(icon);
        this.addActionListener(this);
    }

    public VButton(String text) {
        super(text);
        this.addActionListener(this);
    }

    public VButton(String text, Icon icon) {
        super(text, icon);
        this.addActionListener(this);
    }

    public abstract void actionPerformed(ActionEvent e);
}
