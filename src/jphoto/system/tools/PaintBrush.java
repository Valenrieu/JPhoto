package jphoto.system.tools;

import java.awt.Color;

import jphoto.system.CustomImage;
import static jphoto.system.utils.ImageUtils.getARGBFromInt;

public class PaintBrush {
    private Color color;
    private int radius;
    private int[] argb;

    public PaintBrush(Color color, int radius) {
        this.color = color;
        this.radius = radius;
        argb = getARGBFromInt(color.getRGB());
    }

    public void paint(CustomImage image, int x, int y) {
        for(int i=x-radius; i<x+radius; i++) {
            for(int j=y-radius; j<y+radius; j++) {
                if(Math.pow(i-x, 2) + Math.pow(j-y, 2) <= Math.pow(radius, 2)) {
                    try {
                        image.setARGB(i, j, argb);
                    } catch(ArrayIndexOutOfBoundsException e) {
                        continue;
                    }
                }
            }
        }
    }
}
