package jphoto.system.kernels;

public class BoxKernel extends Kernel {
    public BoxKernel(int size) throws IllegalArgumentException {
        super(size, getBoxMatrix(size));
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
