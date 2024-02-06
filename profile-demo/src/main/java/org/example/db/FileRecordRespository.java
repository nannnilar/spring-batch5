package org.example.db;

import org.example.model.Record;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component @Profile("file")
public class FileRecordRespository implements  RecordRepository{


    @Override
    public Record save(Record r) {
        System.out.println("FileRecordRespository");
        return r;
    }
}
