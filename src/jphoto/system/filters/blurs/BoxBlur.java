package jphoto.system.filters.blurs;

import jphoto.system.CustomImage;
import jphoto.system.kernels.BoxKernel;

public class BoxBlur extends Blur {
    public BoxBlur(CustomImage image, int kernelSize) throws IllegalArgumentException {
        super(image, new BoxKernel(kernelSize));
    }
}
