package jphoto.system;

import java.awt.image.BufferedImage;

import static jphoto.system.utils.ImageUtils.getRGBFromArray;
import static jphoto.system.utils.ImageUtils.getRGBFromInt;

public class CustomImage extends BufferedImage {
    public final int height = this.getHeight();
    public final int width = this.getWidth();

    public CustomImage(BufferedImage image) {
        super(image.getWidth(), image.getHeight(), image.getType());
        this.getGraphics().drawImage(image, 0, 0, null);
    }

    public int[] getRGBArray(int x, int y) {
        return getRGBFromInt(this.getRGB(x, y));
    }

    public void setRGB(int x, int y, int[] rgb) {
        this.setRGB(x, y, getRGBFromArray(rgb));
    }
}
