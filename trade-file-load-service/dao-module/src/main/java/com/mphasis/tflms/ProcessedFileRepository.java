package com.mphasis.tflms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface ProcessedFileRepository extends JpaRepository<ProcessedFile,Long> {
    ProcessedFile findByFileName(String fileName);
    List<ProcessedFile> findByStatus(String status);
    List<ProcessedFile> findByCreatedDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}
