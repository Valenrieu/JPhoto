package jphoto.ui.sidepanel;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class SidePanel extends JPanel {
    private JPanel mainPanel;

    public SidePanel(JPanel mainPanel) {
        super();
        this.mainPanel = mainPanel;
        this.addContent();
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    private void addContent() {
        this.add(new PaintBrushButton(mainPanel));
    }
}
