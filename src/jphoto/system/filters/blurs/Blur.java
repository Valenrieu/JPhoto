package jphoto.system.filters.blurs;

import jphoto.system.filters.Filter;
import jphoto.system.CustomImage;
import jphoto.system.kernels.Kernel;

public abstract class Blur implements Filter {
    protected CustomImage image;
    protected Kernel kernel;

    Blur(CustomImage image, Kernel kernel) throws IllegalArgumentException {
        this.image = image;
        this.kernel = kernel;
    }

    public final void compute() {
        kernel.convolve2d(image);
    }

    public static final Integer[] getkernelSizePossibilities(CustomImage nimage) {
        int min;
        int width = nimage.width;
        int height = nimage.height;

        if(width<height) {
            min = width;
        } else {
            min = height;
        }

        Integer[] res = new Integer[(int)Math.ceil(min/2) - 2];
        int counter = 3;

        for(int i=0; i<res.length-2; i++) {
            res[i] = counter;
            counter += 2;
        }

        return res;
    }
}
