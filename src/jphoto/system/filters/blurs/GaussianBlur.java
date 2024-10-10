package jphoto.system.filters.blurs;

import jphoto.system.CustomImage;
import jphoto.system.kernels.GaussianKernel;

public class GaussianBlur extends Blur {
    public GaussianBlur(CustomImage image, int kernelSize, double sigma) throws IllegalArgumentException {
        super(image, new GaussianKernel(kernelSize, sigma));
    }
}
