package jphoto.system.file;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class Folder extends FileObject implements Openable {
    private FileExplorer fileExplorer;
    private boolean isParentFolder;

    public Folder(String path, FileExplorer fileExplorer) {
        super(path);
        this.fileExplorer = fileExplorer;
        icon = this.loadIcon();
    }

    public Folder(String path, FileExplorer fileExplorer, boolean isParentFolder) {
        super(path);
        this.fileExplorer = fileExplorer;
        this.isParentFolder = isParentFolder;
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

    public String getName() {
        if(isParentFolder) {
            return "..";
        }
        return super.getName();
    }

    public void open() throws DeletedFileOrFolderException {
        if(!this.exists()) {
            throw new DeletedFileOrFolderException();
        }

        fileExplorer.updatePath(this);
    }
}
