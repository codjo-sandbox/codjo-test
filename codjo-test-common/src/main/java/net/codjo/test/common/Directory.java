/*
 * Team : AGF AM / OSI / SI / BO
 *
 * Copyright (c) 2001 AGF Asset Management.
 */
package net.codjo.test.common;
import java.io.File;
import java.io.IOException;
/**
 * Repr�sente un r�pertoire.
 */
public class Directory extends File {
    private String lastCreatedSubDirectory;

    public Directory(String rootPath) {
        super(rootPath);
        lastCreatedSubDirectory = null;
    }

    public void deleteRecursively() throws NotDeletedException {
        final File[] files = listFiles();
        if (null != files) {
            for (File file : files) {
                new Directory(file.getPath()).deleteRecursively();
            }
        }
        delete();
        if (exists()) {
            throw new NotDeletedException(getPath());
        }
    }


    public void make() {
        lastCreatedSubDirectory = getPath();
        mkdir();
    }


    public void makeSubDirectory(String subdirectoryName) {
        lastCreatedSubDirectory = getPath() + File.separator + subdirectoryName;
        new File(getPath(), subdirectoryName).mkdirs();
    }


    public String lastCreated() {
        return lastCreatedSubDirectory;
    }

    /**
     * Exception lev�e lorsqu'un r�pertoire ne peut pas �tre supprim�.
     */
    public static class NotDeletedException extends IOException {
        public NotDeletedException(String path) {
            super(path);
        }
    }
}
