package org.example.printer;

import org.example.model.Record;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component @Profile("file")
public class FileRecordPrinter implements RecordPrinter{
    @Override
    public void print(Record r) {
        System.out.println("FileRecordPrinter");
    }
}
