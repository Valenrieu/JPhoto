package jphoto.system.filters;

import jphoto.system.CustomImage;

public class PsychedelicFilter implements Filter {
    private CustomImage image;

    public PsychedelicFilter(CustomImage image) {
        this.image = image;
    }

    public void compute() {
        int pix, pix1, res;

        for(int i=0; i<image.width; i++) {
            for(int j=0; j<image.height; j++) {
                if(j==image.height-1) {
                    continue;
                }

                pix = image.getRGB(i, j);
                pix1 = image.getRGB(i, j+1);
                res = pix ^ pix1;
                image.setRGB(i, j, res);
            }
        }
    }
}
