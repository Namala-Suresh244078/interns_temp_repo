package com.mphasis.tflms;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.io.Serializable;
import com.mphasis.tflms.constants.AbstractBaseEntityConstants;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractBaseEntity implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = AbstractBaseEntityConstants.COLUMN_ID)
    private Long id;

    @Column(name = AbstractBaseEntityConstants.COLUMN_CREATED_BY, nullable = false, updatable = false)
    private String createdBy;

    @Column(name = AbstractBaseEntityConstants.COLUMN_CREATED_DATE, nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column(name = AbstractBaseEntityConstants.COLUMN_LAST_MODIFIED_BY, nullable = false)
    private String lastModifiedBy;

    @Column(name = AbstractBaseEntityConstants.COLUMN_LAST_MODIFIED_DATE, nullable = false)
    private LocalDateTime lastModifiedDate;
}
