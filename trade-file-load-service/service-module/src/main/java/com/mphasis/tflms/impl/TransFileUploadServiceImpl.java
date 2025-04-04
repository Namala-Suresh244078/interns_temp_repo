package com.mphasis.tflms.impl;

import com.mphasis.tflms.service.TransFileUploadService;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class TransFileUploadServiceImpl implements TransFileUploadService {

    private final JobLauncher jobLauncher;
    private final Job job;

    @Value("${file.upload-dir}")
    private String uploadDir;

    public TransFileUploadServiceImpl(JobLauncher jobLauncher, Job job) {
        this.jobLauncher = jobLauncher;
        this.job = job;
    }

    @Override
    public void runJob(MultipartFile multipartFile) throws Exception {
        String originalFilename = multipartFile.getOriginalFilename();
        if (!StringUtils.hasText(originalFilename)) {
            throw new IllegalArgumentException("File name is missing");
        }

        File savedFile = new File(uploadDir + originalFilename);
        multipartFile.transferTo(savedFile);

        JobParameters jobParameters = new JobParametersBuilder()
                .addString("filePath", savedFile.getAbsolutePath())
                .addString("fileName", StringUtils.getFilename(originalFilename))
                .addLong("timestamp", System.currentTimeMillis())
                .toJobParameters();

        jobLauncher.run(job, jobParameters);
    }
}
