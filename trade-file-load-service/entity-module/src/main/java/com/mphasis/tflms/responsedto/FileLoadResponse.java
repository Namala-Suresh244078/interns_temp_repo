package com.mphasis.tflms.responsedto;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class FileLoadResponse {
    @Min(value = 1, message = "ID must be a positive number")
    private Long id;
    @NotBlank(message = "File name cannot be blank")
    private String fileName;
    @NotBlank(message = "Status cannot be blank")
    @Pattern(regexp = "^(PENDING|COMPLETED|FAILED)$", message = "Status must be PENDING, COMPLETED, or FAILED")
    private String status;
    @NotNull
    private LocalDateTime fileUploadedDate;
    private String error;
}