package org.example.db;

import org.example.model.Record;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component @Profile("db")
public class DbRecordRepository implements RecordRepository{


    @Override
    public Record save(Record r) {
        System.out.println("DbRecordRepository");
        return r;
    }
}
