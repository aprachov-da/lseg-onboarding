package com.dataart.lseg.controller;

import com.dataart.lseg.exception.ErrorMessage;
import com.dataart.lseg.exception.LicenseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class LsegOnboardingExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(LicenseNotFoundException.class)
    protected ResponseEntity<ErrorMessage> handleLicenseNotFoundException(LicenseNotFoundException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}
