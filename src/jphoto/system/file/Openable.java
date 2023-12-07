package jphoto.system.file;

public interface Openable {
    public abstract void open() throws DeletedFileOrFolderException;
}
