package jphoto.system.file;

import java.awt.image.BufferedImage;

public abstract class FileObject {
    public final String path, name;
    protected BufferedImage icon = null;

    public FileObject(String path, String name) {
        this.path = path;
        this.name = name;
    }

    public BufferedImage getIcon() {
        return icon;
    }

    protected abstract BufferedImage loadIcon();
}
