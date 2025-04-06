package com.mphasis.tflms.requestdto;
import jakarta.validation.constraints.*;  // Import validation annotations
import lombok.*;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class FileLoadRequest {
    @NotBlank(message = "File name cannot be blank")
    @Size(min = 4, max = 30, message = "File name must be between 4 and 30 characters")
    private String fileName;
    @NotNull(message = "Load date cannot be null")
    private LocalDateTime loadDate;
    @NotNull(message = "Record count cannot be null")
    @Positive(message = "Record count must be positive")
    private Integer recordCount;
    @NotBlank(message = "File type cannot be blank")
    @Pattern(regexp = "csv|json|xml", message = "File type must be csv, json, or xml")
    private String fileType;
}