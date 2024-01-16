package jphoto.system.filters;

import jphoto.system.CustomImage;

public class GrayScaleFilter implements Filter {
    private CustomImage image;

    public GrayScaleFilter(CustomImage image) {
        this.image = image;
    }

    /* La methode que j'ai utilisee :
     * https://fr.wikipedia.org/wiki/Niveau_de_gris
     */

    public void compute() {
        double[] newARGB = new double[3], gammaExpension = new double[3];
        int[] currentARGB, finalARGB = new int[4];
        double L;

        for(int i=0; i<image.width; i++) {
            for(int j=0; j<image.height; j++) {
                currentARGB = image.getARGBArray(i, j);

                newARGB[0] = (double)currentARGB[0]/255d;
                newARGB[1] = (double)currentARGB[1]/255d;
                newARGB[2] = (double)currentARGB[2]/255d;

                for(int k=0; k<3; k++) {
                    if(newARGB[k]<=0.04045) {
                        gammaExpension[k] = newARGB[k]/12.92;
                    } else {
                        gammaExpension[k] = Math.pow((newARGB[k] + 0.055)/1.055, 2.4);
                    }
                }

                L = 0.2126*gammaExpension[0] + 0.7152*gammaExpension[1] + 0.0722*gammaExpension[2];

                if(L<=0.0031308) {
                    finalARGB[1] = (int)(12.92*L*255);
                    finalARGB[2] = (int)(12.92*L*255);
                    finalARGB[3] = (int)(12.92*L*255);
                } else {
                    finalARGB[1] = (int)((1.055*Math.pow(L, 1/2.4) - 0.055)*255);
                    finalARGB[2] = (int)((1.055*Math.pow(L, 1/2.4) - 0.055)*255);
                    finalARGB[3] = (int)((1.055*Math.pow(L, 1/2.4) - 0.055)*255);
                }

                finalARGB[0] = currentARGB[0];
                image.setARGB(i, j, finalARGB);
            }
        }
    }
}
