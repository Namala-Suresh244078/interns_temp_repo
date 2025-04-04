package com.mphasis.tflms.impl;

import com.mphasis.tflms.service.FileLoadService;
import com.mphasis.tflms.responsedto.FileLoadResponse;
import com.mphasis.tflms.searchcriteriadto.SearchCriteria;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class FileLoadServiceImpl implements FileLoadService {

    @Override
    public FileLoadResponse uploadFile(MultipartFile file, String fileType, String description) {
        return null;
    }

    @Override
    public FileLoadResponse getFileProcessingStatus(Long fileId) {
        return null;
    }

    @Override
    public List<FileLoadResponse> searchFileLoads(SearchCriteria searchCriteria) {
        return null;
    }

    @Override
    public void updateFileLoadStatus(Long fileId, String status) {
    }

    @Override
    public void deleteFileLoad(Long fileId) {
    }
}
