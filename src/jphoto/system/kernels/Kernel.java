package jphoto.system.kernels;

import jphoto.system.CustomImage;

import static jphoto.system.utils.ImageUtils.expandImage;
import static jphoto.system.utils.ImageUtils.getARGBFromInt;

public abstract class Kernel {
    public final int size;
    private final double[][] matrix;

    Kernel(int size, double[][] matrix) throws IllegalArgumentException {
        if(size % 2 == 0) {
            throw new IllegalArgumentException();
        }

        this.size = size;
        this.matrix = matrix;
    }

    // J'utilise la methode d'extension de l'image si le noyau depasse.

    public void convolve2d(CustomImage image) {
        int[][] subMatrix;
        int[][][] newMatrix = new int[image.height][image.width][4];
        int halfSize = (int)Math.ceil(size/2);

        for(int i=0; i<image.width; i++) {
            for(int j=0; j<image.height; j++) {
                if(i-halfSize<0 || i+halfSize>=image.width || j-halfSize<0 || j+halfSize>=image.height) {
                    subMatrix = expandImage(image, i, j, size);
                } else {
                    subMatrix = image.getSubRGB(i, j, size);
                }

                newMatrix[j][i] = this.convolve(subMatrix);
            }
        }

        // On actualise les pixels apres la convolution
        // pour ne pas alterer les pixels de base.

        for(int i=0; i<image.width; i++) {
            for(int j=0; j<image.height; j++) {
                image.setARGB(i, j, newMatrix[j][i]);
            }
        }
    }

    private int[] convolve(int[][] imageSubMatrix) {
        int[] argb;
        int[] res = new int[] {0, 0, 0, 0};
        int middle = (int)Math.ceil(size/2);
        // On ne touche pas au alpha.
        res[0] = getARGBFromInt(imageSubMatrix[middle][middle])[0];

        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                argb = getARGBFromInt(imageSubMatrix[i][j]);
                res[1] += (int)argb[1]*matrix[i][j];
                res[2] += (int)argb[2]*matrix[i][j];
                res[3] += (int)argb[3]*matrix[i][j];
            }
        }

        return res;
    }
}
