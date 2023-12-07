package jphoto.system.file;

public class DeletedFileOrFolderException extends Exception {
    public DeletedFileOrFolderException() {
        super();
    }

    public DeletedFileOrFolderException(String message) {
        super(message);
    }
}
