package com.mphasis.tflms.apiresponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private LocalDateTime timestamp;
    private String status;
    private int statusCode;
    private String message;
    private T data;

    // Extra constructor for responses without data
    public ApiResponse(LocalDateTime timestamp, String status, int statusCode, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.statusCode = statusCode;
        this.message = message;
    }
}
