package jphoto.system.filters;

import jphoto.system.CustomImage;

public class GrayScaleFilter implements Filter {
    private CustomImage image;

    public GrayScaleFilter(CustomImage image) {
        this.image = image;
    }

    // https://fr.wikipedia.org/wiki/Niveau_de_gris

    public void compute() {
        double[] newRGB = new double[3], gammaExpension = new double[3];
        int[] finalRGB = new int[3];
        double L;

        for(int i=0; i<image.width; i++) {
            for(int j=0; j<image.height; j++) {
                int[] currentRGB = image.getRGBArray(i, j);

                newRGB[0] = (double)currentRGB[0]/255d;
                newRGB[1] = (double)currentRGB[1]/255d;
                newRGB[2] = (double)currentRGB[2]/255d;

                for(int k=0; k<3; k++) {
                    if(newRGB[k]<=0.04045) {
                        gammaExpension[k] = newRGB[k]/12.92;
                    } else {
                        gammaExpension[k] = Math.pow((newRGB[k] + 0.055)/1.055, 2.4);
                    }
                }

                L = 0.2126*gammaExpension[0] + 0.7152*gammaExpension[1] + 0.0722*gammaExpension[2];

                if(L<=0.0031308) {
                    finalRGB[0] = (int)(12.92*L*255);
                    finalRGB[1] = (int)(12.92*L*255);
                    finalRGB[2] = (int)(12.92*L*255);
                } else {
                    finalRGB[0] = (int)((1.055*Math.pow(L, 1/2.4) - 0.055)*255);
                    finalRGB[1] = (int)((1.055*Math.pow(L, 1/2.4) - 0.055)*255);
                    finalRGB[2] = (int)((1.055*Math.pow(L, 1/2.4) - 0.055)*255);
                }

                image.setRGB(i, j, finalRGB);
            }
        }
    }
}
