package jphoto.ui.sidepanel;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Box;
import java.awt.Dimension;

import jphoto.MainPanel;

public class SidePanel extends JPanel {
    public final MainPanel mainPanel;
    private JPanel layout1, layout2;
    private PaintBrushButton paintBrushButton;
    private BrushSizeSpinner brushSizeSpinner;
    private ColorPicker colorPicker;
    private InvertButton invertButton;

    public SidePanel(MainPanel mainPanel) {
        super();
        this.mainPanel = mainPanel;
        this.addContent();
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    public PaintBrushButton getPaintBrushButton() {
        return paintBrushButton;
    }

    public ColorPicker getColorPicker() {
        return colorPicker;
    }

    public BrushSizeSpinner getBrushSizeSpinner() {
        return brushSizeSpinner;
    }

    private void addContent() {
        layout1 = new JPanel();
        paintBrushButton = new PaintBrushButton(mainPanel);
        layout1.add(paintBrushButton);
        brushSizeSpinner = new BrushSizeSpinner(mainPanel);
        layout1.add(brushSizeSpinner);
        this.add(layout1);

        layout2 = new JPanel();
        colorPicker = new ColorPicker(mainPanel);
        layout2.add(new JLabel("Couleur du pinceau"));
        layout2.add(colorPicker);
        this.add(layout2);

        invertButton = new InvertButton(mainPanel);
        this.add(invertButton);

        Box.Filler glue = (Box.Filler)Box.createVerticalGlue();
        glue.changeShape(glue.getMinimumSize(), new Dimension(0, Short.MAX_VALUE), glue.getMaximumSize());
        this.add(glue);
    }
}
