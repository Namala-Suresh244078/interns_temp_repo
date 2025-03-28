package com.mphasis.tflms;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "file_load")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FileLoad {

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

}

