package jphoto.system.utils;

import jphoto.system.CustomImage;

public final class ImageUtils {
    // Renvoie un tableau de longueur 4 avec la composante
    // alpha, rouge, verte et bleue.
    // https://stackoverflow.com/questions/25761438/understanding-bufferedimage-getrgb-output-values
    // Plus facile a manipuler que l'entier qui contient les 4 composantes.

    public static final int[] getARGBFromInt(int argb) {
        int[] res = new int[4];

        res[0] = (argb & 0xff000000) >>> 24;
        res[1] = (argb & 0xff0000) >> 16;
        res[2] = (argb & 0xff00) >> 8;
        res[3] = argb & 0xff;

        return res;
    }

    // Methode inverse.

    public static final int getARGBFromArray(int[] argb) {
        return ((argb[0] & 0x0ff) << 24) | ((argb[1] & 0x0ff) << 16) | ((argb[2] & 0x0ff) << 8) | (argb[3] & 0x0ff);
    }

    public static int[][] expandImage(CustomImage image, int x, int y, int kernelSize) {
        int z = 0, t = 0;
        int xx = 0, yy = 0;
        int halfKernelSize = (int)kernelSize/2;
        int[][] res = new int[kernelSize][kernelSize];        

        for(int i=x-halfKernelSize; i<x+halfKernelSize; i++) {
            t = 0;

            for(int j=y-halfKernelSize; j<y+halfKernelSize; j++) {
                try  {
                    res[z][t] = getARGBFromArray(image.getARGBArray(i, j));
                } catch(ArrayIndexOutOfBoundsException e) {
                    if(i>=image.width) {
                        xx = image.width - 1;
                    } else if(i<0) {
                        xx = (i % halfKernelSize) + halfKernelSize;
                    }

                    if(j>=image.height) {
                        yy = image.height - 1;
                    } else if(j<0) {
                        yy = (j % halfKernelSize) + halfKernelSize;
                    }

                    res[z][t] = getARGBFromArray(image.getARGBArray(xx, yy));
                }

                t++;
            }

            z++;
        }

        return res;
    }
}
