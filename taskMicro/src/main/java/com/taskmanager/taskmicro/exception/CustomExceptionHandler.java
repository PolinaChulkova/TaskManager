package com.taskmanager.taskmicro.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;
import java.util.TreeMap;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<Map<String, Object>> illegalArgumentException(IllegalArgumentException ex,
                                                                        HttpServletRequest request) {
        final Map<String, Object> body = new TreeMap<>();
        body.put("status", HttpStatus.BAD_REQUEST);
        body.put("error", "IllegalArgumentException");
        body.put("message", ex.getMessage());
        body.put("details", "Измените id в запросе.");
        body.put("path", request.getContextPath());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Map<String, Object>> handleDefaultException(Exception ex,
                                                                      HttpServletRequest request) {
        final Map<String, Object> body = new TreeMap<>();
        body.put("status", HttpStatus.SERVICE_UNAVAILABLE);
        body.put("error", ex.getClass());
        body.put("message", ex.getMessage());
        body.put("details", "Что-то пошло не так");
        body.put("path", request.getContextPath());

        return new ResponseEntity<>(body, HttpStatus.SERVICE_UNAVAILABLE);
    }
}
