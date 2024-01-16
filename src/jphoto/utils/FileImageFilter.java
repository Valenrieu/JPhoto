package jphoto.utils;

import java.io.File;
import java.io.FileFilter;

public class FileImageFilter implements FileFilter {
    private static final String[] extensions = new String[] {"jpg", "jpeg", "png"};

    public boolean accept(File file) {
        for(String extension : extensions) {
            if(file.getName().toLowerCase().endsWith(extension)) {
                return true;
            }
        }

        return false;
    }
}
