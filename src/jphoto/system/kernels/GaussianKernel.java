package jphoto.system.kernels;

public class GaussianKernel extends Kernel {
    public final double sigma;

    public GaussianKernel(int size, double sigma) throws IllegalArgumentException {
        super(size, getGaussianMatrix(size, sigma));
        this.sigma = sigma;
    }

    private static double[][] getGaussianMatrix(int length, double sigma) {
        double[][] res = new double[length][length];
        int mean = (int)length/2;
        double sum = 0d;

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
}
