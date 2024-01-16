package jphoto.system.filters;

import jphoto.system.CustomImage;

/* Classe pour le filtre noir et blanc, j'applique d'abord un filtre
 * niveau de gris. Puis tous les pixels inferieurs au seuil deviennent noir.
 */

public class BlackAndWhiteFilter implements Filter {
    private CustomImage image;
    private int threshold;

    public BlackAndWhiteFilter(CustomImage image, int threshold) {
        this.image = image;
        this.threshold = threshold;
    }

    public void compute() {
        int[] currentRGB, newRGB = new int[3];
        GrayScaleFilter grayScaleFilter = new GrayScaleFilter(image);
        grayScaleFilter.compute();

        for(int i=0; i<image.width; i++) {
            for(int j=0; j<image.height; j++) {
                currentRGB = image.getRGBArray(i, j);

                // Toutes les composantes sont egales, on verifie seulement la premiere

                if(currentRGB[0]<threshold) {
                    newRGB[0] = 0;
                    newRGB[1] = 0;
                    newRGB[2] = 0;
                } else {
                    newRGB[0] = 255;
                    newRGB[1] = 255;
                    newRGB[2] = 255;
                }

                image.setRGB(i, j, newRGB);
            }
        }
    }

    public static Integer[] getThresholdPossibilites() {
        Integer[] res = new Integer[256];

        for(int i=0; i<256; i++) {
            res[i] = i;
        }

        return res;
    }
}
