package com.spring.mvc.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class})
    public final ResponseEntity<Object> handleExceptionGlobal(Exception ex, WebRequest request) throws Exception {
        System.out.println("Exception has happened.");
        return ResponseEntity.ok("There is a Exception");
    }

}
