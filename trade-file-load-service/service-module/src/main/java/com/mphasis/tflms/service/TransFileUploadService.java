package com.mphasis.tflms.service;

import org.springframework.web.multipart.MultipartFile;
import java.util.concurrent.CompletableFuture;

public interface TransFileUploadService {
    CompletableFuture<Void> runJob(MultipartFile multipartFile) throws Exception;
}
