package com.sagar.projects.Student.Management.App.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> notFoundHandler(ResourceNotFoundException ex) {
        // Use a generic Map to store different value types
        Map<String, Object> map = new HashMap<>();
        map.put("message", ex.getMessage());
        map.put("success", false); // Corrected key to lowercase
        map.put("status", HttpStatus.NOT_FOUND); // This will return an object, not the int value

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
}