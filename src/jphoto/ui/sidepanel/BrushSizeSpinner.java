package jphoto.ui.sidepanel;

import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import jphoto.MainPanel;
import jphoto.system.tools.PaintBrush;
import static jphoto.Constants.BRUSH_SIZE;

/* Classe pour le selecteur de taille de pinceau
 * Min : 1, max 300, defaut 10, pas 1 et entiers seulement
 */

public class BrushSizeSpinner extends JSpinner implements ChangeListener {
    private MainPanel mainPanel;

    BrushSizeSpinner(MainPanel mainPanel) {
        super(new SpinnerNumberModel(BRUSH_SIZE, 1, 300, 1));
        this.mainPanel = mainPanel;
        this.addChangeListener(this);
    }

    public void stateChanged(ChangeEvent e) {
        Color color = mainPanel.getSidePanel().getColorPicker().getSelectedColor();
        PaintBrush paintBrush = new PaintBrush(color, (int)this.getValue());
        mainPanel.getImagePanel().setPaintBrush(paintBrush);
    }
}
