package com.mphasis.tflms;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "processed_file")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProcessedFile  implements Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String filename;

    @Column(nullable = false)
    private LocalDateTime loadDate;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private int recordCount;

    @Column(nullable = false)
    private boolean recordDeleted;


    private String createdBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;
}


