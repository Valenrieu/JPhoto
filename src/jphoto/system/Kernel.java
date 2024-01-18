package jphoto.system;

import jphoto.system.CustomImage;
import static jphoto.system.utils.ImageUtils.expandImage;
import static jphoto.system.utils.ImageUtils.getARGBFromInt;

public class Kernel {
    public final KernelType type;
    public final int size;
    private double[][] matrix;

    public Kernel(KernelType type, int size) throws UndefinedKernelTypeException, IllegalArgumentException {
        if(size % 2 == 0) {
            throw new IllegalArgumentException();
        }

        this.size = size;
        this.type = type;

        switch(type) {
            case GAUSSIAN:
                matrix = getGaussianMatrix(size);
                break;
            case BOX:
                matrix = getBoxMatrix(size);
                break;
            default:
                throw new UndefinedKernelTypeException();
        }
    }

    // J'utilise la methode d'extension de l'image si le noyau depasse.

    public void convolve2d(CustomImage image) {
        int[][] subMatrix;
        int[][][] newMatrix = new int[image.height][image.width][4];

        for(int i=0; i<image.width; i++) {
            for(int j=0; j<image.height; j++) {
                if(i-size<0 || i+size>=image.width || j-size<0 || j+size>=image.height) {
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

    private static double[][] getGaussianMatrix(int length) {
        double[][] res = new double[length][length];
        int mean = (int)length/2;
        double sum = 0d, sigma = 1d;

        for(int i=0; i<length; i++) {
            for(int j=0; j<length; j++) {
                res[i][j] = Math.exp(-0.5*(Math.pow((i - mean)/sigma, 2) + Math.pow((j - mean)/sigma, 2)))/
                            (2*Math.PI*sigma*sigma);
                sum += res[i][j];
            }
        }

        for(int i=0; i<length; i++) {
            for(int j=0; j<length; j++) {
                res[i][j] = res[i][j]/sum; // Normalisation
            }
        }

        return res;
    }

    private static double[][] getBoxMatrix(int length) {
        double[][] res = new double[length][length];

        for(int i=0; i<length; i++) {
            for(int j=0; j<length; j++) {
                // On normalise par la somme des coeffs,
                // comme ce sont des 1, c'est trivial a calculer.
                res[i][j] = 1d/(double)(length*length);
            }
        }

        return res;
    }
}
