package org.example.printer;

import org.example.model.Record;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component @Profile("db")
public class DbRecordPrinter implements RecordPrinter{


    @Override
    public void print(Record r) {
        System.out.println("DbRecordPrinter");
    }
}
