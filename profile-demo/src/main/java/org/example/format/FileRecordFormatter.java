package org.example.format;

import org.example.model.Record;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component @Profile("file")
public class FileRecordFormatter implements RecordFormatter{
    @Override
    public Record format(Record r) {
        System.out.println("FileRecordFormatter");
        return r;
    }
}
