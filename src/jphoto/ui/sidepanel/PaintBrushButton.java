package jphoto.ui.sidepanel;

import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

import jphoto.MainPanel;

public class PaintBrushButton extends ToolButton {
    PaintBrushButton(MainPanel mainPanel) {
        super(new ImageIcon("res/icons/paint_brush.png"), mainPanel);
    }

    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);

        if(isPressed) {
            mainPanel.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        } else {
            mainPanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }
}
