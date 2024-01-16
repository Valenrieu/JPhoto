package jphoto.system;

import java.awt.image.BufferedImage;

import static jphoto.system.utils.ImageUtils.getARGBFromArray;
import static jphoto.system.utils.ImageUtils.getARGBFromInt;

public class CustomImage extends BufferedImage {
    public final int height = this.getHeight();
    public final int width = this.getWidth();

    public CustomImage(BufferedImage image) {
        super(image.getWidth(), image.getHeight(), image.getType());
        this.getGraphics().drawImage(image, 0, 0, null);
    }

    public int[] getARGBArray(int x, int y) {
        return getARGBFromInt(this.getRGB(x, y));
    }

    public void setARGB(int x, int y, int[] argb) {
        this.setRGB(x, y, getARGBFromArray(argb));
    }
}
