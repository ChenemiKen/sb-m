package com.chenemiken.departmentservice.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler
  public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
      WebRequest webRequest){
    ErrorDetails errorDetails = new ErrorDetails(
        LocalDateTime.now(),
        HttpStatus.NOT_FOUND.value(),
        exception.getMessage(),
        webRequest.getDescription(false)
    );
    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler
  public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception, WebRequest webRequest){
    ErrorDetails errorDetails = new ErrorDetails(
        LocalDateTime.now(),
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        exception.getMessage(),
        webRequest.getDescription(false)
    );
    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
