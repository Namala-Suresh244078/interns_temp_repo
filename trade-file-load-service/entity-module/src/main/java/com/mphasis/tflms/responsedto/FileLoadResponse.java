package com.mphasis.tflms.responsedto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class FileLoadResponse {
    private Long id;
    private String fileName;
    private String status;
    private LocalDateTime fileUploadedDate;
    private String error;
}
