package jphoto.system.filters;

import jphoto.system.CustomImage;

public class NegativeFilter implements Filter {
    private CustomImage image;

    public NegativeFilter(CustomImage image) {
        this.image = image;
    }

    public void compute() {
        int[] newRGB;

        for(int i=0; i<image.width; i++) {
            for(int j=0; j<image.height; j++) {
                int[] currentRGB = image.getRGBArray(i, j);
                newRGB = new int[3];

                newRGB[0] = 255 - currentRGB[0];
                newRGB[1] = 255 - currentRGB[1];
                newRGB[2] = 255 - currentRGB[2];

                image.setRGB(i, j, newRGB);
            }
        }
    }
}
