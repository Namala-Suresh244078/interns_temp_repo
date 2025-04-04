package com.mphasis.tflms.searchcriteriadto;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;
@Data
public class SearchCriteria {
    @Min(value = 1, message = "ID must be a positive number")
    private Long id;
    @NotBlank(message = "File name cannot be blank")
    @Size(min = 4, max = 30, message = "File name must be between 4 and 30 characters")
    private String fileName;
    @NotNull(message = "Status cannot be null")
    @Pattern(regexp = "PENDING|PROCESSED|FAILED", message = "Status must be PENDING, PROCESSED, or FAILED")
    private String status;
    @NotNull
    private LocalDateTime startDate;
    @NotNull
    private LocalDateTime endDate;
}