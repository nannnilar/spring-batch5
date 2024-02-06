package org.example.db;

import org.example.model.Record;

public interface RecordRepository {

    Record save(Record r);
}
