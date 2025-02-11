package com.example.LabApi.exception;

import com.example.LabApi.dto.StudentErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException studentNotFoundException){
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        studentErrorResponse.setMessage(String.valueOf(studentNotFoundException.getMessage()));
        studentErrorResponse.setTimeStap(System.currentTimeMillis());
        return new ResponseEntity<>(studentErrorResponse,HttpStatus.NOT_FOUND);
    }
}
