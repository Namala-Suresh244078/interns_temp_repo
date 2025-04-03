package com.mphasis.tflms.service;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class FileUploadService {

    private final JobLauncher jobLauncher;
    private final Job job;

    @Value("${file.upload-dir}") // Define in application.properties or application.yml
    private String filePath;

    public FileUploadService(JobLauncher jobLauncher, Job job) {
        this.jobLauncher = jobLauncher;
        this.job = job;
    }

    public ResponseEntity<Object> runJob(MultipartFile multipartFile) {
        try {
            String originalFilename = multipartFile.getOriginalFilename();
            if (originalFilename == null || originalFilename.isEmpty()) {
                return ResponseEntity.badRequest().body("Invalid file");
            }

            // Save file to temporary storage
            File fileToImport = new File(filePath + File.separator + originalFilename);
            multipartFile.transferTo(fileToImport);

            // Create job parameters
            JobParameters jobParameters = new JobParametersBuilder()
                    .addString("file", fileToImport.getAbsolutePath())
                    .addString("fileName", StringUtils.getFilename(originalFilename))
                    .addLong("startAt", System.currentTimeMillis())
                    .toJobParameters();

            // Launch job
            JobExecution jobExecution = jobLauncher.run(job, jobParameters);

            // Prepare response
            Map<String, Object> response = new HashMap<>();
            response.put("jobExecutionId", jobExecution.getId());
            response.put("status", jobExecution.getStatus().toString());

            return ResponseEntity.ok(response);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("File processing error: " + e.getMessage());
        } catch (JobInstanceAlreadyCompleteException | JobExecutionAlreadyRunningException |
                 JobParametersInvalidException | JobRestartException e) {
            return ResponseEntity.status(500).body("Job execution error: " + e.getMessage());
        }
    }
}
