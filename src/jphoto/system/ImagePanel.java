package jphoto.system;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

import jphoto.MainPanel;
import jphoto.system.tools.PaintBrush;
import jphoto.system.filters.Filter;
import static jphoto.Constants.BRUSH_COLOR;
import static jphoto.Constants.BRUSH_SIZE;

public class ImagePanel extends JPanel implements MouseMotionListener, MouseListener {
    private MainPanel mainPanel;
    private CustomImage image;
    private PaintBrush paintBrush = new PaintBrush(BRUSH_COLOR, BRUSH_SIZE);

    public ImagePanel(MainPanel mainPanel) {
        super();
        this.mainPanel = mainPanel;
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    public void setImage(CustomImage image) {
        this.image = image;
        this.repaint();
    }

    public CustomImage getImage() {
        return image;
    }

    public void applyFilter(Filter filter) {
        filter.compute();
        this.repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        if(image!=null) {
            g2.drawImage(image, null, 0, 0);
        }
    }

    public void setPaintBrush(PaintBrush paintBrush) {
        this.paintBrush = paintBrush;
    }

    public void mouseDragged(MouseEvent e) {
        if(!mainPanel.getSidePanel().getPaintBrushButton().isPressed()) {
            return;
        }

        Point coordinates = MouseInfo.getPointerInfo().getLocation();
        Point coordinates2 = this.getLocationOnScreen();
        int x = (int)coordinates.getX() - (int)coordinates2.getX();
        int y = (int)coordinates.getY() - (int)coordinates2.getY();
        paintBrush.paint(image, x, y);

        this.repaint();
    }

    public void mouseClicked(MouseEvent e) {
        if(!mainPanel.getSidePanel().getPaintBrushButton().isPressed()) {
            return;
        }

        Point coordinates = MouseInfo.getPointerInfo().getLocation();
        Point coordinates2 = this.getLocationOnScreen();
        int x = (int)coordinates.getX() - (int)coordinates2.getX();
        int y = (int)coordinates.getY() - (int)coordinates2.getY();
        paintBrush.paint(image, x, y);

        this.repaint();
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }
}
