package io.pragra.learning.classscheduling.controller;

import io.pragra.learning.classscheduling.exception.BadRequestException;
import io.pragra.learning.classscheduling.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BlogExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> notFound(NotFoundException ex, WebRequest request){
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("NO ID", "Please make sure that the id is passed in the body"));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequest(){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse("NO ID", "Please make sure that the id is passed in the body"));
    }
}
