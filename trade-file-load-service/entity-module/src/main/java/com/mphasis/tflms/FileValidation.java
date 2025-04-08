package com.mphasis.tflms;

import jakarta.persistence.*;
import lombok.*;
import static com.mphasis.tflms.constants.FileValidationEntityConstants.*;

@Entity
@Table(name = TABLE_NM_FILE_VALIDATION)
@Getter
@Setter
@AllArgsConstructor
public class FileValidation extends AbstractBaseEntity {

    @Column(name = COLUMN_VERSION)
    private Integer version;

    @Column(name = COLUMN_ERROR_CODE, length = 50)
    private String errorCode;

    @Column(name = COLUMN_SEVERITY)
    private Integer severity;

    @Column(name = COLUMN_ERROR_DESCRIPTION, length = 1000)
    private String errorDescription;

    @Column(name = COLUMN_ERROR_GUID, unique = true)
    private String errorGuid;
}
