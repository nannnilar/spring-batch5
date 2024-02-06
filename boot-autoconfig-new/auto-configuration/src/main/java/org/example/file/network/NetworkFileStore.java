package org.example.file.network;

import org.example.file.FileStore;

public class NetworkFileStore implements FileStore {
    @Override
    public String printFileProperties() {
        return "NetworkFile Store Properties.";
    }
}
