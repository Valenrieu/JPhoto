package jphoto.system.file;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class Folder extends FileObject implements Openable {
    public Folder(String path, String name) {
        super(path, name);
        icon = this.loadIcon();
    }

    protected BufferedImage loadIcon() {
        BufferedImage image = null;

        try {
            image = ImageIO.read(new File("res/icons/folder_icon.png"));
        } catch(IOException e) {
            System.exit(1);
        }

        return image;
    }

    public void open() throws DeletedFileOrFolderException {
        // Do something
    }
}
