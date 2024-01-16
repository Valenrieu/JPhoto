package jphoto.system.filters;

import jphoto.system.CustomImage;

public class NegativeFilter implements Filter {
    private CustomImage image;

    public NegativeFilter(CustomImage image) {
        this.image = image;
    }

    public void compute() {
        int[] newARGB;

        for(int i=0; i<image.width; i++) {
            for(int j=0; j<image.height; j++) {
                int[] currentARGB = image.getARGBArray(i, j);
                newARGB = new int[4];

                // On touche pas a l'opacite
                newARGB[0] = currentARGB[0];
                newARGB[1] = 255 - currentARGB[1];
                newARGB[2] = 255 - currentARGB[2];
                newARGB[3] = 255 - currentARGB[3];

                image.setARGB(i, j, newARGB);
            }
        }
    }
}
