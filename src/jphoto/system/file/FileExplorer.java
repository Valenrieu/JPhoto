package jphoto.system.file;

import java.util.List;
import java.util.ArrayList;
import java.io.File;

public class FileExplorer {
    private Folder currentFolder = new Folder(System.getProperty("user.home"), this);
    private List<FileObject> fileList;

    public FileExplorer() {
        this.updateFolder();
    }

    public void update(FileObject fileObject) throws DeletedFileOrFolderException {
        if(fileObject instanceof Openable) {
            Openable object = (Openable)fileObject;

            try {
                object.open();
            } catch(DeletedFileOrFolderException e) {
                throw new DeletedFileOrFolderException();
            }
        }
    }
 
    void updatePath(Folder folder) {
        currentFolder = folder;
        this.updateFolder();
    }

    private void updateFolder() {
        Folder parentFolder;
        fileList = new ArrayList<FileObject>();

        if(currentFolder.getParent()==null) {
            parentFolder = currentFolder;
        } else {
            parentFolder = new Folder(currentFolder.getParent(), this, true);
        }

        fileList.add(parentFolder);

        if(currentFolder.listFiles()==null) {
            return;
        }

        for(File file : currentFolder.listFiles()) {
            if(file.isHidden()) {
                continue;
            }

            if(file.isDirectory()) {
                fileList.add(new Folder(file.getAbsolutePath(), this));
            } else {
                if(file.getName().endsWith(".png") || file.getName().endsWith(".jpeg")) {
                    fileList.add((ImageFile)file);
                } else {
                    fileList.add((UndefinedFile)file);
                }
            }
        }
    }

    public String getCurrentPath() {
        return currentFolder.getAbsolutePath();
    }

    public List<FileObject> getFiles() {
        return fileList;
    }
}
