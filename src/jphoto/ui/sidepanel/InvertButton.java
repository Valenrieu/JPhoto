package jphoto.ui.sidepanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

import jphoto.MainPanel;
import jphoto.system.CustomImage;
import jphoto.system.filters.NegativeFilter;

public class InvertButton extends JCheckBox implements ActionListener {
    private MainPanel mainPanel;

    public InvertButton(MainPanel mainPanel) {
        super("Négatif", false);
        this.mainPanel = mainPanel;
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        CustomImage image = mainPanel.getImagePanel().getImage();

        if(image!=null) {
            NegativeFilter filter = new NegativeFilter(image);
            mainPanel.getImagePanel().applyFilter(filter);
        }
    }
}
