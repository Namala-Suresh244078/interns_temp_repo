package com.mphasis.tflms.impl;

import com.mphasis.tflms.apicontroller.FileLoadController;
import com.mphasis.tflms.apiresponse.ApiResponse;
import com.mphasis.tflms.responsedto.FileLoadResponse;
import com.mphasis.tflms.searchcriteriadto.SearchCriteria;
import com.mphasis.tflms.service.FileLoadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class FileLoadControllerImpl implements FileLoadController {

    private final FileLoadService fileLoadService;
    private static final String SUCCESS = "SUCCESS";

    public FileLoadControllerImpl(FileLoadService fileLoadService) {
        this.fileLoadService = fileLoadService;
    }

    @Override
    public ResponseEntity<ApiResponse<FileLoadResponse>> uploadFile(MultipartFile file, String fileType, String description) {
        FileLoadResponse response = fileLoadService.uploadFile(file, fileType, description);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(LocalDateTime.now(), SUCCESS, HttpStatus.CREATED.value(), "File uploaded successfully", response));
    }

    @Override
    public ResponseEntity<ApiResponse<FileLoadResponse>> getFileProcessingStatus(Long fileId) {
        FileLoadResponse status = fileLoadService.getFileProcessingStatus(fileId);
        return ResponseEntity.ok(
                new ApiResponse<>(LocalDateTime.now(), SUCCESS, HttpStatus.OK.value(), "File processing status retrieved", status)
        );
    }

    @Override
    public ResponseEntity<ApiResponse<List<FileLoadResponse>>> searchFileLoads(SearchCriteria searchCriteria) {
        List<FileLoadResponse> responses = fileLoadService.searchFileLoads(searchCriteria);
        return ResponseEntity.ok(
                new ApiResponse<>(LocalDateTime.now(), SUCCESS, HttpStatus.OK.value(), "File loads retrieved successfully", responses)
        );
    }

    @Override
    public ResponseEntity<ApiResponse<Void>> updateFileLoadStatus(Long fileId, String status) {
        fileLoadService.updateFileLoadStatus(fileId, status);
        return ResponseEntity.ok(
                new ApiResponse<>(LocalDateTime.now(), SUCCESS, HttpStatus.OK.value(), "File load status updated successfully")
        );
    }

    @Override
    public ResponseEntity<ApiResponse<Void>> deleteFileLoad(Long fileId) {
        fileLoadService.deleteFileLoad(fileId);
        return ResponseEntity.ok(
                new ApiResponse<>(LocalDateTime.now(), SUCCESS, HttpStatus.OK.value(), "File load deleted successfully")
        );
    }
}
