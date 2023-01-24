package com.codeninjas.productservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@AllArgsConstructor
@Data
public class ErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    private String details;
}
