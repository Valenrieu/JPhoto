package jphoto.system.filters;

import jphoto.system.CustomImage;

public class NegativeFilter implements Filter {
    private CustomImage image;

    public NegativeFilter(CustomImage image) {
        this.image = image;
    }

    public void compute() {
        for(int i=0; i<image.width; i++) {
            for(int j=0; j<image.height; j++) {
                int[] currentRGB = image.getRGBArray(i, j);
                int[] newArray = new int[3];

                newArray[0] = 255 - currentRGB[0];
                newArray[1] = 255 - currentRGB[1];
                newArray[2] = 255 - currentRGB[2];

                image.setRGB(i, j, newArray);
            }
        }
    }
}
