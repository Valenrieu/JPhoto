package jphoto.ui.sidepanel;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

import jphoto.ui.VButton;

public class PaintBrushButton extends VButton {
    private JPanel mainPanel;
    private boolean isPressed = false;

    PaintBrushButton(JPanel mainPanel) {
        super(new ImageIcon("res/icons/paint_brush.png"));
        this.mainPanel = mainPanel;
    }

    public boolean isPressed() {
        return isPressed;
    }

    public void actionPerformed(ActionEvent e) {
        isPressed = !isPressed;

        if(isPressed) {
            mainPanel.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        } else {
            mainPanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }
}
