package com.mphasis.tflms.service;

import org.springframework.web.multipart.MultipartFile;

public interface TransFileUploadService {
    void runJob(MultipartFile multipartFile) throws Exception;
}
