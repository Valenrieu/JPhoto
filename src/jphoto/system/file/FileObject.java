package jphoto.system.file;

import java.awt.image.BufferedImage;
import java.io.File;

public abstract class FileObject extends File {
    protected BufferedImage icon = null;

    public FileObject(String path) {
        super(path);
    }

    public BufferedImage getIcon() {
        return icon;
    }

    protected abstract BufferedImage loadIcon();
}
