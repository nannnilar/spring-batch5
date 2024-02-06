package org.example.file.local;

import org.example.file.FileStore;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@ConditionalOnProperty(name = "file.store",havingValue = "local")
public class LocalFileStoreAutoConfiguration {
    @Bean
    public FileStore localFileStore(){
        return new LocalFileSource();
    }
}
