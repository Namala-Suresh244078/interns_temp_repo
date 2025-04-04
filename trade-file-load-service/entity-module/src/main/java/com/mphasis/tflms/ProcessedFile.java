package com.mphasis.tflms;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import com.mphasis.tflms.constants.ProcessedFileEntityConstants;

@Entity
@Table(name = ProcessedFileEntityConstants.TABLE_NAME)
@Getter
@Setter

public class ProcessedFile extends AbstractBase {

    @Column(name = ProcessedFileEntityConstants.COLUMN_FILE_NAME, nullable = false)
    private String fileName;

    @Column(name = ProcessedFileEntityConstants.COLUMN_LOAD_DATE, nullable = false)
    private LocalDateTime loadDate;

    @Column(name = ProcessedFileEntityConstants.COLUMN_STATUS, nullable = false)
    private String status;

    @Column(name = ProcessedFileEntityConstants.COLUMN_RECORD_COUNT, nullable = false)
    private int recordCount;

    @Column(name = ProcessedFileEntityConstants.COLUMN_RECORD_DELETED, nullable = false)
    private boolean recordDeleted;
}
