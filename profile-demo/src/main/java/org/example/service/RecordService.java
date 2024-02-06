package org.example.service;

import org.example.db.RecordRepository;
import org.example.format.RecordFormatter;
import org.example.model.Record;
import org.example.printer.RecordPrinter;
import org.springframework.stereotype.Service;

@Service
public class RecordService {

    private final RecordPrinter recordPrinter;
    private final RecordFormatter recordFormatter;
    private final RecordRepository recordRepository;
    public RecordService(RecordPrinter recordPrinter, RecordFormatter recordFormatter, RecordRepository recordRepository) {
        this.recordPrinter = recordPrinter;
        this.recordFormatter = recordFormatter;
        this.recordRepository = recordRepository;
    }

    public void doAction() {
        recordPrinter.print(recordRepository.save(recordFormatter.format(new Record())));
    }
}
