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
        int[] currentARGB, newARGB = new int[4];
        GrayScaleFilter grayScaleFilter = new GrayScaleFilter(image);
        grayScaleFilter.compute();

        for(int i=0; i<image.width; i++) {
            for(int j=0; j<image.height; j++) {
                currentARGB = image.getARGBArray(i, j);

                // Toutes les composantes sont egales sauf le alpha,
                // on verifie seulement la deuxieme (le rouge).

                if(currentARGB[1]<threshold) {
                    newARGB[0] = currentARGB[0];
                    newARGB[1] = 0;
                    newARGB[2] = 0;
                    newARGB[3] = 0;
                } else {
                    newARGB[0] = currentARGB[0];
                    newARGB[1] = 255;
                    newARGB[2] = 255;
                    newARGB[3] = 255;
                }

                image.setARGB(i, j, newARGB);
            }
        }
    }

    // Renvoie tous les seuils possibles.

    public static Integer[] getThresholdPossibilites() {
        Integer[] res = new Integer[256];

        for(int i=0; i<256; i++) {
            res[i] = i;
        }

        return res;
    }
}
