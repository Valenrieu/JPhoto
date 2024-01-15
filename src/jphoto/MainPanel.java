package jphoto;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import jphoto.system.ImagePanel;
import jphoto.ui.sidepanel.SidePanel;

public class MainPanel extends JPanel {
    private SidePanel sidePanel = new SidePanel(this);
    private ImagePanel imagePanel = new ImagePanel(this);

    public MainPanel() {
        super();
        this.setLayout(new BorderLayout());
        this.addComponents();
    }

    public SidePanel getSidePanel() {
        return sidePanel;
    }

    public ImagePanel getImagePanel() {
        return imagePanel;
    }

    private void addComponents() {
        this.add(sidePanel, BorderLayout.EAST);
        this.add(imagePanel, BorderLayout.CENTER);
    }
}
