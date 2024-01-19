package jphoto.system;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import static jphoto.system.utils.ImageUtils.getARGBFromArray;
import static jphoto.system.utils.ImageUtils.getARGBFromInt;

public class CustomImage extends BufferedImage {
    public final int height = this.getHeight();
    public final int width = this.getWidth();

    public CustomImage(BufferedImage image) {
        super(image.getWidth(), image.getHeight(), image.getType());
        this.getGraphics().drawImage(image, 0, 0, null);
    }

    public byte[] getBytes() {
        return ((DataBufferByte)this.getRaster().getDataBuffer()).getData();
    }

    public int[][] getSubRGB(int x, int y, int size) {
        int[][] res = new int[size][size];
        int halfSize = (int)size/2;

        for(int i=x-halfSize, z=0; i<x+halfSize; i++, z++) {
            for(int j=y-halfSize, t=0; j<y+halfSize; j++, t++) {
                res[t][z] = this.getRGB(i, j);
            }
        }

        return res;
    }

    public int[] getARGBArray(int x, int y) {
        return getARGBFromInt(this.getRGB(x, y));
    }

    public void setARGB(int x, int y, int[] argb) {
        this.setRGB(x, y, getARGBFromArray(argb));
    }
}
