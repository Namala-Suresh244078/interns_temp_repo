package com.mphasis.tflms.service;

import com.mphasis.tflms.responsedto.FileLoadResponse;
import com.mphasis.tflms.searchcriteriadto.SearchCriteria;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileLoadService {
    FileLoadResponse uploadFile(MultipartFile file, String fileType, String description);
    FileLoadResponse getFileProcessingStatus(Long fileId);
    List<FileLoadResponse> searchFileLoads(SearchCriteria searchCriteria);
    void updateFileLoadStatus(Long fileId, String status);
    void deleteFileLoad(Long fileId);
}
