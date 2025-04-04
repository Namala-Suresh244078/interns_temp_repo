package com.mphasis.tflms.apicontroller;

import com.mphasis.tflms.responsedto.FileLoadResponse;
import com.mphasis.tflms.searchcriteriadto.SearchCriteria;
import com.mphasis.tflms.apiresponse.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileLoadController {

    @PostMapping("/upload")
    ResponseEntity<ApiResponse<FileLoadResponse>> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("fileType") String fileType,
            @RequestParam("description") String description
    );

    @GetMapping("/{fileId}/status")
    ResponseEntity<ApiResponse<FileLoadResponse>> getFileProcessingStatus(@PathVariable Long fileId);

    @PostMapping("/search")
    ResponseEntity<ApiResponse<List<FileLoadResponse>>> searchFileLoads(@RequestBody SearchCriteria searchCriteria);

    @PutMapping("/{fileId}/status")
    ResponseEntity<ApiResponse<Void>> updateFileLoadStatus(@PathVariable Long fileId, @RequestBody String status);

    @DeleteMapping("/{fileId}")
    ResponseEntity<ApiResponse<Void>> deleteFileLoad(@PathVariable Long fileId);
}
