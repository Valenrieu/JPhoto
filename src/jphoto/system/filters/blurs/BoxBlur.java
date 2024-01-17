package jphoto.system.filters.blurs;

import jphoto.system.CustomImage;
import jphoto.system.Kernel;
import jphoto.system.KernelType;
import jphoto.system.UndefinedKernelTypeException;

public class BoxBlur extends Blur {
    public BoxBlur(CustomImage image, int kernelSize) throws IllegalArgumentException {
        super(image);

        try {
            kernel = new Kernel(KernelType.BOX, kernelSize);
        } catch(IllegalArgumentException e) {
            // Pas cense se declencher. 
            throw e;
        } catch(UndefinedKernelTypeException e) {
            // Encore moins
        }
    }
}
