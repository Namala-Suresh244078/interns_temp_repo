package com.mphasis.tflms;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import static com.mphasis.tflms.constants.ProcessedFileEntityConstants.*;

@Entity
@Table(name = TABLE_NM_PROCESSED_FILE)
@Getter
@Setter
@AllArgsConstructor
public class ProcessedFile extends AbstractBaseEntity {

    @Column(name = COLUMN_FILE_NAME, nullable = false)
    private String fileName;

    @Column(name = COLUMN_LOAD_DATE, nullable = false)
    private LocalDateTime loadDate;

    @Column(name = COLUMN_STATUS, nullable = false)
    private String status;

    @Column(name = COLUMN_RECORD_COUNT, nullable = false)
    private int recordCount;

    @Column(name = COLUMN_RECORD_DELETED, nullable = false)
    private boolean recordDeleted;
}
