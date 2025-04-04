package com.mphasis.tflms;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.time.LocalDateTime;
import java.io.Serializable;
import com.mphasis.tflms.constants.AbstractBaseConstants;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractBase implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = AbstractBaseConstants.COLUMN_ID)
    private Long id;

    @Column(name = AbstractBaseConstants.COLUMN_CREATED_BY, nullable = false, updatable = false)
    private String createdBy;

    @Column(name = AbstractBaseConstants.COLUMN_CREATED_DATE, nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(name = AbstractBaseConstants.COLUMN_LAST_MODIFIED_BY, nullable = false)
    private String lastModifiedBy;

    @Column(name = AbstractBaseConstants.COLUMN_LAST_MODIFIED_DATE, nullable = false)
    private LocalDateTime lastModifiedDate;
}
