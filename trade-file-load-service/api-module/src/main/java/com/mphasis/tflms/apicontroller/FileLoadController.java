package com.mphasis.tflms.apicontroller;

import com.mphasis.tflms.responsedto.*;
import com.mphasis.tflms.service.FileLoadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/file-load")
@SecurityRequirement(name = "bearerAuth") // JWT security requirement
public class FileLoadController {

    @Autowired
    private FileLoadService fileLoadService;

    // File Upload API
    @PostMapping("/upload")
    @Operation(summary = "Upload a file", responses = {
            @ApiResponse(description = "File uploaded successfully", responseCode = "201"),
            @ApiResponse(description = "Invalid file type or request", responseCode = "400")
    })
    public ResponseEntity<ApiResponse<FileloadResponse>> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("fileType") String fileType,
            @RequestParam("description") String description) {

        FileloadResponse response = fileLoadService.uploadFile(file, fileType, description);
        return ResponseEntity.status(201).body(new ApiResponse<>(LocalDateTime.now(), "SUCCESS", 201, "File uploaded successfully", response));
    }

    // Retrieve File Processing Status
    @GetMapping("/{fileId}/status")
    @Operation(summary = "Get file processing status", responses = {
            @ApiResponse(description = "File processing status retrieved", responseCode = "200"),
            @ApiResponse(description = "File not found", responseCode = "404")
    })
    public ResponseEntity<ApiResponse<FileProcessingStatus>> getFileProcessingStatus(@PathVariable String fileId) {
        FileProcessingStatus status = fileLoadService.getFileProcessingStatus(fileId);
        return ResponseEntity.ok(new ApiResponse<>(LocalDateTime.now(), "SUCCESS", 200, "File processing status retrieved", status));
    }

    // Search for file loads
    @GetMapping
    @Operation(summary = "Search for file loads", responses = {
            @ApiResponse(description = "List of file loads retrieved", responseCode = "200"),
            @ApiResponse(description = "No content", responseCode = "204")
    })
    public ResponseEntity<ApiResponse<List<FileloadResponse>>> searchFileLoads() {
        List<FileloadResponse> responses = fileLoadService.searchFileLoads();
        return ResponseEntity.ok(new ApiResponse<>(LocalDateTime.now(), "SUCCESS", 200, "File loads retrieved successfully", responses));
    }

    // Update File Load Status
    @PutMapping("/{fileId}/status")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Update file load status", responses = {
            @ApiResponse(description = "File load status updated", responseCode = "200"),
            @ApiResponse(description = "File not found", responseCode = "404")
    })
    public ResponseEntity<ApiResponse<Void>> updateFileLoadStatus(@PathVariable String fileId, @RequestBody String status) {
        fileLoadService.updateFileLoadStatus(fileId, status);
        return ResponseEntity.ok(new ApiResponse<>(LocalDateTime.now(), "SUCCESS", 200, "File load status updated successfully"));
    }

    // Delete a file load
    @DeleteMapping("/{fileId}")
    @Operation(summary = "Delete a file load", responses = {
            @ApiResponse(description = "File load deleted", responseCode = "200"),
            @ApiResponse(description = "File not found", responseCode = "404")
    })
    public ResponseEntity<ApiResponse<Void>> deleteFileLoad(@PathVariable String fileId) {
        fileLoadService.deleteFileLoad(fileId);
        return ResponseEntity.ok(new ApiResponse<>(LocalDateTime.now(), "SUCCESS", 200, "File load deleted successfully"));
    }
}
