package jphoto.system.file;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageFile extends FileObject implements Openable {
    public ImageFile(String path) {
        super(path);
        icon = this.loadIcon();
    }

    protected BufferedImage loadIcon() {
        BufferedImage image = null;

        try {
            image = ImageIO.read(new File("res/icons/image_icon.png"));
        } catch(IOException e) {
            System.exit(1);
        }

        return image;
    }

    public void open() throws DeletedFileOrFolderException {
        // Do something
    }
}
