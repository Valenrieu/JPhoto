package jphoto.ui.sidepanel;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import jphoto.MainPanel;
import jphoto.system.tools.PaintBrush;
import static jphoto.Constants.BRUSH_COLOR;

public class ColorPicker extends JButton implements ActionListener {
    private Color color = BRUSH_COLOR;
    private MainPanel mainPanel;

    ColorPicker(MainPanel mainPanel) {
        super();
        this.setIcon(this.getColorIcon());
        this.addActionListener(this);
        this.mainPanel = mainPanel;
    }

    public void actionPerformed(ActionEvent e) {
        Color newColor = JColorChooser.showDialog(null, "Choisissez une couleur", color);

        if(newColor!=null) {
            color = newColor;
        }

        this.setIcon(this.getColorIcon());

        int radius = (int)mainPanel.getSidePanel().getBrushSizeSpinner().getValue();
        PaintBrush paintBrush = new PaintBrush(color, radius);
        mainPanel.getImagePanel().setPaintBrush(paintBrush);
    }

    private Icon getColorIcon() {
        BufferedImage image = new BufferedImage(32, 32, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();

        graphics.setPaint(color);
        graphics.fillRect(0, 0, image.getWidth(), image.getHeight());

        return new ImageIcon(image);
    }

    public Color getSelectedColor() {
        return color;
    }
}
