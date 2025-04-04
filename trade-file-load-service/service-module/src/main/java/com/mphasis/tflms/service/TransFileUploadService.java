package com.mphasis.tflms.service;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class TransFileUpload {

    private final JobLauncher jobLauncher;
    private final Job job;

    @Value("${file.upload-dir}") // e.g., /tmp/uploads or C:/upload-dir from application.properties
    private String uploadDir;

    public TransFileUpload(JobLauncher jobLauncher, Job job) {
        this.jobLauncher = jobLauncher;
        this.job = job;
    }

    public void runJob(MultipartFile multipartFile) throws Exception {

        String originalFilename = multipartFile.getOriginalFilename();
        if (!StringUtils.hasText(originalFilename)) {
            throw new IllegalArgumentException("File name is missing");
        }

        // Save file to upload directory
        File savedFile = new File(uploadDir+ originalFilename);
        multipartFile.transferTo(savedFile);

        // Build job parameters
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("filePath", savedFile.getAbsolutePath())
                .addString("fileName", StringUtils.getFilename(originalFilename))
                .addLong("timestamp", System.currentTimeMillis())
                .toJobParameters();

       jobLauncher.run(job, jobParameters);


    }
}
