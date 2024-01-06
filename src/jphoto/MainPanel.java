package jphoto;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import jphoto.ui.sidepanel.SidePanel;

public class MainPanel extends JPanel {
    SidePanel sidePanel = new SidePanel(this);

    public MainPanel() {
        super();
        this.setLayout(new BorderLayout());
        this.addComponents();
    }

    private void addComponents() {
        this.add(sidePanel, BorderLayout.EAST);
    }
}
