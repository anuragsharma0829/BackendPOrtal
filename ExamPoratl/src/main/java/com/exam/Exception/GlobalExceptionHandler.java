package com.exam.Exception;


import com.exam.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resoursceNotFoundExceptionHandler(ResourceNotFoundException ex) {

        String message = ex.getMessage();
        ApiResponse apiResponse = new ApiResponse(message, false,null);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

}
