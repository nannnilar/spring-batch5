package org.example.file.local;

import org.example.file.FileStore;

public class LocalFileSource implements FileStore {
    @Override
    public String printFileProperties() {
        return "LocalFile Store Properties";
    }
}
