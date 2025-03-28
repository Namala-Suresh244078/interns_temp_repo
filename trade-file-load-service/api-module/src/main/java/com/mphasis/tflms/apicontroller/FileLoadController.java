package com.mphasis.tflms.apicontroller;
import com.mphasis.tflms.requestdto.FileLoadRequest;
import com.mphasis.tflms.responsedto.FileLoadResponse;
import com.mphasis.tflms.searchcriteriadto.SearchCriteria;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/file-loads")
@SecurityRequirement(name = "bearerAuth") // JWT security requirement
public class FileLoadController {

    @Autowired
    private FileLoadService fileLoadService;

    // Create a new file load
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')") // Example authorization
    @Operation(summary = "Create a new file load", responses = {
            @ApiResponse(description = "File load created", responseCode = "201"),
            @ApiResponse(description = "Bad request", responseCode = "400")
    })
    public FileLoadResponse createFileLoad(@RequestBody @Valid FileLoadRequest fileLoadRequestDTO) {
        return fileLoadService.createFileLoad(fileLoadRequestDTO);
    }

    // Retrieve a file load by ID
    @GetMapping("/{id}")
    @Operation(summary = "Retrieve file load by ID", responses = {
            @ApiResponse(description = "File load retrieved", responseCode = "200"),
            @ApiResponse(description = "File load not found", responseCode = "404")
    })
    public FileLoadResponse getFileLoad(@PathVariable Long id) {
        return fileLoadService.getFileLoadById(id);
    }

    // Search for file loads
    @GetMapping
    @Operation(summary = "Search for file loads", responses = {
            @ApiResponse(description = "List of file loads retrieved", responseCode = "200"),
            @ApiResponse(description = "No content", responseCode = "204")
    })
    public List<FileLoadResponse> searchFileLoads(SearchCriteria searchCriteriaDTO) {
        return fileLoadService.searchFileLoads(searchCriteriaDTO);
    }

    // Update the status of a file load
    @PutMapping("/{id}/status")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Update the status of a file load", responses = {
            @ApiResponse(description = "File load status updated", responseCode = "200"),
            @ApiResponse(description = "File load not found", responseCode = "404")
    })
    public void updateFileLoadStatus(@PathVariable Long id, @RequestBody String status) {
        fileLoadService.updateFileLoadStatus(id, status);
    }

    // Delete a file load
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete a file load", responses = {
            @ApiResponse(description = "File load deleted", responseCode = "200"),
            @ApiResponse(description = "File load not found", responseCode = "404")
    })
    public void deleteFileLoad(@PathVariable Long id) {
        fileLoadService.deleteFileLoad(id);
    }

    // Archive a file load
    @PostMapping("/{id}/archive")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Archive a file load", responses = {
            @ApiResponse(description = "File load archived", responseCode = "200"),
            @ApiResponse(description = "File load not found", responseCode = "404")
    })
    public void archiveFileLoad(@PathVariable Long id) {
        fileLoadService.archiveFileLoad(id);
    }
}