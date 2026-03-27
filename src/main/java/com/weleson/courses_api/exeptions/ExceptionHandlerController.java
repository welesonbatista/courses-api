package com.weleson.courses_api.exeptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

  @Autowired
  private MessageSource messageSource;

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<ErrorMessageDTO>> handleValidation(MethodArgumentNotValidException ex) {
    List<ErrorMessageDTO> errors = new ArrayList<>();
    ex.getBindingResult().getFieldErrors().forEach(error -> {
      String message = messageSource.getMessage(error, null);
      errors.add(new ErrorMessageDTO(message, error.getField()));
    });
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorMessageDTO> handleGeneric(Exception ex) {
    ErrorMessageDTO error = new ErrorMessageDTO("Internal server error", null);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
  }
}