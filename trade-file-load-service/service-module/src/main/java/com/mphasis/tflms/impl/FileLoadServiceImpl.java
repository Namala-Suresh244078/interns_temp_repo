package com.mphasis.tflms.impl;

import com.mphasis.tflms.responsedto.FileLoadResponse;
import com.mphasis.tflms.searchcriteriadto.SearchCriteria;
import com.mphasis.tflms.service.FileLoadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class FileLoadServiceImpl implements FileLoadService {

    @Override
    public FileLoadResponse uploadFile(MultipartFile file, String fileType, String description) {
        // Implementation here
        return null;
    }

    @Override
    public FileLoadResponse getFileProcessingStatus(Long fileId) {
        // Implementation here
        return null;
    }

    @Override
    public List<FileLoadResponse> searchFileLoads(SearchCriteria searchCriteria) {
        // Implementation here
        return List.of();
    }

    @Override
    public void updateFileLoadStatus(Long fileId, String status) {
        // Implementation here
    }

    @Override
    public void deleteFileLoad(Long fileId) {
        // Implementation here
    }
}
