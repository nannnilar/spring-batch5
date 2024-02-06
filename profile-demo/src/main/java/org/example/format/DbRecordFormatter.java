package org.example.format;

import org.example.model.Record;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component @Profile("db")
public class DbRecordFormatter implements RecordFormatter{
    @Override
    public Record format(Record r) {
        System.out.println("DbRecordFormatter");
        return r;
    }
}
