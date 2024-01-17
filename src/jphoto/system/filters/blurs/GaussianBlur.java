package jphoto.system.filters.blurs;

import jphoto.system.CustomImage;
import jphoto.system.Kernel;
import jphoto.system.KernelType;
import jphoto.system.UndefinedKernelTypeException;

public class GaussianBlur extends Blur {
    public GaussianBlur(CustomImage image, int kernelSize) throws IllegalArgumentException {
        super(image);

        try {
            kernel = new Kernel(KernelType.GAUSSIAN, kernelSize);
        } catch(IllegalArgumentException e) {
            // Pas cense se declencher. 
            throw e;
        } catch(UndefinedKernelTypeException e) {
            // Encore moins
        }
    }
}
