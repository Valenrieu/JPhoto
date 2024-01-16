package jphoto.ui.sidepanel;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

import jphoto.MainPanel;

public class RyanGoslingButton extends ToolButton {
    private BufferedImage ryanGosling = null;
    private Cursor ryanGoslingCursor;

    RyanGoslingButton(MainPanel mainPanel) {
        super(new ImageIcon("res/ryan_gosling/ryan_gosling-icon.png"), mainPanel);

        try {
            ryanGosling = ImageIO.read(new File("res/ryan_gosling/ryan_gosling-icon.png"));
        } catch(IOException e) {
        }

        Point point = new Point(0, 0);
        ryanGoslingCursor = Toolkit.getDefaultToolkit().createCustomCursor(ryanGosling, point, "ryanGoslingCursor");
    }

    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);

        if(isPressed) {
            mainPanel.setCursor(ryanGoslingCursor);
        } else {
            mainPanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }
}
